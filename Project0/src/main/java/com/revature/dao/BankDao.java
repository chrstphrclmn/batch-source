package com.revature.dao;


import com.revature.model.Bank;

public interface BankDao {
	public Bank getBankByAccId(int id);
	public int createBank(Bank d);
	public void amountModify(Bank d, double amount);
}
