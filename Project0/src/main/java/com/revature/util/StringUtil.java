package com.revature.util;

public class StringUtil {
	
	private final static String EMAIL_REGEX = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
	
	public static boolean isValidUsername(String username) {
		
		//TODO: Implement String filter for usernames
		return true;
	}
	
	public static boolean isValidEmail(String email) { return email.matches(EMAIL_REGEX);}
}
