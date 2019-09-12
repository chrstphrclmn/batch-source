package com.revature.projectone.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.projectone.dao.RequestDAO;
import com.revature.projectone.model.Request;
import com.revature.projectone.util.ConnectionUtil;

public class RequestDAOImpl implements RequestDAO {

	public List<Request> getRequests() {
		String sql = "select * from request";
		
		List<Request> requests = new ArrayList<>();
		
		try (Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			
			while(rs.next()) {
				int requestId = rs.getInt("request_id");
				String submitter = rs.getString("submitted_by");
				double amount = rs.getDouble("amount");
				Request a = new Request(requestId, submitter, amount);
				requests.add(a);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return requests;
		
	}

	public Request getRequestById(int requestId) {

		String sql = "select * from request where request_id = ?";
		Request a = null;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setInt(1, requestId); // jdbc 1 based index
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int requestID = rs.getInt("request_id");
				String submitter = rs.getString("submitted_by");
				double amount = rs.getDouble("amount");
				a = new Request(requestID, submitter, amount);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return a;
		
	}

	public int createRequest(Request request) {

		int requestsCreated = 0;
		String sql = "insert into request (request_id, submitted_by, amount) values (?, ?, ?)";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setInt(1, request.getRequestId());
			ps.setString(2, request.getUsername());
			ps.setDouble(3, request.getAmmount());
			
			requestsCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return requestsCreated;
		
	}

	@Override
	public int highestRequestId() {
		
		int retValue = 0;

		String sql = "select max(request_id) as maxid from request";
		try (Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			
			while(rs.next()) {
				
				retValue = rs.getInt(1);
	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return retValue;
	}

}
