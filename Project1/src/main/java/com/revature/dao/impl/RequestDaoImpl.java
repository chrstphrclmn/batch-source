package com.revature.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Logger;

import com.revature.dao.RequestDao;
import com.revature.model.Request;
import com.revature.util.ConnectionUtil;
import com.revature.util.LoggerUtil;

public class RequestDaoImpl implements RequestDao {
	
	private static final String TABLE_NAME = "Request";
	
	private static final String COLUMN_1 = "RequestId";
	private static final String COLUMN_2 = "Applicant";
	private static final String COLUMN_3 = "Status";
	private static final String COLUMN_4 = "TicketLevel";
	private static final String COLUMN_5 = "Amount";
	private static final String COLUMN_6 = "Description";
	private static final String COLUMN_7 = "Reference";
	private static final String COLUMN_8 = "SubmissionDate";
	private static final String COLUMN_9 = "ResolutionDate";
	
	private static final String FUNC_1 = "nextRequestId";

	/**
	 * Calls database function to get the current account id serial and returns the next value
	 * @return integer representing the next requestid
	 */
	@Override
	public int getNextRequestId() {

		int ret = 1;
		
		String sql = String.format("{? = call \"%s\"()}", FUNC_1);
		
		Connection conn = ConnectionUtil.getConnection();
		
		try(CallableStatement statement = conn.prepareCall(sql)){
			
			statement.registerOutParameter(1, java.sql.Types.INTEGER);
			statement.execute();
			
			ret += statement.getInt(1);
			
			conn.close();
		}
		
		catch(SQLException e) {
			
			LoggerUtil.log.error(e.getStackTrace());
		}
		
		return ret;
	}
	
	/**
	 * Gets an individual request via unique serial ID
	 * @param requestid: Unique serial id
	 * @return Request Object corresponding to given id within the database or Null
	 */
	@Override
	public Request getRequestById(int requestid) {

		Request ret = null;
		
		String sql = String.format("select * from \"%s\" where \"%s\" = ?",
									TABLE_NAME, COLUMN_1);
		
		Connection conn = ConnectionUtil.getConnection();
		
		try(PreparedStatement statement = conn.prepareCall(sql)){
			
			statement.setInt(1,  requestid);
			
			ResultSet results = statement.executeQuery();
			
			while(results.next()) {
				
				int requestId = results.getInt(COLUMN_1);
				String applicant = results.getString(COLUMN_2);
				int status = results.getInt(COLUMN_3);
				int ticketLevel = results.getInt(COLUMN_4);
				double amount = results.getDouble(COLUMN_5);
				String description = results.getString(COLUMN_6);
				String reference = results.getString(COLUMN_7);
				Timestamp submissionDate = results.getTimestamp(COLUMN_8);
				Timestamp resolutionDate = results.getTimestamp(COLUMN_9);
				
				ret = new Request(requestId, applicant, status, ticketLevel, amount, description, reference, submissionDate, resolutionDate);
			}
			
		}
		
		catch(SQLException e) {
			
			LoggerUtil.log.error(e.getStackTrace());
		}
		
		return ret;
		
	}

	@Override
	public List<Request> getRequestsByApplicant(String applicant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createRequest(Request request) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRequest(Request request) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteRequest(Request request) {
		// TODO Auto-generated method stub
		return 0;
	}

}
