package com.revature.projectone.service.impl;

import java.util.List;

import com.revature.projectone.dao.impl.RequestDAOImpl;
import com.revature.projectone.model.Request;
import com.revature.projectone.service.RequestService;

public class RequestServiceImpl implements RequestService {
	
	RequestDAOImpl reqDAO = new RequestDAOImpl();

	public int nextRequestId() {
		
		return reqDAO.highestRequestId()+1;
	}

	public boolean isValidAmmount(double ammount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Request> getRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Request getRequestById(int requestId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createRequest(Request request) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int highestRequestId() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
