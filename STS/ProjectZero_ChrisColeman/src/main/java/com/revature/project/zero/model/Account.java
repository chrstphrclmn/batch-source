package com.revature.project.zero.model;

public class Account {
	private int accountNum;
	private String accountType;
	private double value;
	
	
	
	public Account(int accountNum, String accountType, double value) {
		super();
		this.accountNum = accountNum;
		this.accountType = accountType;
		this.value = value;
	}
	
	public int getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	
	
	

}
