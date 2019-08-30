package com.revature.bankingapp.sysoutgui.servicesimpl;

import java.util.List;

import com.revature.bankingapp.sysoutgui.dao.UserDAO;
import com.revature.bankingapp.sysoutgui.daoimpl.UserDAOImpl;
import com.revature.bankingapp.sysoutgui.model.User;
import com.revature.bankingapp.sysoutgui.services.UserService;
import com.revature.bankingapp.sysoutgui.util.ViewUtil;

public class UserServiceImpl implements UserService {

	private UserDAO userDAOImpl = new UserDAOImpl();
	private static String newline = ViewUtil.getNewline();
	private static String firstNamePolicy = "Invalid first name, please use Letters, dashes, and apostrophes."
			+ newline;
	private static String lastNamePolicy = "Invalid last name, please use Letters, dashes, and apostrophes." + newline;

	public void setUserDAOImpl(UserDAO userDAOImpl) {
		this.userDAOImpl = userDAOImpl;
	}

	public static String getFirstNamePolicy() {
		return firstNamePolicy;
	}

	public static String getLastNamePolicy() {
		return lastNamePolicy;
	}

	@Override
	public boolean firstNameIsValid(String firstName) {
		String regex = "[A-Za-z-']{1,20}";
		if (firstName.matches(regex)) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean lastNameIsValid(String lastName) {
		String regex = "[A-Za-z-']{1,20}";
		if (lastName.matches(regex)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean emailIsValid(String email) {
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		if (email.matches(regex)) {
			return true;
		}
		return false;

	}

	@Override
	public boolean emailExists(String email) {
		List<User> users = userDAOImpl.findAll();
		for (User u : users) {
			if (email.equals(u.getEmail())) {
				return true;
			}
		}
		return false;
	}

}
