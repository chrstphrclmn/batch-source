package com.revature.projectone.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.revature.projectone.dao.LoginDAO;
import com.revature.projectone.model.Login;
import com.revature.projectone.util.ConnectionUtil;

public class LoginDAOImpl implements LoginDAO{

	public List<Login> getLogins() {
		
	String sql = "select * from login";
		
	List<Login> logins = new ArrayList<>();
		
	try (Connection c = ConnectionUtil.getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);){
			
		while(rs.next()) {
			String username = rs.getString("username");
			String password = rs.getString("password");
			boolean position = rs.getBoolean("position");
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			String title = rs.getString("title");
			String email = rs.getString("email");
			String phone = rs.getString("phone");
			Login a = new Login(username, password, position, firstName, lastName, title, email, phone);
			logins.add(a);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return logins;
		
	}

	public Login getLoginByUsername(String username) {
		
		String sql = "select * from login where username = ?";
		Login a = null;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, username); // jdbc 1 based index
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String userName = rs.getString("username");
				String password = rs.getString("password");
				boolean position = rs.getBoolean("position");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String title = rs.getString("title");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				a = new Login(userName, password, position, firstName, lastName, title, email, phone);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return a;
	}

	public int createLogin(Login login) {
		int loginsCreated = 0;
		String sql = "insert into login (username, password, position, first_name, last_name, title, email, phone) values (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, login.getUsername());
			ps.setString(2, login.getPassword());
			ps.setBoolean(3, login.isManager());
			ps.setString(4, login.getFirstName());
			ps.setString(5, login.getLastName());
			ps.setString(6, login.getTitle());
			ps.setString(7, login.getEmail());
			ps.setString(8, login.getPhone());
			
			loginsCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return loginsCreated;
	}

	public int updateLogin(Login login) {

		int loginsUpdated = 0;
		String sql = "update login "
				+ "set password = ?, "
				+ "position = ?, "
				+ "first_name = ?, "
				+ "last_name = ?, "
				+ "title = ?, "
				+ "email = ?, "
				+ "phone = ? "
				+ "where username = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, login.getPassword());
			ps.setBoolean(2, login.isManager());
			ps.setString(3, login.getFirstName());
			ps.setString(4, login.getLastName());
			ps.setString(5, login.getTitle());
			ps.setString(6, login.getEmail());
			ps.setString(7, login.getPhone());
			ps.setString(8, login.getUsername());
			
			loginsUpdated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return loginsUpdated;
		
	}

}
