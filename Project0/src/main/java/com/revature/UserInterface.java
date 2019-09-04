package com.revature;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import com.revature.dao.AccountDao;
import com.revature.dao.BankDao;
import com.revature.dao.impl.AccountDaoImpl;
import com.revature.dao.impl.BankDaoImpl;
import com.revature.model.*;

public class UserInterface {
	private static Scanner s = new Scanner(System.in);
	private static Logger log = Logger.getRootLogger();
	private int loop = 0;
	private AccountDao ad = new AccountDaoImpl();
	private BankDao bd = new BankDaoImpl();
	private static Pattern inputPattern = Pattern.compile("^[A-Za-z0-9]{5,14}$");
	public UserInterface() {
		super();
	}
	
	public void start() {
		log.info("Welcome to Revature Bank.");
		while(loop != 3) {
			log.info("Enter 1 to create account." +"\n"+ "Enter 2 to sign in." +"\n"+ "Enter 3 to exit.");
			String loop = s.nextLine();
			if(loop.equals("1")) {
				createAccount();
			}
			else if(loop.equals("2")) {
				logIn();
			}
		}
	}
	
	private void createAccount() {
		String userName = " ";
		while(!validate(userName)) {
			log.info("Please enter any non special characters with in length from 5 to 15: ");
			userName = s.nextLine();
		}
		Account un = ad.getAccountByUN(userName);
		if(un == null) {
			String passWord = " ";
			while(passWord.length() < 5) {
				log.info("Please enter you password for the account you want to create with in length from 5 to 15: ");
				passWord = s.nextLine();
			}
			Account acc = new Account(userName, passWord);
			log.info("Enter 1 to confirm, or enter anything else to cancel: ");
			String confirm = s.nextLine();
			if(confirm.equals("1")) {
				ad.createAccount(acc);
				Account getAcc = ad.getAccountByUN(acc.getUserName());
				Bank d = new Bank(getAcc.getiD(), 0);
				bd.createBank(d);
				log.info("Account created");
			}
			else {
				start();
			}
		}
		else {
			log.info("Account already exist");
			start();
		}
	}
	
	private boolean validate(String username) {
		Matcher matcher = inputPattern.matcher(username);
		return matcher.matches();
	}
	
	
	private void logIn() {
		log.info("Enter 1 to enter your username, or enter anything else back to main.");
		String inPut = s.nextLine();
		if(inPut.equals("1")) {
			log.info("Please enter you username: ");
			String userName = s.nextLine();
			Account account = ad.getAccountByUN(userName);
			if(account == null) {
				log.info("The username you enter doesn't exist");
				logIn();
			}
			else {
				passwordCheck(account);
			}
		}
		else {
			start();
		}
	}
	
	private void passwordCheck(Account account) {
		log.info("Enter 1 to enter your password, or enter anything else back to Login.");
		String inPut = s.nextLine();
		if(inPut.equals("1")) {
			log.info("Please enter you password: ");
			String passWord = s.nextLine();
			if(account.getPassWord().equals(passWord)) {
				transferToBank(account);
			}
			else {
				log.info("The password you enter doesn't match to the account: ");
				passwordCheck(account);
			}
		}
		else {
			logIn();
		}
	}
	
	private void transferToBank(Account account) {
		Account getAcc = ad.getAccountByUN(account.getUserName());
		Bank bk = bd.getBankByAccId(getAcc.getiD());
		bank(bk);
	}
	
	private void bank(Bank account) {
		log.info("Enter 1 to check you account balance.");
		log.info("Enter 2 to deposit money.");
		log.info("Enter 3 to withdraw money.");
		log.info("Enter 4 to logout.");
		String inPut = s.nextLine();
		if(inPut.equals("1")) {
			double amount = account.getAmount();
			log.info("Account balance: " + amount);
				
		}
		if(inPut.equals("2")) {
			log.info("Please enter the amount you want to deposit: ");
			String amount = s.nextLine();
			try{
				double d = Double.parseDouble(amount);
				bd.amountModify(account, d);
				log.info("Amount added to you account.");
			}catch (NumberFormatException ex) {
				log.error("Please enter a valid number.");
			}
		}
		if(inPut.equals("3")) {
			log.info("Please enter the amount you want to withdraw: ");
			String amount = s.nextLine();
			try{
				double d = Double.parseDouble(amount);
				double accountBalance = account.getAmount();
				if(d > accountBalance) {
					log.info("The amount you enter is larger than your account balance.");
				}
				else {
					d *= -1;
					bd.amountModify(account, d);
					log.info("You had withdraw: " + amount);
				}
			}catch (NumberFormatException ex) {
				log.error("Please enter a valid number.");
			}
		}
		if(inPut.equals("4")) {
			start();
		}
		account = bd.getBankByAccId(account.getAccountId());
		bank(account);
	}
	
}
		
		
		
