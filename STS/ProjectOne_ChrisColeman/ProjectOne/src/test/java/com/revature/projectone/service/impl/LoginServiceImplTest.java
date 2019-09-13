package com.revature.projectone.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.projectone.dao.impl.LoginDAOImpl;
import com.revature.projectone.model.Login;

public class LoginServiceImplTest {
	
	@Mock
	public LoginDAOImpl loginDAO;
	
	@InjectMocks
	public LoginServiceImpl aa = new LoginServiceImpl();
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAnAvailableUsername() {
		
		List<Login> logList = new ArrayList<Login>();
		logList.add(new Login("chris", "password", false));
		
		when(loginDAO.getLogins()).thenReturn(logList);
		assertTrue(aa.isAvailableUsername("bob"));
	}
	
	@Test
	public void testAnUnavailableUsername() {
		
		List<Login> logList = new ArrayList<Login>();
		logList.add(new Login("chris", "password", false));
		
		when(loginDAO.getLogins()).thenReturn(logList);
		assertFalse(aa.isAvailableUsername("chris"));
		
	}
	
	@Test
	public void testAValidManager() {
		
		Login check = new Login("chris", "pass", true);
		
		when(loginDAO.getLoginByUsername("chris")).thenReturn(check);
		assertTrue(aa.isAManager("chris"));
		
	}
	
	@Test
	public void testAnInvalidManager() {
		
		Login check = new Login("chris", "pass", false);
		
		when(loginDAO.getLoginByUsername("chris")).thenReturn(check);
		assertFalse(aa.isAManager("chris"));
		
	}
	
	@Test
	public void testNonexistentManager() {
		
		when(loginDAO.getLoginByUsername("chris")).thenReturn(null);
		assertFalse(aa.isAManager("chris"));
		
	}
	
	@Test
	public void testCreateLogin() {
		
		Login chris = new Login("chris", "pass", false);
		when(loginDAO.createLogin(chris)).thenReturn(1);
		
		assertEquals(1, aa.createLogin(chris));
	}
	
	@Test
	public void testLogins() {
		
		List<Login> logList = new ArrayList<Login>();
		logList.add(new Login("chris", "password", false));
		
		when(loginDAO.getLogins()).thenReturn(logList);
		assertEquals(logList, aa.logins());
		
	}
	
	@Test
	public void testUpdateLogins() {
		
		Login chris = new Login("chris", "pass", false);
		
		when(loginDAO.updateLogin(chris)).thenReturn(1);
		assertEquals(1, aa.updateLogin(chris));
		
	}
	

}
