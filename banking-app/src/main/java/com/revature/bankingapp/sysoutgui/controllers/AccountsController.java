package com.revature.bankingapp.sysoutgui.controllers;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.bankingapp.sysoutgui.dao.SubAccountDAO;
import com.revature.bankingapp.sysoutgui.daoimpl.SubAccountDAOImpl;
import com.revature.bankingapp.sysoutgui.daoimpl.TransactionHistoryDAOImpl;
import com.revature.bankingapp.sysoutgui.model.SubAccount;
import com.revature.bankingapp.sysoutgui.dao.TransactionHistoryDAO;
import com.revature.bankingapp.sysoutgui.services.SubAccountService;
import com.revature.bankingapp.sysoutgui.servicesimpl.SubAccountServiceImpl;
import com.revature.bankingapp.sysoutgui.util.ScannerUtil;
import com.revature.bankingapp.sysoutgui.views.AccountView;

public class AccountsController {

	private static Logger logger = LogManager.getLogger();
	private SubAccountDAO subAccountDAO = new SubAccountDAOImpl();
	private boolean exit;
	private String indicator = "E";
	private Long loggedinAccountId;
	private SubAccountService subAccountService = new SubAccountServiceImpl();
	private TransactionHistoryDAO transactionHistoryDAO = new TransactionHistoryDAOImpl();

	public AccountsController() {
		super();
	}

	public AccountsController(Long loggedinAccountId) {
		super();
		this.loggedinAccountId = loggedinAccountId;
	}

	public void setLoggedinAccount(Long loggedinAccountId) {
		this.loggedinAccountId = loggedinAccountId;
	}

	public String launch() {
		System.out.println("Login Successful");
		logger.info("Accounts Controller was succesfully launched");
		showSubAccounts(ScannerUtil.getScannerInstance());
		return indicator;
	}

	private void showSubAccounts(Scanner reader) {
		Outer: while (!exit) {
			List<SubAccount> subAccounts = subAccountDAO.findAllById(loggedinAccountId);
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
					logger.info("Attempting to exit the application");
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
				subAccount = new SubAccount("Checking", 0d, loggedinAccountId);
				subAccountDAO.save(subAccount);
				break;
			case "S":
				subAccount = new SubAccount("Savings", 0d, loggedinAccountId);
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
				logger.info("Attempting to exit the application");
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
				subAccount = updateFunds(reader, subAccount, "Add");
				break;
			case "W":
				subAccount = updateFunds(reader, subAccount, "Subtract");
				break;
			case "T":
				if (subAccountDAO.findAllById(loggedinAccountId).size() <= 1) {
					System.out.println("You do not have any other accounts to transfer to");
					break;
				}
				SubAccount subAccount2 = showTransferFunds(reader, "deposited to", subAccount.getId());
				if (subAccount2 == null) {
					break;
				}
				subAccount = transferFunds(reader, subAccount, subAccount2);
				break;
			case "V":
				System.out.println("$" + subAccount.getAmount());
				break;
			case "H":
				System.out.println(transactionHistoryDAO.findBySubAccountId(subAccount.getId()).get().getHistory());
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
				logger.info("Attempting to exit the application");
				break Outer;
			default:
				System.out.println("Not a valid option, please reselect \n");
				continue;
			}
		}
	}

	private SubAccount updateFunds(Scanner reader, SubAccount subAccount, String operation) {
		try {
			System.out.println("Enter amount");
			String fundsString = reader.next();
			Double funds = Double.parseDouble(fundsString);
			subAccount = subAccountService.updateFunds(subAccount, funds, operation);
		} catch (NumberFormatException e) {
			System.out.println("Invalid amount");
		}
		return subAccount;
	}

	private SubAccount transferFunds(Scanner reader, SubAccount subAccount1, SubAccount subAccount2) {
		try {
			System.out.println("Enter amount");
			String fundsString = reader.next();
			Double funds = Double.parseDouble(fundsString);
			subAccount1 = subAccountService.transferFunds(subAccount1, subAccount2, funds);
		} catch (NumberFormatException e) {
			System.out.println("Invalid amount");
		}
		return subAccount1;
	}

	private SubAccount showTransferFunds(Scanner reader, String notification, long skip) {
		SubAccount subAccount = null;
		Outer: while (!exit) {
			List<SubAccount> subAccounts = subAccountDAO.findAllById(loggedinAccountId);
			Collections.sort(subAccounts);
			int indexSkipped = AccountView.showTransferAccounts(subAccounts, notification, skip);
			if (reader.hasNextInt()) {
				try {
					int selectedIndex = reader.nextInt();
					if (selectedIndex >= indexSkipped) {
						selectedIndex++;
					}
					subAccount = subAccounts.get(selectedIndex);
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
					logger.info("Attempting to exit the application");
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
