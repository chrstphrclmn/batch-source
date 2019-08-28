package com.revature.bankingapp.sysoutgui.security;

/**
 *
 * @author sj_sc
 */
public class DatabaseCredentials {
     static final String driver = "org.postgresql.Driver";
     static final String db = "postgres";
     static final String url = "jdbc:postgresql://bankingappdb.cjus9rioqccl.us-east-2.rds.amazonaws.com:5432/" + db;
     static final String user = "postgres";
     static final String pass = "password";
	public static String getDriver() {
		return driver;
	}
	public static String getDb() {
		return db;
	}
	public static String getUrl() {
		return url;
	}
	public static String getUser() {
		return user;
	}
	public static String getPass() {
		return pass;
	}
     
     
}

