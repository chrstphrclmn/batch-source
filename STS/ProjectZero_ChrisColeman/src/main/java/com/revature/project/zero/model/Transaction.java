package com.revature.project.zero.model;

public class Transaction {
	
	private int transactionID;
	private Session session;
	private double transfer;
	
	
	
	public Transaction(Session session, double transfer) {
		super();
		this.session = session;
		this.transfer = transfer;
	}

	public Transaction(int transactionID, Session session, double transfer) {
		super();
		this.transactionID = transactionID;
		this.session = session;
		this.transfer = transfer;
	}
	
	public int getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	public double getTransfer() {
		return transfer;
	}
	public void setTransfer(double transfer) {
		this.transfer = transfer;
	}
	
	
	
	
	
}
