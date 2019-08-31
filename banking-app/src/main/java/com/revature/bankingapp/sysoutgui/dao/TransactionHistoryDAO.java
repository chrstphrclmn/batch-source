package com.revature.bankingapp.sysoutgui.dao;

import java.util.List;
import java.util.Optional;

import com.revature.bankingapp.sysoutgui.model.TransactionHistory;

public interface TransactionHistoryDAO {

	Optional<TransactionHistory> findById(long id);

	Optional<TransactionHistory> findBySubAccountId(long id);

	List<TransactionHistory> findAll();

	Long save(TransactionHistory transactionHistory);

	void update(TransactionHistory transactionHistory);

	void delete(TransactionHistory transactionHistory);
}
