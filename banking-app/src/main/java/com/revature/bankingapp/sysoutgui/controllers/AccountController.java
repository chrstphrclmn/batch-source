package com.revature.bankingapp.sysoutgui.controllers;

import java.util.Scanner;

import com.revature.bankingapp.SingletonScanner;
import com.revature.bankingapp.sysoutgui.dao.SubAccountDAO;
import com.revature.bankingapp.sysoutgui.daoimpl.SubAccountDAOImpl;
import com.revature.bankingapp.sysoutgui.model.Account;
import com.revature.bankingapp.sysoutgui.views.AccountView;

public class AccountController {

	private SubAccountDAO subAccountDAO = new SubAccountDAOImpl();
	private static boolean exit;
	private Account loggedinAccount;

	public AccountController() {
		super();
	}

	public AccountController(Account loggedinAccount) {
		super();
		this.loggedinAccount = loggedinAccount;
	}

	public void setLoggedinAccount(Account loggedinAccount) {
		this.loggedinAccount = loggedinAccount;
	}

	public void launch() {
		System.out.println("Login Successful");
		System.out.println("Launching Login page");
		account(SingletonScanner.getScannerInstance());
	}

	private void account(Scanner reader) {
		Outer: while (!exit) {
			AccountView.showAccounts();
			String mainCase = reader.next();
			switch (mainCase.toUpperCase()) {
			case "C":
				createSubAccount(reader);
				break;
			case "L":
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

	private void createSubAccount(Scanner reader) {

	}

}
