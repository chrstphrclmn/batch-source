package com.revature.bankingapp.sysoutgui.servicesimpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.revature.bankingapp.sysoutgui.dao.SubAccountDAO;
import com.revature.bankingapp.sysoutgui.daoimpl.TransactionHistoryDAOImpl;
import com.revature.bankingapp.sysoutgui.model.SubAccount;
import com.revature.bankingapp.sysoutgui.model.TransactionHistory;

@RunWith(MockitoJUnitRunner.class)
public class SubAccountServiceImplTest {

	@Mock
	SubAccountDAO subAccountDAOImpl;
	@Mock
	TransactionHistoryDAOImpl transactionHistoryDAO;
	
	@InjectMocks
	SubAccountServiceImpl subAccountServiceImpl;

	String checkings = "Checkings";
	String savings = "Savings";
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		subAccountServiceImpl = new SubAccountServiceImpl();
		subAccountServiceImpl.setSubAccountDAO(subAccountDAOImpl);	
		subAccountServiceImpl.setTransactionHistoryDAO(transactionHistoryDAO);
	}

	@Test
	public void updateFundsAdded() {
		SubAccount subAccount = new SubAccount(1L ,checkings, 100d, 1L);
		TransactionHistory transactionHistory = new TransactionHistory("History", 1L);
		when(transactionHistoryDAO.findBySubAccountId(1L)).thenReturn(Optional.of(transactionHistory));
		when(subAccountDAOImpl.findById(1L)).thenReturn(Optional.of(subAccount));
		subAccountServiceImpl.updateFunds(subAccount, 50d, "Add");

		assertEquals(150d, subAccount.getAmount(), .01d);
	}

	@Test
	public void updateFundsSubtracted() {
		SubAccount subAccount = new SubAccount(1L ,checkings, 100d, 1L);
		TransactionHistory transactionHistory = new TransactionHistory("History", 1L);
		when(transactionHistoryDAO.findBySubAccountId(1L)).thenReturn(Optional.of(transactionHistory));
		when(subAccountDAOImpl.findById(1L)).thenReturn(Optional.of(subAccount));
		subAccountServiceImpl.updateFunds(subAccount, 50d, "Subtract");

		assertEquals(50d, subAccount.getAmount(), .01d);
	}

	@Test
	public void updateFundsInsufficientFunds() {
		SubAccount subAccount = new SubAccount(1L ,checkings, 100d, 1L);
		when(subAccountDAOImpl.findById(1L)).thenReturn(Optional.of(subAccount));
		subAccountServiceImpl.updateFunds(subAccount, 150d, "Subtract");

		assertEquals(100d, subAccount.getAmount(), .01d);
	}

	@Test
	public void transferFundsAdded() {
		SubAccount subAccount1 = new SubAccount(1L ,checkings, 100d, 1L);
		SubAccount subAccount2 = new SubAccount(2L ,savings, 50d, 1L);
		
		when(transactionHistoryDAO.findBySubAccountId(1L)).thenReturn(Optional.of(new TransactionHistory()));
		when(transactionHistoryDAO.findBySubAccountId(2L)).thenReturn(Optional.of(new TransactionHistory()));
		
		when(subAccountDAOImpl.findById(1L)).thenReturn(Optional.of(subAccount1));
		subAccountServiceImpl.transferFunds(subAccount1, subAccount2, 25d);

		assertEquals(75d, subAccount2.getAmount(), .01d);
	}
	
	@Test
	public void transferFundsSubtracted() {
		SubAccount subAccount1 = new SubAccount(1L ,checkings, 100d, 1L);
		SubAccount subAccount2 = new SubAccount(2L ,savings, 50d, 1L);
		
		when(transactionHistoryDAO.findBySubAccountId(1L)).thenReturn(Optional.of(new TransactionHistory()));
		when(transactionHistoryDAO.findBySubAccountId(2L)).thenReturn(Optional.of(new TransactionHistory()));
		
		when(subAccountDAOImpl.findById(1L)).thenReturn(Optional.of(subAccount1));
		subAccountServiceImpl.transferFunds(subAccount1, subAccount2, 25d);

		assertEquals(75d, subAccount1.getAmount(), .01d);
	}

	@Test
	public void transferFundsInsufficientFunds() {
		SubAccount subAccount = new SubAccount(1L ,checkings, 100d, 1L);
		when(subAccountDAOImpl.findById(1L)).thenReturn(Optional.of(subAccount));
		subAccountServiceImpl.transferFunds(subAccount, new SubAccount(), 150d);

		assertEquals(100d, subAccount.getAmount(), .01d);
	}
}
