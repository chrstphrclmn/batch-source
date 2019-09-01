package com.revature.project.zero.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.project.zero.ConnectionUtil;
import com.revature.project.zero.dao.LoginDAO;
import com.revature.project.zero.model.Login;

public class LoginDAOImpl implements LoginDAO {

	@Override
	public List<Login> getLogins() {


		String sql = "select * from login";
		
		List<Login> logins = new ArrayList<>();
		
		try (Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			
			while(rs.next()) {
				String userName = rs.getString("username");
				String passWord = rs.getString("password");
				Login a = new Login(userName, passWord);
				logins.add(a);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return logins;
		
	}

	@Override
	public Login getLoginByUsername(String username) {

		String sql = "select * from login where username = ?";
		Login a = null;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, username); // jdbc 1 based index
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String userName = rs.getString("username");
				String passWord = rs.getString("password");
				a = new Login(userName, passWord);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return a;
		
	}

	@Override
	public int createLogin(Login login) {

		int loginsCreated = 0;
		String sql = "insert into login (username, password) values (?, ?)";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, login.getUsername());
			ps.setString(2, login.getPassword());
			
			loginsCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return loginsCreated;
		
	}

	@Override
	public int updateLogin(Login login) {

		int loginsUpdated = 0;
		String sql = "update login "
				+ "set password = ? "
				+ "where username = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, login.getPassword());
			ps.setString(2, login.getUsername());

			
			loginsUpdated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return loginsUpdated;
		
	}

	@Override
	public int deleteLogin(Login login) {

		int rowsDeleted = 0;
		String sql = "delete from login where username = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, login.getUsername());
			rowsDeleted = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowsDeleted;
		
	}
		
	}


