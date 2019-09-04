package com.revature.model;

public class Bank {
	private int id;
	private int accountId;
	private double amount;
	

	public int getiD() {
		return id;
	}
	public void setiD(int iD) {
		this.id = iD;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bank other = (Bank) obj;
		if (accountId != other.accountId)
			return false;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	public Bank(int iD, int accountId, double amount) {
		super();
		this.id = iD;
		this.accountId = accountId;
		this.amount = amount;
	}
	public Bank(int accountId, double amount) {
		super();
		this.accountId = accountId;
		this.amount = amount;
	}
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
