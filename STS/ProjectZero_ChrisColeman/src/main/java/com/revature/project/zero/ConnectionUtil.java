package com.revature.project.zero;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	private static Connection connection;
	
	public static Connection getConnection() throws SQLException {

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = (System.getenv("DB_URL"));
		//System.out.println(url);
		String username = System.getenv("DB_USER");
		//System.out.println(username);
		String password = System.getenv("DB_PASS");
		//System.out.println(password);

		if(connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, username, password);
		}

		return connection;
	}

}
