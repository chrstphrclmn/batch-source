package com.revature.projectone.service;

import java.util.List;

import com.revature.projectone.model.Request;

public interface RequestService {
	
	public int nextRequestId();
	public boolean isValidAmmount(double ammount);
	public List<Request> getRequests();
	public Request getRequestById(int requestId);
	public int createRequest(Request request);
	

}
