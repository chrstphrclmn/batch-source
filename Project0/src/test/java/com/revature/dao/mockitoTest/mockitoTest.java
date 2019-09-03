package com.revature.dao.mockitoTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.revature.bankdao.UserDao;
import com.revature.model.entities.User;
import com.revature.model.funcionamiento.FuncionamientoUsuarioDao;

@RunWith(MockitoJUnitRunner.class)
public class mockitoTest {
	
	@InjectMocks
	private FuncionamientoUsuarioDao es;
	
	@Mock 
	private UserDao ed;
	
	@Before
	public void setUp() {
		User e5 = new User();
		//set up my when/thenReturn statements
		when(ed.getUser(0)).thenReturn(e5);
	}
	
//	@Test 
//	public void getEmployeeByValidId() {
//		assertEquals(new Employee(5, "Charis Fike",3732, "Mkt rep", 2, new Department(3)), es.getEmployeeById(5));
//	}
//	
//	
//	@Test
//	public void getEmployeeByInvalidId() {
//		assertNull(es.getEmployeeById(0));
//	}
//	
//	@Test
//	public void testSuccessfulCreation() {
//		Employee e6 = new Employee(6, "Lisa Johnson", 2000, "Admin Assist", 1, null);
//		assertTrue(es.createEmployee(e6));
//	}
//	
//	@Test
//	public void testUnsuccessfulCreation() {
//		assertFalse(es.createEmployee(null));
//	}
}
