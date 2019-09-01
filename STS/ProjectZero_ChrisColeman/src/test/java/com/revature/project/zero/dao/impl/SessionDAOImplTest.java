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
import com.revature.project.zero.model.Session;

public class SessionDAOImplTest {
	
	
	
	SessionDAOImpl aa = new SessionDAOImpl();
	
	@Before
	public void setup() throws FileNotFoundException, SQLException {
		try(Connection c = ConnectionUtil.getConnection();){
			RunScript.execute(c, new FileReader("setup.sql"));
		}
	}
	
	@Test
	public void testGetAccounts() {
		List<Session> accList = new ArrayList<Session>();
		accList.add(new Session(3, "skearney0"));
		accList.add(new Session(3, "rcanizares1"));
		accList.add(new Session(5, "skearney0"));
		accList.add(new Session(5, "rcanizares1"));
		accList.add(new Session(4, "cmelior2"));
		accList.add(new Session(1, "maisthorpe3"));
		accList.add(new Session(2, "rmartignoni4"));
		
		assertEquals(accList, aa.getSessions());
		
	}
	

	
	@Test
	public void testCreateSession() {
		int result = 1;
		assertEquals(result, aa.createSession(new Session(6, "chrs")));
	}
	

	
	@Test
	public void testDeleteSession() {
		int result = 1;
		assertEquals(result, aa.deleteSession(new Session(3, "skearney0")));
	}
	
	@After
	public void tearDown() throws SQLException, FileNotFoundException {
		try( Connection c = ConnectionUtil.getConnection();){
			RunScript.execute(c, new FileReader("teardown.sql"));
		}
	}

}
