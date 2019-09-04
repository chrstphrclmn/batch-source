package com.revature.model;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int userId;
	private String user_name;
	private String pass_word;
	private Float balance;
	
	
	public User() {
		super();
	}
	
	public User(String userName, String password, Float balanceStart) {
		super();
		this.user_name = userName;
		this.pass_word = password;
		this.balance = balanceStart;
	}
	
	public User(int userId, String user_name, String password, Float balance) {
		super();
		this.userId = userId;
		this.user_name = user_name;
		this.pass_word = password;
		this.balance = balance;
	}

	
	
	public User(String userName, Float balance) {
		// TODO Auto-generated constructor stub
		this.user_name = userName;
		this.balance = balance;
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
		return pass_word;
	}


	public void setPassKey(String passKey) {
		this.pass_word = passKey;
	}

//


	

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pass_word == null) ? 0 : pass_word.hashCode());
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
		if (pass_word == null) {
			if (other.pass_word != null)
				return false;
		} else if (!pass_word.equals(other.pass_word))
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
		return "User [userId=" + userId + ", user_name=" + user_name + ", pass_word=" + pass_word + ", balance="
				+ balance + "]";
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	
	
	
	
	

}
