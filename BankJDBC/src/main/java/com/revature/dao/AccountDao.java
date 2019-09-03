package com.revature.dao;

import java.util.List;

import com.revature.model.Account;

public interface AccountDao {
	
	
	public List<Account> getAccounts();
	public Account getAccountById(int id);
	public int createAccount(Account a);
	public int updateAccount(Account a);
	public int deleteAccountById(int id);
	
	
}
