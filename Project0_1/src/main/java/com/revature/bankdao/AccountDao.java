package com.revature.bankdao;

import java.util.List;

import com.revature.model.abstractObjects.Account;

public interface AccountDao {
	
	public int createAccount(Account cuenta);
	public Account getAccount(int cuentaId);
	public List<Account> getAccounts(int userId);
	public int linkAccount(int cuentaId);
	public List<Integer> accountsLinked();
	public int updateTotal(int cuentaId,double money);
	public int deleteAccount(int cuentaId);
	
	

}
