package com.revature.bankingapp.sysoutgui.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.bankingapp.sysoutgui.dao.SubAccountDAO;
import com.revature.bankingapp.sysoutgui.model.SubAccount;
import com.revature.bankingapp.sysoutgui.security.DatabaseCredentials;

public class SubAccountDAOImpl implements SubAccountDAO {

	private final String[] databaseColumns = { "id", "type", "amount", "account_id" };
	private static Logger logger = LogManager.getLogger();

	@Override
	public Optional<SubAccount> findById(long id) {
		Optional<SubAccount> subaccountOptional = Optional.empty();
		String query = "SELECT * FROM subaccounts WHERE id=?";
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass()); PreparedStatement stmt = conn.prepareStatement(query);) {
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Long subaccountId = rs.getLong(databaseColumns[0]);
				String type = rs.getString(databaseColumns[1]);
				Double amount = rs.getDouble(databaseColumns[2]);
				Long accountId = rs.getLong(databaseColumns[3]);
				SubAccount subaccount = new SubAccount(subaccountId, type, amount, accountId);
				subaccountOptional = Optional.of(subaccount);
			}
			rs.close();
		} catch (SQLException e) {
			logger.error(e.getStackTrace());
		}
		return subaccountOptional;
	}

	@Override
	public List<SubAccount> findAll() {
		List<SubAccount> subAccounts = new ArrayList<SubAccount>();
		String query = "SELECT * FROM subaccounts";
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass());
				Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.TYPE_SCROLL_SENSITIVE);
				ResultSet rs = stmt.executeQuery(query);) {
			while (rs.next()) {
				Long subaccountId = rs.getLong(databaseColumns[0]);
				String type = rs.getString(databaseColumns[1]);
				Double amount = rs.getDouble(databaseColumns[2]);
				Long accountId = rs.getLong(databaseColumns[3]);
				SubAccount subaccount = new SubAccount(subaccountId, type, amount, accountId);
				subAccounts.add(subaccount);
			}
		} catch (SQLException e) {
			logger.error(e.getStackTrace());
		}
		return subAccounts;
	}

	@Override
	public List<SubAccount> findAllById(long id) {
		List<SubAccount> subAccounts = new ArrayList<SubAccount>();
		String query = "SELECT * FROM subaccounts WHERE account_id=?";
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass()); PreparedStatement stmt = conn.prepareStatement(query);) {
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Long subaccountId = rs.getLong(databaseColumns[0]);
				String type = rs.getString(databaseColumns[1]);
				Double amount = rs.getDouble(databaseColumns[2]);
				Long accountId = rs.getLong(databaseColumns[3]);
				SubAccount subaccount = new SubAccount(subaccountId, type, amount, accountId);
				subAccounts.add(subaccount);
			}
			rs.close();
		} catch (SQLException e) {
			logger.error(e.getStackTrace());
		}
		return subAccounts;
	}

	@Override
	public Long save(SubAccount subAccount) {
		String sQuery = "INSERT INTO subaccounts values(default,?,?,?)";
		String tQuery = "INSERT INTO transaction_histories values(default,?,?)";
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass());
				PreparedStatement subaccountStmt = conn.prepareStatement(sQuery, Statement.RETURN_GENERATED_KEYS);
				PreparedStatement tHistoryStmt = conn.prepareStatement(tQuery, Statement.RETURN_GENERATED_KEYS)) {
			// start transaction block
			conn.setAutoCommit(false);

			// Subaccount
			subaccountStmt.setString(1, subAccount.getType());
			subaccountStmt.setDouble(2, subAccount.getAmount());
			subaccountStmt.setLong(3, subAccount.getAccountId());

			int i = subaccountStmt.executeUpdate();

			try (ResultSet generatedKeys = subaccountStmt.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					subAccount.setId(generatedKeys.getLong("id"));
				} else {
					throw new SQLException("Creating subAccount failed, no ID obtained.");
				}
			}

			String historyMessage = LocalDateTime.now() + " " + subAccount.getType() + "Account  " + subAccount.getId()
					+ " was created. Current funds are: $" + subAccount.getAmount();

			// Transaction History
			tHistoryStmt.setString(1, historyMessage);
			tHistoryStmt.setLong(2, subAccount.getId());

			int j = tHistoryStmt.executeUpdate();

			try (ResultSet generatedKeys = tHistoryStmt.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					generatedKeys.getLong("id");
					logger.info(j + i + " records inserted");
				} else {
					throw new SQLException("Creating TransactionHistory failed, no ID obtained.");
				}
			}

			// end transaction block, commit changes
			conn.commit();
			conn.setAutoCommit(true);

		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return subAccount.getId();
	}

	@Override
	public void update(SubAccount subAccount) {
		String query = "UPDATE subaccounts SET type= ?, amount=?, account_id=? WHERE id=?";
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass()); PreparedStatement stmt = conn.prepareStatement(query);) {
			stmt.setString(1, subAccount.getType());
			stmt.setDouble(2, subAccount.getAmount());
			stmt.setLong(3, subAccount.getAccountId());
			stmt.setLong(4, subAccount.getId());
			int i = stmt.executeUpdate();
			logger.info(i + " records updated");
		} catch (SQLException e) {
			logger.error(e.getStackTrace());
		}
	}

	@Override
	public void delete(SubAccount subAccount) {
		String query = "DELETE FROM subaccounts WHERE id=?";
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass()); PreparedStatement stmt = conn.prepareStatement(query);) {
			stmt.setLong(1, subAccount.getId());
			int i = stmt.executeUpdate();
			logger.info(i + " records deleted");
		} catch (SQLException e) {
			logger.error(e.getStackTrace());
		}
	}

	@Override
	public void updateTransfer(SubAccount subAccount1, SubAccount subAccount2) {
		String query = "UPDATE subaccounts SET type= ?, amount=?, account_id=? WHERE id=?";
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass());
				PreparedStatement subaccount1_stmt = conn.prepareStatement(query);
				PreparedStatement subaccount2_stmt = conn.prepareStatement(query)) {

			// start transaction block
			conn.setAutoCommit(false);

			// SubAccount 1
			subaccount1_stmt.setString(1, subAccount1.getType());
			subaccount1_stmt.setDouble(2, subAccount1.getAmount());
			subaccount1_stmt.setLong(3, subAccount1.getAccountId());
			subaccount1_stmt.setLong(4, subAccount1.getId());
			subaccount1_stmt.executeUpdate();

			// SubAccount 2
			subaccount2_stmt.setString(1, subAccount2.getType());
			subaccount2_stmt.setDouble(2, subAccount2.getAmount());
			subaccount2_stmt.setLong(3, subAccount2.getAccountId());
			subaccount2_stmt.setLong(4, subAccount2.getId());
			subaccount2_stmt.executeUpdate();

			// end transaction block, commit changes
			conn.commit();
			conn.setAutoCommit(true);

		} catch (SQLException e) {
			logger.error(e.getStackTrace());
		}
	}

}
