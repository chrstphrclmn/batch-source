package com.revature.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.dao.UserDao;

import com.revature.util.ConnectionUtil;
import com.revature.model.User;

public class UserDaoImplTest {
	
//	@BeforeClass
//	public static void setUp() throws SQLException {
//		try(Connection c = ConnectionUtil.getConnection()){
//			
//		}
//	}
	
	
	UserDao us = new UserDaoImpl();
	
	@Test
	public void returnNullWhenUserNotFound() {
		assertNull(us.getUserById(0));
	}
	
	@Test
	public void getUserByInvalidId() {
		assertNull(us.getUserById(0));
	}
	

//	@Test
//	public void testSuccessFulCreateUser() {
//		User u = new User("test_123", "test_pass",1010.50f);
//		assertEquals(1, us.createUser(u));
//	}
	
	
	@Test
	public void returnNullifUserNotFound() {
		assertNull(us.getUserById(100));
	}
	
//	@Test
//	public void failToWithDrawMoneyWhenAmountMoreThanBalance() {
//	}
	
	@Test
	public void testSuccessFullDeposit() {
//		get username. pass it into deposit function and get return value (which is a boolean)
		User u = new User("test_deposit_user_5", "test_deposit_pass_2", 100f);
		us.createUser(u);
		assertTrue(us.deposit("test_deposit_user"));
	}
	
	
	
}
