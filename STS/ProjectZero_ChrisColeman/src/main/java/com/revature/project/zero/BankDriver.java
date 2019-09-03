package com.revature.project.zero;

import java.util.List;
import java.util.Scanner;

import com.revature.project.zero.dao.impl.AccountDAOImpl;
import com.revature.project.zero.dao.impl.LoginDAOImpl;
import com.revature.project.zero.dao.impl.SessionDAOImpl;
import com.revature.project.zero.dao.impl.TransactionDAOImpl;
import com.revature.project.zero.model.Account;
import com.revature.project.zero.model.Login;
import com.revature.project.zero.model.Session;
import com.revature.project.zero.model.Transaction;

public class BankDriver {

	static String username = "";
	static String pass = "";
	static Scanner scan = new Scanner(System.in);
	static LoginDAOImpl loginDAO = new LoginDAOImpl();
	static Login systemLogin;
	static AccountDAOImpl accountDAO = new AccountDAOImpl();
	static Account systemAccount;
	static SessionDAOImpl sessionDAO = new SessionDAOImpl();
	static TransactionDAOImpl transactionDAO = new TransactionDAOImpl();
	
	public static void main(String[] args){
		
		
		
		
		System.out.println("Welcome to Fuax Green Bank.");
		queryUserDetails();

		scan.close();
	}
	
	public static void queryUserDetails() {
		
		System.out.println("Please enter 1 to login.");
		System.out.println("Please enter 2 to register.");

		String inputTest = scan.nextLine();
		
		if(inputTest.equals("1")) {
			login();
		}
		else if (inputTest.contentEquals("2")) {
			register();
		}
		else {
			System.out.println("That is not a valid command.");
			queryUserDetails();
		}
		
		queryFunction();
		
	}
	
	public static void login() {
		
		
		
		System.out.println("What is your username.");
		username = scan.nextLine();
		System.out.println("What is your password.");
		pass = scan.nextLine();
		
		Login check = loginDAO.getLoginByUsername(username);
		
		if(check == null) {
			System.out.println("That username does not exist.");
			queryUserDetails();
		}
		else if(check.getPassword().equals(pass)) {
			systemLogin = check;
		}
		else {
			System.out.println("That password is incorrect.");
			queryUserDetails();
		}
		
	}
	
	public static void register() {
		
		System.out.println("Please set a username.");
		username = scan.next();
		
		if(username.equals("")){
			System.out.println("Your username cannot be blank.");
			register();
		}
		else {
			Login check = loginDAO.getLoginByUsername(username);
			
			if(check == null) {
				setPassword();
				systemLogin = new Login(username, pass);
				loginDAO.createLogin(systemLogin);
			}
			else {
				System.out.println("That username is already taken.");
				register();
			}
		
		}
	}
	
	public static void setPassword() {
		System.out.println("Please choose a password.");
		String hold = scan.nextLine();
		
		if(hold.equals("")) {
			System.out.println("Your password cannot be blank.");
			setPassword();
		}
		else {
			System.out.println("Please reenter your password to confirm.");
			String hold2 = scan.nextLine();
		
			if(hold.equals(hold2)) {
				pass = hold;
			}
			else {
				System.out.println("Those passwords do not match.");
				setPassword();
			}
		}
	}
	
	public static void queryFunction() {
		
		System.out.println("Querying function.");
		
		if(checkAccounts()==0) {
			
			System.out.println("You do not appear to have an account yet. Please make one now.");
			firstAccount();
			
		}
		else if(checkAccounts()==1) {
			oneAccount();
		}
		else if(checkAccounts()==2) {
			
		}
	}
	
	public static int checkAccounts() {
		
		List<Session> sessList = sessionDAO.getSessions();
		int accountsCount = 0;
		
		
		for(Session temp: sessList) {
			if(temp.getUsername().equals(systemLogin.getUsername())) {
				accountsCount++;
			}
			
		}
		
		return accountsCount;
	}
	
	public static void firstAccount() {
		
		System.out.println("Please select the type of account (using the numbers) you would like to create.");
		System.out.println("1-Checking");
		System.out.println("2-Savings");
		String check = scan.nextLine();
		String accountType;
		
		switch(check) {
		
		case "1":{
			accountType = "checking";
			int hold = newAccountNumber();
			accountDAO.createAccount(new Account(hold, accountType, 0));
			sessionDAO.createSession(new Session(hold, username));
			
			break;
		}
		case "2":{
			accountType = "savings";
			int hold = newAccountNumber();
			accountDAO.createAccount(new Account(hold, accountType, 0));
			sessionDAO.createSession(new Session(hold, username));
			break;
		}
		default: {
			System.out.println("That input is invalid.");
			firstAccount();
		}
		}
		
		queryFunction();
	}
	
	public static int newAccountNumber() {
		
		List<Account> accList = accountDAO.getAccounts();
		int lastAccountNum = 0;
		
		
		for(Account temp: accList) {
			lastAccountNum = temp.getAccountNum();
		}
		
		return lastAccountNum + 1;
	}
	
	public static void oneAccount() {
		
		Session onlySession = sessionDAO.getSessionByUsername(username);
		Account onlyAccount = accountDAO.getAccountByNum(onlySession.getAccountNum());
		String type = onlyAccount.getAccountType();
		System.out.println(type);
		String notType = "";
		
		switch(type) {
		case "checking": {
			notType = "savings";
			break;
		}
		case "savings": {
			notType = "checking";
			break;
		}
		}

		System.out.println("Please select an option. (by number)");
		System.out.println("1 - Access your " + type + " account.");
		System.out.println("2 - Create a " + notType+ " account.");
		System.out.println("3 - Exit.");
		
		String hold = scan.nextLine();
		
		switch(hold) {
		case "1":{
			accessAccount(onlySession);
			break;
		}
		case "2":{
			int holdNum = newAccountNumber();
			accountDAO.createAccount(new Account(holdNum, notType, 0));
			sessionDAO.createSession(new Session(holdNum, username));
			break;
		}
		case "3":{
			System.exit(0);
			break;
		}
		default: {
			System.out.println("That is not a valid input.");
		}
		}
		
		queryFunction();
		
	}
	
	public static void accessAccount(Session session) {
		
		Account hold = accountDAO.getAccountByNum(session.getAccountNum());
		
		System.out.println("You are currently accessing your "+hold.getAccountType()+" account.");
		System.out.println("Funds available: "+hold.getValue());
		
		System.out.println("Please select an option.");
		System.out.println("1 - Make a deposit.");
		System.out.println("2 - Make a withdrawal.");
		System.out.println("3 - Return to main menu.");
		
		String input = scan.nextLine();
		
		switch(input) {
		case "1":{
			deposit(hold);
			break;
		}
		case "2": {
			withdrawal(hold);
			break;
		}
		case "3": {
			queryFunction();
			break;
		}
		default: {
			System.out.println("That is not a valid input.");
			accessAccount(session);
		}
		}
		
	}
	
	public static void deposit(Account account) {
		
		System.out.println("How much would you like to deposit?");
		String input = scan.nextLine();
		double ammount;
		
		try {
			ammount = Double.parseDouble(input);
			Account updatedAccount = account;
		
			if(ammount > 0) {
				updatedAccount.setValue(updatedAccount.getValue()+ammount);
				accountDAO.updateAccount(updatedAccount);
				Transaction dep = new Transaction(getNewTransactionID(), account.getAccountNum(), username, ammount);
				transactionDAO.createTransaction(dep);
			}
			else {
				System.out.println("You can't deposit 0 dollars or less.");
				deposit(account);
			}
		
		}
		catch(NumberFormatException e) {
			System.out.println("That is not a valid input.");
			deposit(account);
		}
		
	}
	
	public static int getNewTransactionID() {
		
		List<Transaction> transList = transactionDAO.getTransactions();
		int retValue = 0;
		
		for(Transaction temp: transList) {
			retValue = temp.getTransactionID();
		}
		
		return retValue+1;
		
	}

	public static void withdrawal(Account account) {
		
		System.out.println("How much would you like to withdraw?");
		String input = scan.nextLine();
		double ammount;
		
		try {
			ammount = Double.parseDouble(input);
			Account updatedAccount = account;
			double withDraw = accountDAO.depSlashWithdraw(ammount, account.getAccountNum());
		
			if(ammount > 0) {
				if(withDraw >=0) {
					updatedAccount.setValue(withDraw);
					accountDAO.updateAccount(updatedAccount);
					Transaction with = new Transaction(getNewTransactionID(), account.getAccountNum(), username, -ammount);
					transactionDAO.createTransaction(with);
				}
				else {
					System.out.println("You do not have that much money in your account.");
					withdrawal(account);
				}
			}
			else {
				System.out.println("You can't withdraw 0 dollars or less.");
				deposit(account);
			}
		
		}
		catch(NumberFormatException e) {
			System.out.println("That is not a valid input.");
			deposit(account);
		}
		
	}
}