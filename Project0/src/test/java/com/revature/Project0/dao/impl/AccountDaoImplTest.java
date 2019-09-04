package com.revature.Project0.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.revature.dao.AccountDao;
import com.revature.dao.impl.AccountDaoImpl;
import com.revature.model.Account;

public class AccountDaoImplTest {
	AccountDao ad = new AccountDaoImpl();
	
	@Test
	public void testGetAccountByUN() {
		Account a = new Account(3, "ij", "kk");
		assertEquals(a, ad.getAccountByUN("ij"));
	}
	
	@Test
	public void returnNullWhenIdNotFound() {
		assertNull(ad.getAccountByUN("332222222"));
	}
}
