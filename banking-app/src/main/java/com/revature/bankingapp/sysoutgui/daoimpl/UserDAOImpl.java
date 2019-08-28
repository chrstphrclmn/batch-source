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

import com.revature.bankingapp.sysoutgui.dao.UserDAO;
import com.revature.bankingapp.sysoutgui.model.User;
import com.revature.bankingapp.sysoutgui.security.DatabaseCredentials;

public class UserDAOImpl implements UserDAO {

	@Override
	public Optional<User> findById(long id) {
		Optional<User> userOptional = Optional.empty();
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass());) {
			String query = "SELECT * FROM users WHERE id=" + id;
			Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.TYPE_SCROLL_SENSITIVE);
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Long userId = rs.getLong("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String email = rs.getString("email");
				User user = new User(userId, firstName, lastName, email);
				userOptional = Optional.of(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userOptional;
	}

	@Override
	public Optional<User> findByEmail(String emailAddress) {
		Optional<User> userOptional = Optional.empty();
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass());) {
			String query = "SELECT * FROM users WHERE email='" + emailAddress + "'";
			Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.TYPE_SCROLL_SENSITIVE);
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Long userId = rs.getLong("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String email = rs.getString("email");
				User user = new User(userId, firstName, lastName, email);
				userOptional = Optional.of(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userOptional;
	}
	
	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass());) {
			String query = "SELECT * FROM users";
			Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.TYPE_SCROLL_SENSITIVE);
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Long userId = rs.getLong("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String email = rs.getString("email");
				User user = new User(userId, firstName, lastName, email);
				users.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public void save(User user) {
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass());) {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO users values(default,?,?,?)");
			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setString(3, user.getEmail());

			int i = stmt.executeUpdate();
			System.out.println(i + " records inserted");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(User user, String[] params) {
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass());) {
			PreparedStatement stmt = conn
					.prepareStatement("UPDATE users SET first_name= ?, last_name=?, email=? WHERE id=?");
			for (int i = 0; i < params.length; i++) {
				stmt.setString(i + 1, params[i]);
			}
			stmt.setLong(4, user.getId());
			int i = stmt.executeUpdate();
			System.out.println(i + " records updated");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(User user) {
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass());) {
			Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.TYPE_SCROLL_SENSITIVE);
			String del = "DELETE FROM users WHERE id=" + "'" + user.getId() + "'";
			stmt.executeUpdate(del);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
