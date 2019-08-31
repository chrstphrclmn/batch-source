package com.revature.bankingapp.sysoutgui.servicesimpl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.mockito.junit.MockitoJUnitRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import com.revature.bankingapp.sysoutgui.daoimpl.AccountDAOImpl;
import com.revature.bankingapp.sysoutgui.model.Account;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceImplTest {

	@InjectMocks
	AccountServiceImpl accountServiceImpl;
	@Mock
	AccountDAOImpl accountDAOImpl;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		accountServiceImpl = new AccountServiceImpl(accountDAOImpl);
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(new Account("samueldorilas", "Pass123", 1L));
		when(accountDAOImpl.findAll()).thenReturn(accounts);
	}
	
	@Test
	public void usernameIsValidTestTrue() {
		assertTrue(accountServiceImpl.usernameIsValid("Samuel"));
	}
	
	@Test
	public void usernameIsValidTestFalseSpecialCharacters() {
		assertFalse(accountServiceImpl.usernameIsValid("Ab!?"));
	}

	@Test
	public void usernameIsValidTestFalseToSmall() {
		assertFalse(accountServiceImpl.usernameIsValid("Ab"));
	}

	@Test
	public void usernameIsValidTestFalseToLarge() {
		assertFalse(accountServiceImpl.usernameIsValid("qwertyuiopasdfghjklzxcvbnm1234567890"));
	}

	@Test
	public void usernameExistsTestTrue() {
		assertTrue(accountServiceImpl.usernameExists("samueldorilas"));
	}
	
	@Test
	public void usernameExistsTestFalse() {
		assertFalse(accountServiceImpl.usernameExists("yinyu"));
	}

	@Test
	public void passwordIsValidTestFalseMissingCaps() {
		assertFalse(accountServiceImpl.passwordIsValid("pass123"));
	}

	@Test
	public void passwordIsValidTestFalseMissingLowerCase() {
		assertFalse(accountServiceImpl.passwordIsValid("PASS123"));
	}

	@Test
	public void passwordIsValidTestFalswMissingNumeric() {
		assertFalse(accountServiceImpl.passwordIsValid("Passonetwothree"));
	}

	@Test
	public void passwordIsValidFalseTestToSmall() {
		assertFalse(accountServiceImpl.passwordIsValid("Pa123"));
	}
	
	@Test
	public void passwordIsValidTrueTest() {
		assertTrue(accountServiceImpl.passwordIsValid("Pass123"));
	}

	@Test
	public void passwordsAreEqualTestFalse() {
		assertFalse(accountServiceImpl.passwordsAreEqual("Pass123", "Pass132"));
	}

	@Test
	public void passwordsAreEqualTestTrue() {
		assertTrue(accountServiceImpl.passwordsAreEqual("Pass123", "Pass123"));
	}

}
