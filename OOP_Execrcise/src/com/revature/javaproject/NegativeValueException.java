package com.revature.javaproject;

public class NegativeValueException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public NegativeValueException() {
		super();
	}

	public NegativeValueException(String message) {
		super(message);
	}
}
