package com.exception;


public class TooSadException extends Exception {
	
	@Override
	public String getMessage() {
		return "You cannot input a number less than 4... It would be too sad.";
	}

}
