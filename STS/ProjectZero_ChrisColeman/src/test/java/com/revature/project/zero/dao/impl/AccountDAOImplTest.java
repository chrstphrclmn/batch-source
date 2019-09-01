package com.revature.project.zero.dao.impl;

import static org.junit.Assert.assertEquals;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.h2.tools.RunScript;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.project.zero.ConnectionUtil;
import com.revature.project.zero.model.Account;

public class AccountDAOImplTest {
	
	AccountDAOImpl aa = new AccountDAOImpl();
	
	@Before
	public void setup() throws FileNotFoundException, SQLException {
		try(Connection c = ConnectionUtil.getConnection();){
			RunScript.execute(c, new FileReader("setup.sql"));
		}
	}
	
	@Test
	public void testGetAccounts() {
		List<Account> accList = new ArrayList<Account>();
		accList.add(new Account(1, "savings", 66.46));
		accList.add(new Account(2, "savings", 71.17));
		accList.add(new Account(3, "savings", 80.51));
		accList.add(new Account(4, "checking", 23.66));
		accList.add(new Account(5, "checking", 50.43));
		
		assertEquals(accList, aa.getAccounts());
		
	}
	
	@Test
	public void testGetAccountByNum() {
		
		Account test = new Account(1, "savings", 66.46);
		assertEquals(test, aa.getAccountByNum(1));
	}
	
	@Test
	public void testCreateAccount() {
		int result = 1;
		assertEquals(result, aa.createAccount(new Account(6, "checking", 50)));
	}
	
	@Test
	public void testUpdateAccount() {
		int result = 1;
		assertEquals(result, aa.updateAccount(new Account(5, "savings", 50)));
	}
	
	@Test
	public void testDeleteAccount() {
		int result = 1;
		assertEquals(result, aa.deleteAccount(new Account(4, "checking", 23.66)));
	}
	
	
	
	@Test
	public void testDepSlashWithdraw() {
		double check = 27.68;
		assertEquals(check, aa.depSlashWithdraw(4.02, 4), .01);
	}
	
	@After
	public void tearDown() throws SQLException, FileNotFoundException {
		try( Connection c = ConnectionUtil.getConnection();){
			RunScript.execute(c, new FileReader("teardown.sql"));
		}
	}

}
