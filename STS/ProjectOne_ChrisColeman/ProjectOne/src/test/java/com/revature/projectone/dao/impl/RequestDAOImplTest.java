package com.revature.projectone.dao.impl;

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

import com.revature.projectone.model.Request;
import com.revature.projectone.util.ConnectionUtil;

public class RequestDAOImplTest {
	
	public RequestDAOImpl aa = new RequestDAOImpl();

	@Before
	public void setup() throws FileNotFoundException, SQLException {
		try(Connection c = ConnectionUtil.getConnection();){
			RunScript.execute(c, new FileReader("setup.sql"));
		}
	}
	
	@Test
	public void testGetRequests() {
		
		List<Request> reqList = new ArrayList<Request>();
		reqList.add(new Request(1, "hdalby6", 306.32));
		reqList.add(new Request(2, "skenington2", 640.8));
		reqList.add(new Request(3, "twrightem1", 743.48));
		reqList.add(new Request(4, "bgabbitus0", 746.32));
		reqList.add(new Request(5, "twrightem1", 863.15));
		reqList.add(new Request(6, "twrightem1", 879.92));
		reqList.add(new Request(7, "sfetterplace5", 979.8));
		reqList.add(new Request(8, "mbusch3", 389.74));
		reqList.add(new Request(9, "hdalby6", 566.27));
		reqList.add(new Request(10, "hdalby6", 759.42));
		
		assertEquals(reqList, aa.getRequests());
	}
	
	@Test
	public void testGetRequestById() {
		
		Request check = new Request(9, "hdalby6", 566.27);
		
		assertEquals(check, aa.getRequestById(9));
		
	}
	
	@Test
	public void testCreateRequest() {
		
		assertEquals(1, aa.createRequest(new Request(11, "hdalby6", 100)));
		
	}
	
	@Test
	public void testHighestRequestId() {
		
		assertEquals(10, aa.highestRequestId());
		
	}
	
	@After
	public void tearDown() throws SQLException, FileNotFoundException {
		try( Connection c = ConnectionUtil.getConnection();){
			RunScript.execute(c, new FileReader("teardown.sql"));
		}
	}
}
