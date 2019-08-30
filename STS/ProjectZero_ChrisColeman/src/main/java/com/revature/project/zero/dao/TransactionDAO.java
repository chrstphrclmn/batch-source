package com.revature.project.zero.dao;

import java.util.List;

import com.revature.project.zero.model.Transaction;

public interface TransactionDAO {
	
	public List<Transaction> getTransactions();
	public Transaction getTransactionByKey(int transactionID);
	public void createTransaction();
	public void updateTransaction();
	public void deleteTransaction();

}
