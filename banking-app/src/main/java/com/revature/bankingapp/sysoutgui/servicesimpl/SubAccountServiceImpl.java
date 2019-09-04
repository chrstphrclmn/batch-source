package com.revature.bankingapp.sysoutgui.servicesimpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.bankingapp.sysoutgui.dao.SubAccountDAO;
import com.revature.bankingapp.sysoutgui.dao.TransactionHistoryDAO;
import com.revature.bankingapp.sysoutgui.daoimpl.SubAccountDAOImpl;
import com.revature.bankingapp.sysoutgui.daoimpl.TransactionHistoryDAOImpl;
import com.revature.bankingapp.sysoutgui.exceptions.InsufficientFundsException;
import com.revature.bankingapp.sysoutgui.services.SubAccountService;
import com.revature.bankingapp.sysoutgui.model.SubAccount;
import com.revature.bankingapp.sysoutgui.model.TransactionHistory;

public class SubAccountServiceImpl implements SubAccountService {

	private SubAccountDAO subAccountDAO = new SubAccountDAOImpl();
	private TransactionHistoryDAO transactionHistoryDAO = new TransactionHistoryDAOImpl();
	private static Logger logger = LogManager.getLogger();

	public SubAccountServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SubAccountServiceImpl(SubAccountDAO subAccountDAO, TransactionHistoryDAO transactionHistoryDAO) {
		super();
		this.subAccountDAO = subAccountDAO;
		this.transactionHistoryDAO = transactionHistoryDAO;
	}

	@Override
	public SubAccount updateFunds(SubAccount subAccount, Double funds, String operation) {
		try {
			switch (operation.toUpperCase()) {
			case "ADD":
				subAccount.setAmount(subAccount.getAmount() + funds);
				subAccountDAO.update(subAccount);
				updateDepositWithdrawlHistory(subAccount, "ADD", funds);
				break;
			case "SUBTRACT":
				Double currentAmount = subAccount.getAmount();
				if ((currentAmount - funds) < 0) {
					throw new InsufficientFundsException("Cannot perform transaction. There are insufficient funds");
				}
				subAccount.setAmount(subAccount.getAmount() - funds);
				subAccountDAO.update(subAccount);
				updateDepositWithdrawlHistory(subAccount, "SUBTRACT", funds);
				break;
			}
		} catch (InsufficientFundsException e) {
			System.out.println(e.getMessage());
			logger.error(e);
		}

		return subAccountDAO.findById(subAccount.getId()).get();
	}

	@Override
	public SubAccount transferFunds(SubAccount subAccount1, SubAccount subAccount2, Double funds) {
		try {
			Double currentAmount = subAccount1.getAmount();
			if ((currentAmount - funds) < 0) {
				throw new InsufficientFundsException("Cannot perform transaction. There are insufficient funds");
			}
			subAccount1.setAmount(subAccount1.getAmount() - funds);
			subAccount2.setAmount(subAccount2.getAmount() + funds);
			subAccountDAO.updateTransfer(subAccount1, subAccount2);
			updateTransferHistory(subAccount1, subAccount2, funds);
		} catch (InsufficientFundsException e) {
			System.out.println(e.getMessage());
			logger.error(e);
		}

		return subAccountDAO.findById(subAccount1.getId()).get();
	}

	private void updateDepositWithdrawlHistory(SubAccount subAccount, String operation, Double funds) {
		String tHistoryMessage = "";
		switch (operation.toUpperCase()) {
		case "ADD":
			tHistoryMessage = "\n Deposited $" + funds + " to " + subAccount.getType() + " Account "
					+ subAccount.getId();
			break;
		case "SUBTRACT":
			tHistoryMessage = "\n Withdrew $" + funds + " from " + subAccount.getType() + " Account "
					+ subAccount.getId();
			break;
		}
		TransactionHistory transactionHistory = transactionHistoryDAO.findBySubAccountId(subAccount.getId()).get();
		transactionHistory.setHistory(transactionHistory.getHistory() + tHistoryMessage);
		transactionHistoryDAO.update(transactionHistory);
		logger.info(tHistoryMessage + " For account with id " + subAccount.getAccountId());
	}

	private void updateTransferHistory(SubAccount subAccount1, SubAccount subAccount2,Double funds) {
		TransactionHistory History1 = transactionHistoryDAO.findBySubAccountId(subAccount1.getId()).get();
		TransactionHistory tHistory2 = transactionHistoryDAO.findBySubAccountId(subAccount2.getId()).get();
		String tHistoryMessage = "\n Transfered $" + funds + " from " + subAccount1.getType() + " Account "
				+ subAccount1.getId() + " to " + subAccount2.getType() + " Account " + subAccount2.getId();
		History1.setHistory(History1.getHistory() + tHistoryMessage);
		tHistory2.setHistory(tHistory2.getHistory() + tHistoryMessage);
		transactionHistoryDAO.update(History1);
		transactionHistoryDAO.update(tHistory2);
		logger.info(tHistoryMessage + " For account with id " + subAccount1.getAccountId());
	}

}
