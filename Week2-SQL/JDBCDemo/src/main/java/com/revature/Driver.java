package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.util.ConnectionUtil;

public class Driver {
	
	
	public static void main(String[] args) {
		
		try {
			Connection c = ConnectionUtil.getConnection();
			String driver = c.getMetaData().getDriverName();
			System.out.println(driver);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
