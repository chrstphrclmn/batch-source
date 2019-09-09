package com.revature.projectone.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;

import org.h2.tools.RunScript;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.projectone.service.RequestService;
import com.revature.projectone.util.ConnectionUtil;

public class RequestServiceImplTest {
	
	RequestService test = new RequestServiceImpl();
	
	@Before
	public void setup() throws FileNotFoundException, SQLException {
		try(Connection c = ConnectionUtil.getConnection();){
			RunScript.execute(c, new FileReader("setup.sql"));
		}
	}
	
	@Test
	public void testValidAmmount() {
		assertTrue(test.isValidAmmount(27.34));
	}
	
	@Test
	public void testNegativeAmmount() {
		assertFalse(test.isValidAmmount(-10.00));
	}
	
	@Test
	public void getCorrectNextValue() {
		assertEquals(11,test.nextRequestId());
	}
	
	@After
	public void tearDown() throws SQLException, FileNotFoundException {
		try( Connection c = ConnectionUtil.getConnection();){
			RunScript.execute(c, new FileReader("teardown.sql"));
		}
	}

}
