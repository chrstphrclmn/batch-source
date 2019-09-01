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
import com.revature.project.zero.model.Transaction;

public class TransactionDAOImplTest {
	
	TransactionDAOImpl aa = new TransactionDAOImpl();
	
	@Before
	public void setup() throws FileNotFoundException, SQLException {
		try(Connection c = ConnectionUtil.getConnection();){
			RunScript.execute(c, new FileReader("setup.sql"));
		}
	}
	
	@Test
	public void testGetLogins() {
		List<Transaction> accList = new ArrayList<Transaction>();
		accList.add(new Transaction(1, 2, "rmartignoni4", 32.12));
		accList.add(new Transaction(2, 1, "maisthorpe3", 66.46));
		accList.add(new Transaction(3, 4, "cmelior2", 23.66));
		accList.add(new Transaction(4, 5, "skearney0", 20.81));
		accList.add(new Transaction(5, 3, "skearney0", 140.51));
		accList.add(new Transaction(6, 5, "skearney0", 29.62));
		accList.add(new Transaction(7, 2, "rmartignoni4", 39.05));
		accList.add(new Transaction(8, 3, "rcanizares1", -60.00));
		
		assertEquals(accList, aa.getTransactions());
		
	}
	
	@Test
	public void testGetTransactionByKey() {
		
		Transaction test = new Transaction(1, 2, "rmartignoni4", 32.12);
		assertEquals(test, aa.getTransactionByKey(1));
	}
	
	@Test
	public void testCreateTransaction() {
		int result = 1;
		assertEquals(result, aa.createTransaction(new Transaction(9, 2, "rmartignoni4", 32.12)));
	}
	
	@After
	public void tearDown() throws SQLException, FileNotFoundException {
		try( Connection c = ConnectionUtil.getConnection();){
			RunScript.execute(c, new FileReader("teardown.sql"));
		}
	}

}
