package com.revature.bankingapp.sysoutgui.servicesimpl;

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

import com.revature.bankingapp.sysoutgui.daoimpl.UserDAOImpl;
import com.revature.bankingapp.sysoutgui.model.User;

public class UserServiceImplTest {

	@Mock
	UserDAOImpl userDAOImpl;
	@InjectMocks
	UserServiceImpl userServiceImpl;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		userServiceImpl = new UserServiceImpl(userDAOImpl);
		List<User> users = new ArrayList<User>();
		users.add(new User("Samuel", "Dorilas", "samuedorilas@outlook.com"));
		when(userDAOImpl.findAll()).thenReturn(users);
	}

	@Test
	public void firstNameIsValidTestTrue() {
		assertTrue(userServiceImpl.firstNameIsValid("Samuel"));
	}

	@Test
	public void firstNameIsValidTestFalseNumeric() {
		assertFalse(userServiceImpl.firstNameIsValid("Samuel1"));
	}

	@Test
	public void firstNameIsValidTestFalseTooLong() {
		assertFalse(userServiceImpl.firstNameIsValid("SamuelSamuelSamuelSamuel"));
	}

	@Test
	public void firstNameIsValidTestFalseEmpty() {
		assertFalse(userServiceImpl.firstNameIsValid(""));
	}

	@Test
	public void firstNameIsValidTestFalseMostSpecialCharacters() {
		assertFalse(userServiceImpl.firstNameIsValid("Samuel$"));
	}

	@Test
	public void lastNameIsValidTestTrue() {
		assertTrue(userServiceImpl.firstNameIsValid("Dorilas"));
	}

	@Test
	public void lastNameIsValidTestFalseNumeric() {
		assertFalse(userServiceImpl.lastNameIsValid("Dorilas1"));
	}

	@Test
	public void lastNameIsValidTestFalseTooLong() {
		assertFalse(userServiceImpl.lastNameIsValid("DorilasDorilasDorilas"));
	}

	@Test
	public void lastNameIsValidTestFalseEmpty() {
		assertFalse(userServiceImpl.lastNameIsValid(""));
	}

	@Test
	public void lastNameIsValidTestFalseMostSpecialCharacters() {
		assertFalse(userServiceImpl.lastNameIsValid("Dorilas$"));
	}

	@Test
	public void emailIsValidTestTrue() {
		assertTrue(userServiceImpl.emailIsValid("samuel@outlook.com"));
	}

	@Test
	public void emailIsValidTestFalseMissingAt() {
		assertFalse(userServiceImpl.emailIsValid("samueloutlook.com"));
	}

	@Test
	public void emailIsValidTestFalseMissingDot() {
		assertFalse(userServiceImpl.emailIsValid("samuel@outlookcom"));
	}

	@Test
	public void emailExistsTestTrue() {
		assertTrue(userServiceImpl.emailExists("samuedorilas@outlook.com"));
	}

	@Test
	public void emailExistsTestFalse() {
		assertFalse(userServiceImpl.emailExists("yinyu@gmail.com"));
	}
}
