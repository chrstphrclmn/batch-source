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

		if(ammount>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public List<Request> getRequests() {

		return reqDAO.getRequests();
		
	}

	@Override
	public Request getRequestById(int requestId) {

		return reqDAO.getRequestById(requestId);
		
	}

	@Override
	public int createRequest(Request request) {

		return reqDAO.createRequest(request);
	}


	
	

}
