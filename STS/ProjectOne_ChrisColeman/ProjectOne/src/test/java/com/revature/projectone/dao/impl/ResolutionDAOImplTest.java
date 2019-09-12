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

import com.revature.projectone.model.Resolution;
import com.revature.projectone.util.ConnectionUtil;

public class ResolutionDAOImplTest {
	
	ResolutionDAOImpl aa = new ResolutionDAOImpl();
	
	@Before
	public void setup() throws FileNotFoundException, SQLException {
		try(Connection c = ConnectionUtil.getConnection();){
			RunScript.execute(c, new FileReader("setup.sql"));
		}
	}
	
	@Test
	public void testGetResolutions() {
		
		List<Resolution> resList = new ArrayList<Resolution>();
		
		
		resList.add(new Resolution(4, "pjoicey4", false, "Quisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus."));
		resList.add(new Resolution(5, "pjoicey4", true, "Vestibulum quam sapien, varius ut, blandit non, interdum in, ante.  Duis faucibus accumsan odio. Curabitur convallis."));
		resList.add(new Resolution(3, "pjoicey4", false, "Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum. Aliquam non mauris."));
		resList.add(new Resolution(9, "skenington2", false, "Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit."));
		resList.add(new Resolution(2, "pjoicey4", true, "Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit."));
		
		assertEquals(resList, aa.getResolutions());
	}
	
	@Test
	public void testGetResolutionById() {
		
		Resolution check = new Resolution(2, "pjoicey4", true, "Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit.");
		
		
		assertEquals(check, aa.getResolutionById(2));
	}
	
	@Test
	public void testCreateResolution() {
		Resolution check = new Resolution(1, "pjoicey4", true, "Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit.");

		assertEquals(1, aa.createResolution(check));
	}
	
	@Test
	public void testUpdateResolution() {
		Resolution check = new Resolution(2, "pjoicey4", false, "Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit.");
		
		assertEquals(1, aa.updateResolution(check));
	}
	
	
	@After
	public void tearDown() throws SQLException, FileNotFoundException {
		try( Connection c = ConnectionUtil.getConnection();){
			RunScript.execute(c, new FileReader("teardown.sql"));
		}
	}

}
