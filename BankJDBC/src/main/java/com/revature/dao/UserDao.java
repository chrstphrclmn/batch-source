package com.revature.dao;

import java.util.List;

import com.revature.model.User;

public interface UserDao {
	
	public List<User> getUsers();
	public User getUserById(int id);
	public int createUser(User u);
	public int deleteUser(int id);
	
	public void login();
	public boolean deposit(String user);
	
	
	
	
}

