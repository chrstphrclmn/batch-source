package com.revature.project.zero.model;

public class Account{
	@Override
	public String toString() {
		return "Account [accountNum=" + accountNum + ", accountType=" + accountType + ", value=" + value + "]";
	}
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
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountNum != other.accountNum)
			return false;
		if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		return true;
	}
}
