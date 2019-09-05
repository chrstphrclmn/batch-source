package com.revature.bankdao;

import com.revature.model.entities.User;

public interface UserDao {
	
//	public List<User> getUsers();
	public int confirmUser(String userName, String password);
	public User getUser(int userId);
	public int createUser(User u);
	public int deleteUser(int id);

}
