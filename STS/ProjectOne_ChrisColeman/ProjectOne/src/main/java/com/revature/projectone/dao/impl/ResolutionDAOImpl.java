package com.revature.projectone.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.projectone.dao.ResolutionDAO;
import com.revature.projectone.model.Resolution;
import com.revature.projectone.util.ConnectionUtil;

public class ResolutionDAOImpl implements ResolutionDAO {

	public List<Resolution> getResolutions() {

		String sql = "select * from resolution";
		
		List<Resolution> resolutions = new ArrayList<>();
		
		try (Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			
			while(rs.next()) {
				int resId = rs.getInt("request_id");
				String manUsername = rs.getString("manager_username");
				boolean decision = rs.getBoolean("decision");
				String reason = rs.getString("reason");
				Resolution a = new Resolution(resId, manUsername, decision, reason);
				resolutions.add(a);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resolutions;
		
	}

	public Resolution getResolutionById(int id) {
		String sql = "select * from resolution where request_id = ?";
		Resolution a = null;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setInt(1, id); // jdbc 1 based index
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int resId = rs.getInt("request_id");
				String manUsername = rs.getString("manager_username");
				boolean decision = rs.getBoolean("decision");
				String reason = rs.getString("reason");
				a = new Resolution(resId, manUsername, decision, reason);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return a;
	}

	public int createResolution(Resolution res) {

		int resolutionsCreated = 0;
		String sql = "insert into resolution (request_id, manager_username, decision, reason) values (?, ?, ?, ?)";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setInt(1,  res.getRequestId());
			ps.setString(2,  res.getManagerUsername());
			ps.setBoolean(3,  res.isDecision());
			ps.setString(4,  res.getReason());
			
			resolutionsCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resolutionsCreated;
		
	}

	public int updateResolution(Resolution res) {

		int resolutionsUpdated = 0;
		String sql = "update resolution "
				+ "set manager_username = ?, "
				+ "decision = ?, "
				+ "reason = ? "
				+ "where request_id = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, res.getManagerUsername());
			ps.setBoolean(2, res.isDecision());
			ps.setString(3, res.getReason());
			ps.setInt(4, res.getRequestId());
			
			resolutionsUpdated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return resolutionsUpdated;
		
	}

}
