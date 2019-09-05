package com.revature.dao.testMethods;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;

import org.h2.tools.RunScript;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.bankdao.AccountDao;
import com.revature.bankdao.methods.AccountDaoMethods;
import com.revature.dataaccess.ConnectionDB;
import com.revature.model.abstractObjects.Account;
import com.revature.model.entities.User;

public class AccountsDaoMethodsTest {
	
	AccountDao ac = new AccountDaoMethods();
	
	@BeforeClass
	public static void setUp() throws SQLException, FileNotFoundException {
		try(Connection c = ConnectionDB.getConnection();){
			RunScript.execute(c, new FileReader("setupProject0.sql"));
		}
	}
	
	
	@Test
	public void testGetAccount() {
		Account a = new Account(1,2,2," ",1000,600.00);
		assertEquals(a, ac.getAccount(1));
	}
	
	@Test
	public void testCreateAccount() {
		Account a = new Account(1, 1,2, "Andres Felipe", 14000, 6000.00);
		
		assertEquals(1, ac.createAccount(a));
	}
	
	@Test
	public void testDeleteAccount() {
		Account a = new Account(1, 1,2, "Andres Felipe", 10000, 6000.00);
		
		assertEquals(1, ac.deleteAccount(a.getAccountId()));
	}
			
	@AfterClass
	public static void tearDown() throws SQLException, FileNotFoundException {
		try( Connection c = ConnectionDB.getConnection();){
			RunScript.execute(c, new FileReader("teardownProject0.sql"));
		}
	}

}
