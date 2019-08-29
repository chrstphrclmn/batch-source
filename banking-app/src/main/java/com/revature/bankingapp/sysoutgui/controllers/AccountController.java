package com.revature.bankingapp.sysoutgui.controllers;

import java.util.List;
import java.util.Scanner;

import com.revature.bankingapp.SingletonScanner;
import com.revature.bankingapp.sysoutgui.dao.SubAccountDAO;
import com.revature.bankingapp.sysoutgui.daoimpl.SubAccountDAOImpl;
import com.revature.bankingapp.sysoutgui.model.Account;
import com.revature.bankingapp.sysoutgui.model.SubAccount;
import com.revature.bankingapp.sysoutgui.views.AccountView;

public class AccountController {

	private SubAccountDAO subAccountDAO = new SubAccountDAOImpl();
	private boolean exit;
	private String indicator = "E";
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

	public String launch() {
		System.out.println("Login Successful");
		System.out.println("Launching Login page");
		account(SingletonScanner.getScannerInstance());
		return indicator;
	}

	private void account(Scanner reader) {
		List<SubAccount> subAccounts = subAccountDAO.findAll();
		Outer: while (!exit) {
			AccountView.showAccounts(subAccounts);
			if (reader.hasNextInt()) {
				SubAccount subAccount = subAccounts.get(reader.nextInt());
				showSubAccount(reader, subAccount);
			} else {
				String subAccountCase = reader.next();
				switch (subAccountCase.toUpperCase()) {
				case "C":
					createSubAccount(reader);
					break;
				case "L":
					indicator = "L";
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
	}

	private void createSubAccount(Scanner reader) {
		
	}

	private void showSubAccount(Scanner reader, SubAccount subAccount) {
		Outer: while (!exit) {
			AccountView.showSubAccountOptions();
			String subAccountCase = reader.next();
			switch (subAccountCase.toUpperCase()) {
			case "D":
				
				break;
			case "W":
				
				break;
			case "V":
				System.out.println(subAccount.getAmount());
				break;
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
}
