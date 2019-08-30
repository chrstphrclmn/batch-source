package com.revature.bankingapp.sysoutgui.servicesimpl;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.revature.bankingapp.sysoutgui.daoimpl.SubAccountDAOImpl;
import com.revature.bankingapp.sysoutgui.model.SubAccount;

@RunWith(MockitoJUnitRunner.class)
public class SubAccountServiceImplTest {

	@Mock
	SubAccountDAOImpl subAccountDAOImpl;
	@InjectMocks
	SubAccountServiceImpl subAccountServiceImpl;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		subAccountServiceImpl = new SubAccountServiceImpl();
		subAccountServiceImpl.setSubAccountDAO(subAccountDAOImpl);
		List<SubAccount> subAccounts = new ArrayList<SubAccount>();
		subAccounts.add(new SubAccount("Checking", 100d, 1L));
		when(subAccountDAOImpl.findAll()).thenReturn(subAccounts);
	}
}
