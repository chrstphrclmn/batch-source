package com.revature.projectone.service.impl;

import com.revature.projectone.dao.impl.RequestDAOImpl;
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
	
	

}
