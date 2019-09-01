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
import com.revature.project.zero.model.Login;

public class LoginDAOImplTest {

	LoginDAOImpl aa = new LoginDAOImpl();
	
	@Before
	public void setup() throws FileNotFoundException, SQLException {
		try(Connection c = ConnectionUtil.getConnection();){
			RunScript.execute(c, new FileReader("setup.sql"));
		}
	}
	
	@Test
	public void testGetLogins() {
		List<Login> accList = new ArrayList<Login>();
		accList.add(new Login("skearney0", "I5A6YI18KYgl"));
		accList.add(new Login("rcanizares1", "Npy1Fee"));
		accList.add(new Login("cmelior2", "Hq2ULFUxQI3"));
		accList.add(new Login("maisthorpe3", "h47gaL"));
		accList.add(new Login("rmartignoni4", "jp8wFSOY"));
		
		assertEquals(accList, aa.getLogins());
		
	}
	
	@Test
	public void testGetLoginByUsername() {
		
		Login test = new Login("skearney0", "I5A6YI18KYgl");
		assertEquals(test, aa.getLoginByUsername("skearney0"));
	}
	
	@Test
	public void testCreateLogin() {
		int result = 1;
		assertEquals(result, aa.createLogin(new Login("chrs", "password")));
	}
	
	@Test
	public void testUpdateLogin() {
		int result = 1;
		assertEquals(result, aa.updateLogin(new Login("skearney0", "password")));
	}
	
	@Test
	public void testDeleteLogin() {
		int result = 1;
		assertEquals(result, aa.deleteLogin(new Login("skearney0", "I5A6YI18KYgl")));
	}
	
	@After
	public void tearDown() throws SQLException, FileNotFoundException {
		try( Connection c = ConnectionUtil.getConnection();){
			RunScript.execute(c, new FileReader("teardown.sql"));
		}
	}

	
}
