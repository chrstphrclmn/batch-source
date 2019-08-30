package com.revature.project.zero.dao;



import java.util.List;

import com.revature.project.zero.model.Account;

public interface AccountDAO {

	public List<Account> getAccounts();
	public Account getAccountByNum(int accountNum);
	public void createAccount(Account a);
	public void updateAccount(Account a);
	public void deleteAccount(Account a);
	
}
