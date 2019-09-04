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

import com.revature.bankingapp.sysoutgui.dao.UserDAO;
import com.revature.bankingapp.sysoutgui.model.User;
import com.revature.bankingapp.sysoutgui.security.DatabaseCredentials;

public class UserDAOImpl implements UserDAO {

	private final String[] databaseColumns = { "id", "first_name", "last_name", "email" };
	private static Logger logger = LogManager.getLogger();
	
	@Override
	public Optional<User> findById(long id) {
		Optional<User> userOptional = Optional.empty();
		String query = "SELECT * FROM users WHERE id=?";
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass()); PreparedStatement stmt = conn.prepareStatement(query);) {
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Long userId = rs.getLong(databaseColumns[0]);
				String firstName = rs.getString(databaseColumns[1]);
				String lastName = rs.getString(databaseColumns[2]);
				String email = rs.getString(databaseColumns[3]);
				User user = new User(userId, firstName, lastName, email);
				userOptional = Optional.of(user);
			}
			rs.close();
		} catch (SQLException e) {
			logger.error(e);
		}
		return userOptional;
	}

	@Override
	public Optional<User> findByEmail(String emailAddress) {
		Optional<User> userOptional = Optional.empty();
		String query = "SELECT * FROM users WHERE email=?";
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass()); PreparedStatement stmt = conn.prepareStatement(query);) {
			stmt.setString(1, emailAddress);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Long userId = rs.getLong(databaseColumns[0]);
				String firstName = rs.getString(databaseColumns[1]);
				String lastName = rs.getString(databaseColumns[2]);
				String email = rs.getString(databaseColumns[3]);
				User user = new User(userId, firstName, lastName, email);
				userOptional = Optional.of(user);
			}
			rs.close();
		} catch (SQLException e) {
			logger.error(e);
		}
		return userOptional;
	}

	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		String query = "SELECT * FROM users";
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass());
				Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.TYPE_SCROLL_SENSITIVE);
				ResultSet rs = stmt.executeQuery(query);) {	
			while (rs.next()) {
				Long userId = rs.getLong(databaseColumns[0]);
				String firstName = rs.getString(databaseColumns[1]);
				String lastName = rs.getString(databaseColumns[2]);
				String email = rs.getString(databaseColumns[3]);
				User user = new User(userId, firstName, lastName, email);
				users.add(user);
			}
		} catch (SQLException e) {
			logger.error(e);
		}
		return users;
	}

	@Override
	public Long save(User user) {
		String query = "INSERT INTO users values(default,?,?,?)";
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass());PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);) {
			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setString(3, user.getEmail());

			int i = stmt.executeUpdate();

			try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	            	user.setId(generatedKeys.getLong("id"));
	            	logger.info(i + " records inserted");
	            }
	            else {
	                throw new SQLException("Creating User failed, no ID obtained.");
	            }
	        }
			
		} catch (SQLException e) {
			logger.error(e);
		}
		
		return user.getId();
	}

	@Override
	public void update(User user) {
		String query = "UPDATE users SET first_name= ?, last_name=?, email=? WHERE id=?";
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass());PreparedStatement stmt = conn
				.prepareStatement(query);) {
			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setString(3, user.getEmail());
			stmt.setLong(4, user.getId());
			int i = stmt.executeUpdate();
			logger.info(i + " records updated");
		} catch (SQLException e) {
			logger.error(e);
		}
	}

	@Override
	public void delete(User user) {
		String query  = "DELETE FROM users WHERE id=?";
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass());PreparedStatement stmt = conn.prepareStatement(query);) {
			stmt.setLong(1, user.getId());
			int i = stmt.executeUpdate();
			logger.info(i + " records deleted");
		} catch (SQLException e) {
			logger.error(e);
		}

	}

}
