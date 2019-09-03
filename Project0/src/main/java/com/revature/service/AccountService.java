package com.revature.service;
import java.sql.SQLException;

import com.revature.dao.AccountDAO;
import com.revature.daoImplementation.AccountDaoImpl;

public class AccountService {
	private AccountDAO adao = new AccountDaoImpl();
	
	public boolean createAccount(String userName, String pass, int accountNum, double accountBal) throws SQLException {
		if(accountBal < 0) {
			throw new SQLException("Balance must be positive!");
		}
		if(String.valueOf(accountNum).length()!=10) {
			throw new SQLException("Account number must be 10 digits!");
		}
		int accountCreated = adao.createAccount(userName, pass, accountNum, accountBal);
		if(accountCreated!=0) {
			return true;
		}
		return false;
	}
	
	public double accountBalance(String user, String pass) throws SQLException {
		if(adao.accountID(user, pass) == 0) {
			throw new SQLException("Account does not exist!");
		}
		double bal = adao.accountBalance(user, pass);
		return bal;
	}
	
	public double accountDeposit(String userName, String passWord, double amount) throws SQLException {
		if(adao.accountID(userName, passWord) == 0) {
			throw new SQLException("Account does not exist!");
		}
		return adao.depositAccount(userName, passWord, amount);
	}
	
	public boolean accountWithraw(String userName, String passWord, double amount) throws SQLException {
		boolean withdrawn = false;
		if(adao.accountID(userName, passWord) == 0) {
			withdrawn = false;
			throw new SQLException("Account does not exist!");
		}
		if(amount>adao.accountBalance(userName, passWord)) {
			withdrawn = false;
			throw new SQLException("Account balance cannot be negative!");
		} else {
			adao.withdrawAccount(userName, passWord, amount);
			withdrawn = true;
		}	
		return withdrawn;
	}
	
}
