package com.revature.Project0.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.revature.dao.BankDao;
import com.revature.dao.impl.BankDaoImpl;
import com.revature.model.*;

public class BankDaoImplTest {
	BankDao bd = new BankDaoImpl();
	
	@Test
	public void testGetBankByAccId() {
		Bank b = new Bank(5, 5, 0);
		assertEquals(b, bd.getBankByAccId(5));
	}
	
	@Test
	public void returnNullWhenIdNotFound() {
		assertNull(bd.getBankByAccId(100));
	}
	
}
