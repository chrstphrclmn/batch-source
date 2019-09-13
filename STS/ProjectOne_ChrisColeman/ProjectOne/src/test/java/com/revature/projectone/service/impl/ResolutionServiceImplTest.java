package com.revature.projectone.service.impl;

import static org.junit.Assert.assertEquals;
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

import com.revature.projectone.dao.impl.ResolutionDAOImpl;
import com.revature.projectone.model.Resolution;

public class ResolutionServiceImplTest {
	
	@Mock
	ResolutionDAOImpl resolutionDAO;
	
	@InjectMocks
	ResolutionServiceImpl test = new ResolutionServiceImpl();
	
	@Before
	public void setup() throws FileNotFoundException, SQLException {		
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testCreateResolution() {
		
		Resolution res = new Resolution(1, "chris", true, "because");
		
		when(resolutionDAO.createResolution(res)).thenReturn(1);
		assertEquals(1, test.createResolution(res));
	}
	
	@Test
	public void testGetResolutions() {
		List<Resolution> resList = new ArrayList<>();
		Resolution res = new Resolution(1, "chris", true, "because");
		resList.add(res);
		
		when(resolutionDAO.getResolutions()).thenReturn(resList);
		assertEquals(resList, test.getResolutions());
	}
	
	@Test
	public void testGetResolutionsById() {
		Resolution res = new Resolution(1, "chris", true, "because");
		
		when(resolutionDAO.getResolutionById(1)).thenReturn(res);
		assertEquals(res, test.getResolutionById(1));
	}
	
	@Test
	public void testUpdateResolution() {
		Resolution res = new Resolution(1, "chris", true, "because");
		
		when(resolutionDAO.updateResolution(res)).thenReturn(1);
		assertEquals(1, test.updateResolution(res));
	}

}
