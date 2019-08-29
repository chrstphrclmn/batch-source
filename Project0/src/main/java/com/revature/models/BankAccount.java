package com.revature.models;

import java.io.Serializable;

public class BankAccount implements Serializable {
	
	private int accountId;
	private int accountType;
	private double accountBalance;
	
	public BankAccount() {
		
		super();
	}
	
	public int getAccountId() 		{ return this.accountId; }
	public int getAccountType() 	{ return this.accountType; }
	public double getAccountBalance() 	{ return this.accountBalance; }
	
	public boolean setAccountBalance(double accountBalance) {
		
		this.accountBalance = accountBalance;
		return true;
	}

}
