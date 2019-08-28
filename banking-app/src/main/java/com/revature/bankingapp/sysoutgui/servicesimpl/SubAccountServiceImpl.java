package com.revature.bankingapp.sysoutgui.servicesimpl;

import com.revature.bankingapp.sysoutgui.dao.SubAccountDAO;
import com.revature.bankingapp.sysoutgui.daoimpl.SubAccountDAOImpl;
import com.revature.bankingapp.sysoutgui.services.SubAccountService;

public class SubAccountServiceImpl implements SubAccountService{

	SubAccountDAO SubAccount = new SubAccountDAOImpl();
	
	@Override
	public void addFunds(Long funds) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void subtractFunds(Long funds) {
		// TODO Auto-generated method stub
		
	}

}
