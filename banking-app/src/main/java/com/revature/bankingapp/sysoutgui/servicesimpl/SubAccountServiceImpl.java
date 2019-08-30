package com.revature.bankingapp.sysoutgui.servicesimpl;

import org.apache.logging.log4j.Logger;

import com.revature.bankingapp.sysoutgui.dao.SubAccountDAO;
import com.revature.bankingapp.sysoutgui.daoimpl.SubAccountDAOImpl;
import com.revature.bankingapp.sysoutgui.exceptions.InsufficientFundsException;
import com.revature.bankingapp.sysoutgui.services.SubAccountService;
import com.revature.bankingapp.sysoutgui.util.ApplicationLogger;
import com.revature.bankingapp.sysoutgui.model.SubAccount;

public class SubAccountServiceImpl implements SubAccountService {

	SubAccountDAO subAccountDAO = new SubAccountDAOImpl();
	private static Logger logger = ApplicationLogger.getLogger();
	
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

}