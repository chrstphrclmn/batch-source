package com.revature.bankingapp.sysoutgui.services;

public interface UserService {

	boolean firstNameIsValid(String firstName);
	boolean lastNameIsValid(String lastName);
	boolean emailIsValid(String email);
	boolean emailExists(String email);
}
