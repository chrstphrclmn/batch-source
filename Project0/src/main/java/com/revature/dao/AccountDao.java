package com.revature.dao;


import java.util.List;

import com.revature.model.Account;


public interface  AccountDao {
	public List<Account> getAccount();
	public Account getAccountByUN(String UN);
	public int createAccount(Account c);
}
