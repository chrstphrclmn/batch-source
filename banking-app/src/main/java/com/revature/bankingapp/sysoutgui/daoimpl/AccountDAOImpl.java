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
			logger.error(e.getStackTrace());
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
			logger.error(e.getStackTrace());
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
			logger.error(e.getStackTrace());
		}
		return accounts;
	}

	@Override
	public Long save(Account account) {
		String query = "INSERT INTO accounts values(default,?,?,?)";
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass()); PreparedStatement stmt = conn.prepareStatement(query);) {
			stmt.setString(1, account.getUsername());
			stmt.setString(2, account.getPassword());
			stmt.setLong(3, account.getUserId());

			int i = stmt.executeUpdate();

			try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	            	account.setId(generatedKeys.getLong("id"));
	            	logger.info(i + " records inserted");
	            }
	            else {
	                throw new SQLException("Creating Account failed, no ID obtained.");
	            }
	        }
			
		} catch (SQLException e) {
			logger.error(e.getStackTrace());
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
			logger.error(e.getStackTrace());
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
			logger.error(e.getStackTrace());
		}
	}

}
