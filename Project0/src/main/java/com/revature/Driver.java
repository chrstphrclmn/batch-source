package com.revature;

import com.revature.models.UserAccount;

public class Driver {

	public static void main(String[] args) {
		
		UserAccount ua = new UserAccount();
		ua.logIn("mail@gmail.com", "password123");
		ua.logOut();
	}
}
