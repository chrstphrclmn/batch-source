package com.revature.project.zero.dao;

import java.util.List;

import com.revature.project.zero.model.Login;

public interface LoginDAO {
	
	public List<Login> getLogins();
	public Login getLoginByUsername(String username);
	public void createLogin(Login login);
	public void updateLogin(Login login);
	public void deleteLogin(Login login);
	
}
