package com.revature.dao.testMethods;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;

import org.h2.tools.RunScript;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.bankdao.UserDao;
import com.revature.bankdao.methods.UserDaoMethods;
import com.revature.dataaccess.ConnectionDB;
import com.revature.model.entities.User;

public class UserDaoMethodsTest {
	
	UserDao u = new UserDaoMethods();
	
	@BeforeClass
	public static void setUp() throws SQLException, FileNotFoundException {
		try(Connection c = ConnectionDB.getConnection();){
			RunScript.execute(c, new FileReader("setupProject0.sql"));
		}
	}
	
	@Test
	public void testCreateUser() {
		User d = new User(1,"Felipe","felo","2541 j ct","felipe@yahoo.es","asgtslkj");
		assertEquals(1, u.createUser(d));
	}
	
	@Test
	public void testTest() {
		
		User d =  new User(
					1,
					"Andres Felipe", 
					"afcabezas", 
					"anfelipecq@yahoo.es",
					"8571 Koludet Ct", 
					"asjdgajshdgas");
		
		assertEquals("afcabezas",d.getUserName());
		
	}
	
	@Test
	public void testGetUser() {
		User d = new User(1,"Felipe","felo","2541 j ct","felipe@yahoo.es","asgtslkj");
		assertEquals(d, u.getUser(1));
	}
	
	@Test
	public void testGeUserNull() {
		User d = new User(1,"Felipe","felo","2541 j ct","felipe@yahoo.es","asgtslkj");
		assertNull( u.getUser(100));
	}
	
	@Test
	public void testConfirmUser() {
		User d = new User(1,"Felipe","felo","2541 j ct","felipe@yahoo.es","asgtslkj");
		assertEquals(d.getId(),u.confirmUser(d.getUserName(),d.getPasword()));
	}
	
	@Test
	public void userConfirmNotFound() {
		assertEquals(0,u.confirmUser("pepita","perez"));
	}
	
	
	@Test
	public void testDeleteUser() {
		User d = new User(1,"Felipe","felo","2541 j ct","felipe@yahoo.es","asgtslkj");
		assertEquals(d.getId(),u.deleteUser(d.getId()));
	}
	
	@Test
	public void testDeleteUserNothingFound() {
		assertEquals(0,u.deleteUser(100));
	}
	
	@AfterClass
	public static void tearDown() throws SQLException, FileNotFoundException {
		try( Connection c = ConnectionDB.getConnection();){
			RunScript.execute(c, new FileReader("teardownProject0.sql"));
		}
	}
}
