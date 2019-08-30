package com.revature.bankingapp.sysoutgui.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.Logger;

import com.revature.bankingapp.sysoutgui.dao.SubAccountDAO;
import com.revature.bankingapp.sysoutgui.model.SubAccount;
import com.revature.bankingapp.sysoutgui.security.DatabaseCredentials;
import com.revature.bankingapp.sysoutgui.util.ApplicationLogger;

public class SubAccountDAOImpl implements SubAccountDAO {

	private final String[] databaseColumns = { "id", "type", "amount", "account_id" };
	private static Logger logger = ApplicationLogger.getLogger();

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
			e.printStackTrace();
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
			e.printStackTrace();
		}
		return subAccounts;
	}

	@Override
	public void save(SubAccount subAccount) {
		String query = "INSERT INTO subaccounts values(default,?,?,?)";
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass()); PreparedStatement stmt = conn.prepareStatement(query);) {
			stmt.setString(1, subAccount.getType());
			stmt.setDouble(2, subAccount.getAmount());
			stmt.setLong(3, subAccount.getAccountId());

			int i = stmt.executeUpdate();
			logger.info(i + " records inserted");

		} catch (SQLException e) {
			e.printStackTrace();
		}
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
			e.printStackTrace();
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
			e.printStackTrace();
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

			// good practice to set it back to default true
			conn.setAutoCommit(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
