package com.revature.bankingapp.sysoutgui.services;

public interface AccountService {

	boolean usernameIsValid(String username);
	boolean usernameExists(String username);
	boolean passwordIsValid(String password);
	boolean passwordsAreEqual(String password, String psw_repeat);
}
