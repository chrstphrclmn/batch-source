package com.revature.project.zero.dao;

import java.util.List;

import com.revature.project.zero.model.Login;

public interface LoginDAO {
	
	public List<Login> getLogins();
	public Login getLoginByUsername(String username);
	public int createLogin(Login login);
	public int updateLogin(Login login);
	public int deleteLogin(Login login);
	
}
