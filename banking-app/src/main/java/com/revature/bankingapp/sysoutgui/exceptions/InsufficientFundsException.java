package com.revature.bankingapp.sysoutgui.exceptions;

public class InsufficientFundsException extends IllegalArgumentException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsufficientFundsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InsufficientFundsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InsufficientFundsException(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}

	public InsufficientFundsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
