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

import com.revature.bankingapp.sysoutgui.dao.AccountDAO;
import com.revature.bankingapp.sysoutgui.model.Account;
import com.revature.bankingapp.sysoutgui.security.DatabaseCredentials;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public Optional<Account> findById(long id) {
		Optional<Account> accountOptional = Optional.empty();
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass());) {
			String query = "SELECT * FROM accounts WHERE id=" + id;
			Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.TYPE_SCROLL_SENSITIVE);
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Long accountId = rs.getLong("id");
				Long userId = rs.getLong("user_id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				Account account = new Account(accountId, username, password, userId);
				accountOptional = Optional.of(account);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountOptional;
	}

	@Override
	public Optional<Account> findByUsername(String usernameInput) {
		Optional<Account> accountOptional = Optional.empty();
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass());) {
			String query = "SELECT * FROM accounts WHERE username='" + usernameInput +"'";
			Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.TYPE_SCROLL_SENSITIVE);
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Long accountId = rs.getLong("id");
				Long userId = rs.getLong("user_id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				Account account = new Account(accountId, username, password, userId);
				accountOptional = Optional.of(account);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountOptional;
	}
	
	@Override
	public List<Account> findAll() {
		List<Account> accounts = new ArrayList<Account>();
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass());) {
			String query = "SELECT * FROM accounts";
			Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.TYPE_SCROLL_SENSITIVE);
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Long accountId = rs.getLong("id");
				Long userId = rs.getLong("user_id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				Account account = new Account(accountId, username, password, userId);
				accounts.add(account);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public void save(Account account) {
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass());) {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO accounts values(default,?,?,?)");
			stmt.setString(1, account.getUsername());
			stmt.setString(2, account.getPassword());
			stmt.setLong(3, account.getUserId());

			int i = stmt.executeUpdate();
			System.out.println(i + " records inserted");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Account account, String[] params) {
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass());) {
			PreparedStatement stmt = conn
					.prepareStatement("UPDATE accounts SET username= ?, password=?, user_id=? WHERE id=?");
			for (int i = 0; i < params.length; i++) {
				stmt.setString(i + 1, params[i]);
			}
			stmt.setLong(4, account.getId());
			int i = stmt.executeUpdate();
			System.out.println(i + " records updated");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Account account) {
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass());) {
			Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.TYPE_SCROLL_SENSITIVE);
			String del = "DELETE FROM accounts WHERE id=" + "'" + account.getId() + "'";
			stmt.executeUpdate(del);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
