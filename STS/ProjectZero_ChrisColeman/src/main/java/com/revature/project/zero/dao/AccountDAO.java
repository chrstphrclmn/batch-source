package com.revature.project.zero.dao;



import java.util.List;

import com.revature.project.zero.model.Account;

public interface AccountDAO {

	public List<Account> getAccounts();
	public Account getAccountByNum(int accountNum);
	public int createAccount(Account a);
	public int updateAccount(Account a);
	public int deleteAccount(Account a);
	public double depSlashWithdraw(double ammount, int a);
}
