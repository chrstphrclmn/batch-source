package com.revature.service;

import java.sql.SQLException;
import com.revature.dao.UserDAO;
import com.revature.daoImplementation.UserDaoImpl;
import com.revature.model.User;
import connectionUtil.StringUtil;

public class UserService {
	private UserDAO udao = new UserDaoImpl();
	
	public boolean createUser(User u) throws SQLException {
		int id = udao.loginUser(u.getUserName(), u.getUserPass());
		if(id!=0) {
			throw new SQLException("User Already exists!");
		}
		boolean isValid = StringUtil.validate(u.getUserName());
		
		if(isValid==false) {
			throw new SQLException("Enter Valid Email!");
		}
		int userCreated = udao.createUser(u);
		if(userCreated!=0) {
			return true;
		}
		return false;
	}
	
	public int loginUser(String user, String pass) throws SQLException {
		user = user.trim();
		boolean isValid = StringUtil.validate(user);
		if(isValid==false) {
			throw new SQLException("Enter Valid Email!");
		}
		int id = udao.loginUser(user, pass);
		if(id ==0) {
			throw new SQLException("User Does not Exist!");
		} 
		return id;
	}
	
	public boolean userDeleted(String user, String pass) throws SQLException {
		boolean deleted = true;
		UserDAO udao = new UserDaoImpl();
		int id = udao.loginUser(user, pass);
		if(id==0) {
			deleted = false;
			throw new SQLException("User Does not Exist!");
		}
		udao.deleteUser(user, pass);
		return deleted;
	}
	
	
}
