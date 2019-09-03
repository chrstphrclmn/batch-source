package com.revature.project.zero.model;

public class Transaction {
	
	private int transactionID;
	private int accountNum;
	private String username;
	private double transfer;
	
	
	public Transaction(int transactionID, int accountNum, String username, double transfer) {
		super();
		this.transactionID = transactionID;
		this.accountNum = accountNum;
		this.username = username;
		this.transfer = transfer;
		
	}


	public int getTransactionID() {
		return transactionID;
	}


	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}


	public int getAccountNum() {
		return accountNum;
	}


	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public double getTransfer() {
		return transfer;
	}


	public void setTransfer(double transfer) {
		this.transfer = transfer;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountNum;
		result = prime * result + transactionID;
		long temp;
		temp = Double.doubleToLongBits(transfer);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Transaction other = (Transaction) obj;
		if (accountNum != other.accountNum)
			return false;
		if (transactionID != other.transactionID)
			return false;
		if (Double.doubleToLongBits(transfer) != Double.doubleToLongBits(other.transfer))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}


	@Override
	public String toString() {
		String check;
		if(transfer>0) {
			check = "Deposit Ammount";
		}
		else {
			check = "Withdrawal Ammount";
		}
		return "TransactionID = " + transactionID + ", User = " + username
				+ ", "+check+" =" + transfer;
	}
	
	
	
	

	
	
	
}
