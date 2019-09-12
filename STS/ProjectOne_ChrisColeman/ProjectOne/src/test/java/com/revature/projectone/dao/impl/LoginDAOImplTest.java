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

import com.revature.projectone.model.Login;
import com.revature.projectone.util.ConnectionUtil;

public class LoginDAOImplTest {

	
	public LoginDAOImpl aa = new LoginDAOImpl();
	
	@Before
	public void setup() throws FileNotFoundException, SQLException {
		try(Connection c = ConnectionUtil.getConnection();){
			RunScript.execute(c, new FileReader("setup.sql"));
		}
	}
	
	@Test
	public void testGetLogins() {
		List<Login> logList = new ArrayList<Login>();
		logList.add(new Login("bgabbitus0", "D05oqMkg", false, "Babbette", "Gabbitus", "Librarian", "bgabbitus0@gov.uk", "3031910672"));
		logList.add(new Login("twrightem1", "vJuDR1C", true, "Tracey", "Wrightem", "Actuary", "twrightem1@bloglovin.com", "8052560805"));
		logList.add(new Login("skenington2", "7AGrmPacQ5", true, "Sheela", "Kenington", "Human Resources Assistant III", "skenington2@aboutads.info", "1061751247"));
		logList.add(new Login("mbusch3", "i2Pble", true, "Meir", "Busch", "Accountant IV", "mbusch3@facebook.com", null));
		logList.add(new Login("pjoicey4", "H7bQbLV", true, "Peg", "Joicey", "Engineer III", "pjoicey4@mediafire.com", "8607494303"));
		logList.add(new Login("sfetterplace5", "x4LpfM", true, "Susan", "Fetterplace", "Actuary", null, "7118750640"));
		logList.add(new Login("hdalby6", "GO7q3HvcC", true, "Harvey", "Dalby", "Sales Associate", "hdalby6@cnbc.com", null));
		logList.add(new Login("eisacke7", "mzGBxbQISqV", false, "Eleanore", "Isacke", "Assistant Manager", "eisacke7@wufoo.com", "4892245735"));
		logList.add(new Login("vsine8", "wxGv7GtZp", false, "Verina", "Sine", "Product Engineer", "vsine8@scientificamerican.com", "4765733373"));
		logList.add(new Login("bcoulston9", "XG0DJrO", true, "Berne", "Coulston", "Nuclear Power Engineer", "bcoulston9@umich.edu", null));
		logList.add(new Login("gfrantseva", "LUROh5xVYy5a", true, "Gris", "Frantsev", null, "gfrantseva@disqus.com", "8664239555"));
		logList.add(new Login("dvellacottb", "72qK1unAO", true, "Derk", "Vellacott", null, "dvellacottb@google.es", "6374231072"));
		logList.add(new Login("svinac", "tIlvQoPhwLJ0", false, "Sherm", "Vina", "Editor", "svinac@skype.com", null));
		logList.add(new Login("akalinovichd", "C2zuA1SuXtN3", true, "Adelle", "Kalinovich", "Electrical Engineer", "akalinovichd@cafepress.com", "9152378613"));
		logList.add(new Login("kburkmane", "py5dY3uY8u17", true, "Kattie", "Burkman", "Biostatistician III", "kburkmane@ovh.net", "7642550318"));
		logList.add(new Login("dsergantf", "AJ4H0oYA6jy", false, "Dare", "Sergant", null, null, null));
		logList.add(new Login("barcaseg", "5sqUHpNd52", true, "Blanch", "Arcase", "Electrical Engineer", "barcaseg@cocolog-nifty.com", "4449009924"));
		logList.add(new Login("acomussoh", "kP8AIpvW3k0s", false, "Annabelle", "Comusso", "Clinical Specialist", "acomussoh@dailymail.co.uk", "9709000098"));
		logList.add(new Login("larchdecknei", "2MkDmx", true, "Luz", "Archdeckne", "Tax Accountant", null, "5196301724"));
		logList.add(new Login("jmolloyj", "F0oODT4CI", false, null, null, "Research Associate", "awressellj@baidu.com", null));
		logList.add(new Login("cmoyk", "lvgaqzmchQ", false, "Cam", "Moy", "Senior Quality Engineer", "cmoyk@blinklist.com", "2585841145"));
		logList.add(new Login("wmarshalll", "GbtRyNx", true, null, null, null, "adreakinl@cnn.com", "9348936630"));
		logList.add(new Login("bolczykm", "bEgKgV", true, "Bridgette", "Olczyk", "Registered Nurse", "bolczykm@weebly.com", null));
		logList.add(new Login("ngianneschin", "nksAlaY", true, "Nicolis", "Gianneschi", "Editor", "ngianneschin@loc.gov", "7887789517"));
		logList.add(new Login("gbythello", "mV4WgaEJvG", false, "Giralda", "Bythell", null, "gbythello@de.vu", null));
		logList.add(new Login("bbaumadierp", "aFDSP7y", false, "Buddie", "Baumadier", "Operator", "bbaumadierp@mlb.com", "4844401505"));
		logList.add(new Login("hbriggq", "tTrgA6n", false, "Hadlee", "Brigg", "Data Coordiator", "hbriggq@intel.com", "8318098105"));
		logList.add(new Login("msaylorr", "CeKN93IeRs", false, "Meghann", "Saylor", "Actuary", "msaylorr@smh.com.au", "4423309998"));
		logList.add(new Login("dfahys", "CYEnkHIPHI", true, "Dorry", "Fahy", "Nurse Practicioner", "dfahys@wordpress.org", null));
		logList.add(new Login("csheekeyt", "2OnyD46NtS", true, "Costa", "Sheekey", "Computer Systems Analyst III", null, "3122684236"));
		
		
		assertEquals(logList, aa.getLogins());
	}
	
	@Test
	public void testCreateLogin() {
		int result = 1;
		assertEquals(result, aa.createLogin(new Login("chrs", "password", false)));
	}
	
	@Test
	public void testUpdateLogin() {
		int result = 1;
		assertEquals(result, aa.updateLogin(new Login("csheekeyt", "2OnyD46NtS", true)));
	}
	
	@Test
	public void testGetLoginByUsername() {
		
		Login test = new Login("csheekeyt", "2OnyD46NtS", true, "Costa", "Sheekey", "Computer Systems Analyst III", null, "3122684236");
		assertEquals(test, aa.getLoginByUsername("csheekeyt"));
	}
	
	@After
	public void tearDown() throws SQLException, FileNotFoundException {
		try( Connection c = ConnectionUtil.getConnection();){
			RunScript.execute(c, new FileReader("teardown.sql"));
		}
	}
}
