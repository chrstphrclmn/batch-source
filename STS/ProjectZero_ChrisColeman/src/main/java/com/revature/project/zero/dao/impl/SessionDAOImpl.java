package com.revature.project.zero.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.project.zero.ConnectionUtil;
import com.revature.project.zero.dao.SessionDAO;
import com.revature.project.zero.model.Session;

public class SessionDAOImpl implements SessionDAO{

	@Override
	public List<Session> getSessions() {

		String sql = "select * from session";
		
		List<Session> sessions = new ArrayList<>();
		
		try (Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			
			while(rs.next()) {
				String userName = rs.getString("username");
				int accountNum = rs.getInt("accountnum");
				Session a = new Session(accountNum, userName);
				sessions.add(a);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return sessions;
		
	}

	

	@Override
	public int createSession(Session session) {


		int sessionsCreated = 0;
		String sql = "insert into session (accountnum, username) values (?, ?)";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setInt(1, session.getAccountNum());
			ps.setString(2, session.getUsername());
			
			sessionsCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return sessionsCreated;
		
	}



	@Override
	public int deleteSession(Session session) {

		int rowsDeleted = 0;
		String sql = "delete from session where username = ? and accountnum = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, session.getUsername());
			ps.setInt(2, session.getAccountNum());
			rowsDeleted = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowsDeleted;
		
	}



	@Override
	public Session getSessionByUsername(String username) {


		String sql = "select * from session where username = ?";
		Session a = null;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, username); 
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String userName = rs.getString("username");
				int accountNum = rs.getInt("accountnum");
				a = new Session(accountNum, userName);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return a;
		
	}



	@Override
	public Session getSessionByAccount(int accountNum) {

		String sql = "select * from session where accountnum = ?";
		Session a = null;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setInt(1, accountNum); 
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String userName = rs.getString("username");
				int accountNums = rs.getInt("accountnum");
				a = new Session(accountNums, userName);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return a;
		
		
	}

}
