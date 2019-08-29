package com.revature.models;

import java.io.Serializable;

import com.revature.dao.impl.UserAccountDaoImpl;
import com.revature.util.StringUtil;

public class UserAccount implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	
	private boolean loggedin = false;
	
	public UserAccount() { 
		
		super(); 
	}
	
	public UserAccount(String username, String password, String firstname, String Lastname, String email) {
		
		this();
		
		this.setUsername(username);
		this.setPassword(password);
		this.setFirstName(firstname);
		this.setLastName(Lastname);
		this.setEmail(email);
	}
	
	public boolean logIn(String username, String password) {
		
		UserAccount user = null;
		
		if(StringUtil.isValidEmail(username)){
			
			user =  new UserAccountDaoImpl().getUserAccountByEmail(username);
		}
		
		else if (StringUtil.isValidUsername(username)) {
			
			user = new UserAccountDaoImpl().getUserAccountByUsername(username);
		}
		
		else {
			
			System.out.println("Log In Failed: Invalid username or email.");
			return false;
		}
		
		if(user == null) {
			
			System.out.println("Log In Failed: No user found with that username or email.");
			return false;
		}
		
		if(password.contentEquals(user.password)) {
			
			this.setAs(user);
			this.loggedin = true;
			System.out.println("Successfully logged in.");
			return true;
		}
		
		
		System.out.println("Log In Failed: Incorrect Password.");
		return false;
	}
	
	public boolean logOut() {
		
		if(!this.loggedin) {
			
			System.out.println("Log Out Failed: No user currently logged in.");
			return false;
		}
		
		this.clean();
		System.out.println("Successfully logged out.");
		return true;
	}
	
	public String getUsername() 	{ return this.username;}
	public String getPassword() 	{ return this.password;}
	public String getFirstname() 	{ return this.firstname;}
	public String getLastname() 	{ return this.lastname;}
	public String getEmail() 		{ return this.email;}
	
	public boolean setUsername(String username) {
		
		if(StringUtil.isValidUsername(username)) {
			
			this.username = username.toLowerCase();
			return true;
		}
		
		System.out.println("Invalid Username");
		return false;
	}
	
	public boolean setPassword(String password) {
		
		this.password = password;
		return true;
	}
	
	public boolean setFirstName(String firstname) {
		
		this.firstname = firstname;
		return true;
	}
	
	public boolean setLastName(String lastname) {
		
		this.lastname = lastname;
		return true;
	}
	
	public boolean setEmail(String email) {
		
		if(StringUtil.isValidEmail(email)){
			
			this.email = email.toLowerCase();
			return true;
		}
		
		System.out.println("Invalid Email.");
		return false;
	}
	
	private void setAs(UserAccount user) {
		
		this.username = user.username;
		this.password = user.password;
		this.firstname = user.firstname;
		this.lastname = user.lastname;
		this.email = user.email;
	}
	
	private void clean() {
		
		this.username = null;
		this.password = null;
		this.firstname = null;
		this.lastname = null;
		this.email = null;
		
		this.loggedin = false;
	}
}
