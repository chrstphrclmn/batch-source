package com.revature.model;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int userId;
	private String user_name;
	private String passKey;
	private float balance;
	
	
	public User(String userName, String userPass, Float balanceStart) {
		super();
		// TODO Auto-generated constructor stub
		this.user_name = userName;
		this.passKey = userPass;
		this.balance = balanceStart;
	}
	
	public void setUser_id(int id) {
		this.userId = id;
	}
	
	public int getUser_id() {
		return userId;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getPassKey() {
		return passKey;
	}


	public void setPassKey(String passKey) {
		this.passKey = passKey;
	}


	public User(int userId, String user_name, String passKey, float d) {
		super();
		this.user_name = user_name;
		this.passKey = passKey;
		this.balance = d;
	}


	

	public User() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((passKey == null) ? 0 : passKey.hashCode());
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (passKey == null) {
			if (other.passKey != null)
				return false;
		} else if (!passKey.equals(other.passKey))
			return false;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "User [user_name=" + user_name + ", passKey=" + passKey + "]";
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	
	
	
	
	

}
