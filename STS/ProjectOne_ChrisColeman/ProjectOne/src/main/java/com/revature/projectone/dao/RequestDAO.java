package com.revature.projectone.dao;

import java.util.List;

import com.revature.projectone.model.Request;

public interface RequestDAO {
	
	public List<Request> getRequests();
	public Request getRequestById(int requestId);
	public int createRequest(Request request);
	public int highestRequestId();

}
