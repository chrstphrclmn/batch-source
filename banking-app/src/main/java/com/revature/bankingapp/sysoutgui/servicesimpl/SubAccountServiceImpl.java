package com.revature.bankingapp.sysoutgui.servicesimpl;

import org.apache.logging.log4j.Logger;

import com.revature.bankingapp.sysoutgui.dao.SubAccountDAO;
import com.revature.bankingapp.sysoutgui.daoimpl.SubAccountDAOImpl;
import com.revature.bankingapp.sysoutgui.exceptions.InsufficientFundsException;
import com.revature.bankingapp.sysoutgui.services.SubAccountService;
import com.revature.bankingapp.sysoutgui.util.ApplicationLogger;
import com.revature.bankingapp.sysoutgui.model.SubAccount;

public class SubAccountServiceImpl implements SubAccountService {

	private SubAccountDAO subAccountDAO = new SubAccountDAOImpl();
	private static Logger logger = ApplicationLogger.getLogger();
	
	public void setSubAccountDAO(SubAccountDAO subAccountDAO) {
		this.subAccountDAO = subAccountDAO;
	}

	@Override
	public SubAccount updateFunds(SubAccount subAccount, Double funds, String operation) {
		try {
			switch (operation.toUpperCase()) {
			case "ADD":
				subAccount.setAmount(subAccount.getAmount() + funds);
				break;
			case "SUBTRACT":
				Double currentAmount = subAccount.getAmount();
				if((currentAmount-funds) < 0) {
					throw new InsufficientFundsException("Cannot perform transaction. There are insufficient funds");
				}
				subAccount.setAmount(subAccount.getAmount() - funds);
				break;
			}
			subAccountDAO.update(subAccount);
		} catch (InsufficientFundsException e) {
			logger.info(e.getMessage());
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
		} catch (InsufficientFundsException e) {
			logger.info(e.getMessage());
		}

		return subAccountDAO.findById(subAccount1.getId()).get();
	}

}
