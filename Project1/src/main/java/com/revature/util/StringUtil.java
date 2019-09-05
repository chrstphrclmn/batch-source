package com.revature.util;

public class StringUtil {
	
	private static final String EMAIL_REGEX = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
	private static final String USERNAME_REGEX = "^(?=.{6,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$";
	
	private StringUtil() {
		
		throw new IllegalStateException("Utility Class");
	}
	
	public static boolean isValidUsername(String username) { return username.matches(USERNAME_REGEX);}
	public static boolean isValidEmail(String email) { return email.matches(EMAIL_REGEX);}
}