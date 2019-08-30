package com.revature.bankingapp.sysoutgui.controllers;

import java.util.NoSuchElementException;
import java.util.Scanner;

import com.revature.bankingapp.SingletonScanner;
import com.revature.bankingapp.sysoutgui.dao.AccountDAO;
import com.revature.bankingapp.sysoutgui.dao.UserDAO;
import com.revature.bankingapp.sysoutgui.daoimpl.AccountDAOImpl;
import com.revature.bankingapp.sysoutgui.daoimpl.UserDAOImpl;
import com.revature.bankingapp.sysoutgui.model.Account;
import com.revature.bankingapp.sysoutgui.model.User;
import com.revature.bankingapp.sysoutgui.services.AccountService;
import com.revature.bankingapp.sysoutgui.services.UserService;
import com.revature.bankingapp.sysoutgui.servicesimpl.AccountServiceImpl;
import com.revature.bankingapp.sysoutgui.servicesimpl.UserServiceImpl;
import com.revature.bankingapp.sysoutgui.views.HomeView;

public class HomeController {

	private boolean exit;
	private String indicator = "E";

	private UserService userService = new UserServiceImpl();
	private AccountService accountService = new AccountServiceImpl();
	private UserDAO userDAO = new UserDAOImpl();
	private AccountDAO accountDAO = new AccountDAOImpl();
	private Account loggedinAccount;

	public Account getLoggedinAccount() {
		return loggedinAccount;
	}

	public String launch() {
		System.out.println("Launching Home page");
		home(SingletonScanner.getScannerInstance());
		return indicator;
	}

	private void home(Scanner reader) {
		Outer: while (!exit) {
			HomeView.showHome();
			String mainCase = reader.next();
			switch (mainCase.toUpperCase()) {
			case "C":
				signup(reader);
				break;
			case "L":
				login(reader);
				break;
			case "E":
				exit = true;
				System.out.println("Exiting application...");
				break Outer;
			default:
				System.out.println("Not a valid option, please reselect \n");
				continue;
			}
		}
	}

	private void login(Scanner reader) {
		Outer: while (!exit) {
			HomeView.showForm("login");
			String signupCase = reader.next();
			switch (signupCase.toUpperCase()) {
			case "T":
				if (submitLogin(reader)) {
					exit = true;
					System.out.println("Leaving Home Screen");
					indicator ="L";
					break Outer;
				} else {
					break;
				}
			case "B":
				break Outer;
			case "E":
				exit = true;
				System.out.println("Exiting application...");
				break Outer;
			default:
				System.out.println("Not a valid option, please reselect \n");
				continue;
			}
		}
	}

	private boolean submitLogin(Scanner reader) {
		HomeView.showFormat();
		String line;
		reader.nextLine();
		boolean reset = true;
		String username = "";
		String password = "";
		while (reset) {
			System.out.println("Username: ");
			username = reader.nextLine();
			System.out.println("Password: ");
			password = reader.nextLine();
			System.out.println("Press enter to submit. Press R to restart.");
			while (!(line = reader.nextLine()).equalsIgnoreCase("R") && !line.equals("")) {
				System.out.println("Invalid selection, enter R or press enter");
			}
			if (!line.equalsIgnoreCase("R")) {
				reset = false;
			}
		}
		if (!validateSubmission(username, password)) {
			System.out.println("Invalid credentials");
			return false;
		} else {
			return true;
		}
	}

	private boolean validateSubmission(String username, String password) {
		try {
			Account account = accountDAO.findByUsername(username).get();
			if (!account.getPassword().equalsIgnoreCase(password)) {
				return false;
			}
			loggedinAccount = account;
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private void signup(Scanner reader) {
		Outer: while (!exit) {
			HomeView.showForm("sign up");
			String signupCase = reader.next();
			switch (signupCase.toUpperCase()) {
			case "T":
				submitSignupForm(reader);
				break Outer;
			case "B":
				break Outer;
			case "E":
				exit = true;
				System.out.println("Exiting application...");
				break Outer;
			default:
				System.out.println("Not a valid option, please reselect \n");
				continue;
			}
		}
	}

	private void submitSignupForm(Scanner reader) {
		HomeView.showFormat();
		String line;
		reader.nextLine();
		String[] inputs = initiateChecks(reader);
		System.out.println("Press enter to submit. Press R to restart. Enter exit to cancel sign up.");
		if ((line = reader.nextLine()) != null && line.equalsIgnoreCase("R")) {
			inputs = initiateChecks(reader);
		}else if(line != null && line.equalsIgnoreCase("exit")) {return;}
		User newUser = new User(inputs[0], inputs[1], inputs[2]);
		userDAO.save(newUser);
		System.out.println("The User " + newUser.getFirstName() + " was created succesfully");
		newUser = userDAO.findByEmail(newUser.getEmail()).get();
		Account newAccount = new Account(inputs[3], inputs[4], newUser.getId());
		accountDAO.save(newAccount);
		System.out.println("The Account " + newAccount.getUsername() + " was created succesfully");
	}

	private String[] initiateChecks(Scanner reader) {
		String[] inputFields = HomeView.getInputFields();
		int length = inputFields.length;
		String[] inputs = new String[length];
		for (int i = 0; i < length; i++) {
			System.out.print(inputFields[i]);
			inputs[i] = reader.nextLine();
			System.out.println(inputs[i]);
//			boolean failed = !
					inputFieldsAreValid(inputs, i);
//			if (i > 0) {
//				System.out.println("Go back one field? y / n");
//				String line;
//				while (!(line = reader.nextLine()).equals("y") && !line.equals("n")) {
//					System.out.println("Invalid selection, enter y or n for yes or no");
//				}
//				if (line.equals("y")) {
//					i = i - 1;
//				}
//			}
//			if (failed) {
//				i = i - 1;
//			}

		}
		return inputs;
	}

	private boolean inputFieldsAreValid(String[] inputs, int i) {
		switch (i) {
		case 0:
			if (!userService.firstNameIsValid(inputs[i])) {
				System.out.println(UserServiceImpl.getFirstNamePolicy());
				return false;
			}
			break;
		case 1:
			if (!userService.lastNameIsValid(inputs[i])) {
				System.out.println(UserServiceImpl.getLastNamePolicy());
				return false;
			}
			break;
		case 2:
			if (!userService.emailIsValid(inputs[i])) {
				System.out.println("Invalid email");
				return false;
			}
			if (userService.emailExists(inputs[i])) {
				System.out.println("The email address already exists.");
				return false;
			}
			break;
		case 3:
			if (!accountService.usernameIsValid(inputs[i])) {
				System.out.println(AccountServiceImpl.getUsernamePolicy());
				return false;
			}
			if (accountService.usernameExists(inputs[i])) {
				System.out.println("The username address already exists.");
				return false;
			}
			break;
		case 4:
			if (!accountService.passwordIsValid(inputs[i])) {
				System.out.println(AccountServiceImpl.getPasswordPolicyMessage());
				return false;
			}
			break;
		case 5:
			if (!accountService.passwordsAreEqual(inputs[i], inputs[i - 1])) {
				System.out.println("Passwords do not match");
				return false;
			}
			break;
		}
		return true;
	}

}
