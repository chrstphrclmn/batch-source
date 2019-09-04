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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.bankingapp.sysoutgui.dao.AccountDAO;
import com.revature.bankingapp.sysoutgui.model.Account;
import com.revature.bankingapp.sysoutgui.model.User;
import com.revature.bankingapp.sysoutgui.security.DatabaseCredentials;

public class AccountDAOImpl implements AccountDAO {

	private final String[] databaseColumns = { "id", "username", "password", "user_id" };
	private static Logger logger = LogManager.getLogger();

	@Override
	public Optional<Account> findById(long id) {
		Optional<Account> accountOptional = Optional.empty();
		String query = "SELECT * FROM accounts WHERE id=?";
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass()); PreparedStatement stmt = conn.prepareStatement(query);) {
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Long accountId = rs.getLong(databaseColumns[0]);
				String username = rs.getString(databaseColumns[1]);
				String password = rs.getString(databaseColumns[2]);
				Long userId = rs.getLong(databaseColumns[3]);
				Account account = new Account(accountId, username, password, userId);
				accountOptional = Optional.of(account);
			}
			rs.close();
		} catch (SQLException e) {
			logger.error(e);
		}
		return accountOptional;
	}

	@Override
	public Optional<Account> findByUsername(String usernameInput) {
		Optional<Account> accountOptional = Optional.empty();
		String query = "SELECT * FROM accounts WHERE username=?";
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass()); PreparedStatement stmt = conn.prepareStatement(query);) {
			stmt.setString(1, usernameInput);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Long accountId = rs.getLong(databaseColumns[0]);
				String username = rs.getString(databaseColumns[1]);
				String password = rs.getString(databaseColumns[2]);
				Long userId = rs.getLong(databaseColumns[3]);
				Account account = new Account(accountId, username, password, userId);
				accountOptional = Optional.of(account);
			}
			rs.close();
		} catch (SQLException e) {
			logger.error(e);
		}
		return accountOptional;
	}

	@Override
	public List<Account> findAll() {
		List<Account> accounts = new ArrayList<Account>();
		String query = "SELECT * FROM accounts";
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass());
				Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.TYPE_SCROLL_SENSITIVE);
				ResultSet rs = stmt.executeQuery(query);) {
			while (rs.next()) {
				Long accountId = rs.getLong(databaseColumns[0]);
				String username = rs.getString(databaseColumns[1]);
				String password = rs.getString(databaseColumns[2]);
				Long userId = rs.getLong(databaseColumns[3]);
				Account account = new Account(accountId, username, password, userId);
				accounts.add(account);
			}
		} catch (SQLException e) {
			logger.error(e);
		}
		return accounts;
	}

	@Override
	public Long save(Account account) {
		String query = "INSERT INTO accounts values(default,?,?,?)";
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass());
				PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);) {
			stmt.setString(1, account.getUsername());
			stmt.setString(2, account.getPassword());
			stmt.setLong(3, account.getUserId());

			int i = stmt.executeUpdate();

			try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					account.setId(generatedKeys.getLong("id"));
					logger.info(i + " records inserted");
				} else {
					throw new SQLException("Creating Account failed, no ID obtained.");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		}

		return account.getId();
	}

	@Override
	public Long save(User user, Account account) {
		String uQuery = "INSERT INTO users values(default,?,?,?)";
		String aQuery = "INSERT INTO accounts values(default,?,?,?)";
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass());
				PreparedStatement userStmt = conn.prepareStatement(uQuery, Statement.RETURN_GENERATED_KEYS);
				PreparedStatement accountStmt = conn.prepareStatement(aQuery, Statement.RETURN_GENERATED_KEYS)) {
			// start transaction block
			conn.setAutoCommit(false);

			// User
			userStmt.setString(1, user.getFirstName());
			userStmt.setString(2, user.getLastName());
			userStmt.setString(3, user.getEmail());

			int i = userStmt.executeUpdate();

			try (ResultSet generatedKeys = userStmt.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					user.setId(generatedKeys.getLong("id"));
					logger.info(i + " records inserted");
				} else {
					throw new SQLException("Creating User failed, no ID obtained.");
				}
			}

			// Account
			accountStmt.setString(1, account.getUsername());
			accountStmt.setString(2, account.getPassword());
			accountStmt.setLong(3, user.getId());

			int j = accountStmt.executeUpdate();

			try (ResultSet generatedKeys = accountStmt.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					account.setId(generatedKeys.getLong("id"));
					logger.info(j + " records inserted");
				} else {
					throw new SQLException("Creating Account failed, no ID obtained.");
				}
			}
			// end transaction block, commit changes
			conn.commit();
			conn.setAutoCommit(true);

		} catch (SQLException e) {
			logger.error(e);
		}
		return account.getId();
	}

	@Override
	public void update(Account account) {
		String query = "UPDATE accounts SET username= ?, password=?, user_id=? WHERE id=?";
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass()); PreparedStatement stmt = conn.prepareStatement(query);) {
			stmt.setString(1, account.getUsername());
			stmt.setString(2, account.getPassword());
			stmt.setLong(3, account.getUserId());
			stmt.setLong(4, account.getId());
			int i = stmt.executeUpdate();
			logger.info(i + " records updated");
		} catch (SQLException e) {
			logger.error(e);
		}
	}

	@Override
	public void delete(Account account) {
		String query = "DELETE FROM accounts WHERE id=?";
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass()); PreparedStatement stmt = conn.prepareStatement(query);) {
			stmt.setLong(1, account.getId());
			int i = stmt.executeUpdate();
			logger.info(i + " records deleted");
		} catch (SQLException e) {
			logger.error(e);
		}
	}

}
