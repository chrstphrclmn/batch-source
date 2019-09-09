package com.revature.projectone.dao;

import java.util.List;

import com.revature.projectone.model.Login;

public interface LoginDAO {
	
	public List<Login> getLogins();
	public Login getLoginByUsername(String username);
	public int createLogin(Login login);
	public int updateLogin(Login login);

}
