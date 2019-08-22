package com.revature.exception;

public class NegativeLimbsException extends RuntimeException {  //example of exception that is thrown when attempts to give a pet
																//negative limbs is made. this does not make sense and is therefore
																//not allowed by the software package.


	private static final long serialVersionUID = 1L;

	
	
	public NegativeLimbsException() {
		super();
	}
	
	public NegativeLimbsException(String message) {
		super(message);
	}

}
