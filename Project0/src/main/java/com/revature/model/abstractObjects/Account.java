package com.revature.model.abstractObjects;



public class Account {
	
	int accountId;
	int userId;
	int type;            // 1 For Savings 2 For  Checking Accounts
	String userName;
	int accountNumber;
	double totalMoney;
	
	
	
	
	public Account() {
		super();
	}
	public Account(int accountId, int userId, 
			int type, String userName, 
			int accountNumber, double totalMoney) {
		super();
		this.accountId = accountId;
		this.userId = userId;
		this.type = type;
		this.userName = userName;
		this.accountNumber = accountNumber;
		this.totalMoney = totalMoney;
	}
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", userId=" + userId + ", type=" + type + ", userName=" + userName
				+ ", accountNumber=" + accountNumber + ", totalMoney=" + totalMoney + "]";
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
		result = prime * result + accountNumber;
		long temp;
		temp = Double.doubleToLongBits(totalMoney);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + type;
		result = prime * result + userId;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		Account other = (Account) obj;
		if (accountId != other.accountId)
			return false;
		if (accountNumber != other.accountNumber)
			return false;
		if (Double.doubleToLongBits(totalMoney) != Double.doubleToLongBits(other.totalMoney))
			return false;
		if (type != other.type)
			return false;
		if (userId != other.userId)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
	
	
	
	
	
	

}
