package com.revature.unittest;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.revature.service.AccountService;
import com.revature.service.UserService;


public class JUnitTest {
	public ExpectedException expectedException = ExpectedException.none();
	private static final UserService udao = new UserService();
	private static final AccountService adao = new AccountService();
	
	@Test
	public void loginUserTest() throws SQLException {
		assertNotEquals("0",udao.loginUser("kaylanhusband@gmail.com", "kayjay709"));
	}
	@Test
	public void deleteUserTest() throws SQLException {
		assertTrue(udao.userDeleted("kaylanhusband@gmail.com", "kayjay709"));
	}
	
	@Test
	public void accountBalanceWorks() throws SQLException {
		assertTrue(adao.accountBalance("kaylanhusband@gmail.com", "kayjay709")==7000);
	}
	
	@Test
	public void accountDepositWorks() throws SQLException {
		assertTrue(adao.accountDeposit("kaylanhusband@gmail.com", "kayjay709", 2000)==9000);
	}
	
	@Test
	public void accountWithdrawWorks() throws SQLException {
		assertTrue(adao.accountWithraw("kaylanhusband@gmail.com", "kayjay709", 2000));
	}
}
