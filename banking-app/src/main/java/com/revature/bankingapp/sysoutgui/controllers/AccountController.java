package com.revature.bankingapp.sysoutgui.controllers;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.Logger;

import com.revature.bankingapp.sysoutgui.dao.SubAccountDAO;
import com.revature.bankingapp.sysoutgui.daoimpl.SubAccountDAOImpl;
import com.revature.bankingapp.sysoutgui.model.Account;
import com.revature.bankingapp.sysoutgui.model.SubAccount;
import com.revature.bankingapp.sysoutgui.services.SubAccountService;
import com.revature.bankingapp.sysoutgui.servicesimpl.SubAccountServiceImpl;
import com.revature.bankingapp.sysoutgui.util.ApplicationLogger;
import com.revature.bankingapp.sysoutgui.util.ScannerUtil;
import com.revature.bankingapp.sysoutgui.views.AccountView;

public class AccountController {

	private static Logger logger = ApplicationLogger.getLogger();
	private SubAccountDAO subAccountDAO = new SubAccountDAOImpl();
	private boolean exit;
	private String indicator = "E";
	private Account loggedinAccount;
	private SubAccountService subAccountService = new SubAccountServiceImpl();

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
		logger.info("Login Successful");
		logger.info("Launching Login page");
		showSubAccounts(ScannerUtil.getScannerInstance());
		return indicator;
	}

	private void showSubAccounts(Scanner reader) {
		Outer: while (!exit) {
			List<SubAccount> subAccounts = subAccountDAO.findAll();
			Collections.sort(subAccounts);
			AccountView.showAccounts(subAccounts);
			if (reader.hasNextInt()) {
				try {
					SubAccount subAccount = subAccounts.get(reader.nextInt());
					showSubAccount(reader, subAccount);
				} catch (IndexOutOfBoundsException e) {
					System.out.println("Invalid selection");
				}
			} else {
				String subAccountCase = reader.next();
				switch (subAccountCase.toUpperCase()) {
				case "C":
					createSubAccount(reader);
					break;
				case "L":
					indicator = "L";
					exit = true;
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
		Outer: while (!exit) {
			AccountView.showSubAccountCreation();
			String subAccountCase = reader.next();
			SubAccount subAccount;
			switch (subAccountCase.toUpperCase()) {
			case "C":
				subAccount = new SubAccount("Checking", 0d, loggedinAccount.getId());
				subAccountDAO.save(subAccount);
				break;
			case "S":
				subAccount = new SubAccount("Savings", 0d, loggedinAccount.getId());
				subAccountDAO.save(subAccount);
				break;
			case "B":
				break Outer;
			case "L":
				indicator = "L";
				exit = true;
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

	// I did not use the reader.nextdouble because if it throws an
	// InputMismatchException
	// The "next"is not consumed so the subaccountcase consumes it and the case
	// leads to the default which prints the menu twice
	private void showSubAccount(Scanner reader, SubAccount subAccount) {
		Outer: while (!exit) {
			AccountView.showSubAccountOptions();
			String subAccountCase = reader.next();
			switch (subAccountCase.toUpperCase()) {
			case "D":
				updateFunds(reader, subAccount, "Add");
				break;
			case "W":
				updateFunds(reader, subAccount, "Subtract");
				break;
			case "V":
				System.out.println(subAccount.getAmount());
				break;
			case "T":
				SubAccount subAccount2 = showTransferFunds(reader, "deposited to", subAccount.getId());
				if (subAccount2 == null) {
					break;
				}
				transferFunds(reader, subAccount, subAccount2);
				break;
			case "B":
				break Outer;
			case "L":
				indicator = "L";
				exit = true;
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

	private void updateFunds(Scanner reader, SubAccount subAccount, String operation) {
		try {
			System.out.println("Enter amount");
			String fundsString = reader.next();
			Double funds = Double.parseDouble(fundsString);
			subAccountService.updateFunds(subAccount, funds, operation);
			System.out.println("Funds Transfered");
		} catch (NumberFormatException e) {
			System.out.println("Invalid amount");
		}
	}

	private void transferFunds(Scanner reader, SubAccount subAccount1, SubAccount subAccount2) {
		try {
			System.out.println("Enter amount");
			String fundsString = reader.next();
			Double funds = Double.parseDouble(fundsString);
			subAccountService.updateFunds(subAccount1, funds, "Subtract");
			subAccountService.updateFunds(subAccount2, funds, "Add");
		} catch (NumberFormatException e) {
			System.out.println("Invalid amount");
		}
	}

	private SubAccount showTransferFunds(Scanner reader, String notification, long skip) {
		SubAccount subAccount = null;
		Outer: while (!exit) {
			List<SubAccount> subAccounts = subAccountDAO.findAll();
			Collections.sort(subAccounts);
			AccountView.showTransferAccounts(subAccounts, notification, skip);
			if (reader.hasNextInt()) {
				try {
					subAccount = subAccounts.get(reader.nextInt());
					break;
				} catch (IndexOutOfBoundsException e) {
					System.out.println("Invalid selection");
				}
			} else {
				String subAccountCase = reader.next();
				switch (subAccountCase.toUpperCase()) {
				case "B":
					break Outer;
				case "L":
					indicator = "L";
					exit = true;
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
		return subAccount;
	}
}
