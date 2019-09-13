package com.revature.projectone.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.projectone.dao.impl.RequestDAOImpl;
import com.revature.projectone.model.Request;
import com.revature.projectone.service.RequestService;

public class RequestServiceImplTest {
	
	@InjectMocks
	RequestService test = new RequestServiceImpl();
	
	@Mock
	RequestDAOImpl requestDAO;
	
	@Before
	public void setup() throws FileNotFoundException, SQLException {		
		MockitoAnnotations.initMocks(this);
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
		
		when(requestDAO.highestRequestId()).thenReturn(10);
		assertEquals(11,test.nextRequestId());
	}
	
	@Test
	public void testCreateRequest() {
		
		Request req = new Request(1,"chris", 10.05);
		
		when(requestDAO.createRequest(req)).thenReturn(1);
		assertEquals(1, test.createRequest(req));
	}
	
	@Test
	public void testGetRequestById() {
		
		Request req = new Request(1,"chris", 10.05);
		
		when(requestDAO.getRequestById(1)).thenReturn(req);
		assertEquals(req, test.getRequestById(1));
		
	}
	
	@Test
	public void testGetRequests() {
		
		List<Request> reqList = new ArrayList<>();
		reqList.add(new Request(1,"chris", 10.05));
		
		when(requestDAO.getRequests()).thenReturn(reqList);
		assertEquals(reqList, test.getRequests());
	}
	
	
	
	

}
