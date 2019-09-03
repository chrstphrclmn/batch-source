package com.revature.dao;

import java.util.List;

import com.revature.model.User;

public interface UserDAO {
	public List<User> getUser();
	public int createUser(User u);
	public int loginUser(String userName,String userPass);
	public int deleteUser(String user, String pass);
}
