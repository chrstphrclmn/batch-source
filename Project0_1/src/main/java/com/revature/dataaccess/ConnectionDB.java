package com.revature.dataaccess;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionDB {
	
	private static Connection connection;

	public static Connection getHardCodedConnection() throws SQLException {

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = "jdbc:postgresql://database-2.cr3jletzfncf.us-east-2.rds.amazonaws.com:5432/postgres";
		String username = "user";
		String password = "pass";

		if(connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, username, password);
		}

		return connection;
	}

	public static Connection getConnectionFromFile() throws IOException, SQLException {
		Properties prop = new Properties();
		InputStream in = new FileInputStream("connection.properties");
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		if(connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, username, password);
		}
		return connection;
	}

	public static Connection getConnection() throws SQLException {

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = System.getenv("URL");
		String username = System.getenv("DB_USER");
		String password = System.getenv("DB_PASSWORD");

		if(connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, username, password);
		}

		return connection;
	}
	
	public static Connection getH2Connection() {
		try {
			if(connection == null || connection.isClosed()) {
				connection = DriverManager.getConnection("jdbc:h2:~/test");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

}
