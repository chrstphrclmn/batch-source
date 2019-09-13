package com.revature.projectone.service.impl;

import java.util.List;

import com.revature.projectone.dao.impl.LoginDAOImpl;
import com.revature.projectone.model.Login;
import com.revature.projectone.service.LoginService;

public class LoginServiceImpl implements LoginService {
	
	private LoginDAOImpl loginDAO = new LoginDAOImpl();

	public boolean isAvailableUsername(String str) {

		List<Login> logList = loginDAO.getLogins();
		
		for(Login temp: logList) {
			if(str.equals(temp.getUsername())){
				return false;
			}
		}
		
		return true;
		
	}


	@Override
	public List<Login> logins() {

		return loginDAO.getLogins();
	}

	@Override
	public int createLogin(Login login) {

		return loginDAO.createLogin(login);
	}

	@Override
	public int updateLogin(Login login) {

		return loginDAO.updateLogin(login);
		
	}



	@Override
	public boolean isAManager(String username) {

		Login check = loginDAO.getLoginByUsername(username);
		
		if(check == null) {
			return false;
		}
		
		return check.isManager();
		
	}

}
