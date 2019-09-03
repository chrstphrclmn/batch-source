package com.revature.visualfeedback;

import com.revature.model.abstractObjects.Account;

public class Mensajes {
	
	public static void start() {
		
		System.out.println(
				
				  "	Welcome to Mocking Banck CQ"
				+ "\n\n"
				+ "		1	Create User"
				+ "\n		2	Log in"
				+ "\n		0	Close "
				+ "\n"+"\n"+"\n"+"\n"+"\n"
				+ ""
				+ ""
				+ ""
						
				
				);
	}
	
	
	public static void enterUser() {
		
		System.out.println("Please enter your username:");
		
	}
	public static void enterPassword() {
		System.out.println("Please enter password: ");
	}
	
	public static void userMenu(String userName) {
		
		System.out.println(
				
				  "	Welcome "+userName+""
				+ "\n\n"
				+ "	Please select one of the following options"
				+ "\n		1	Create Account"
				+ "\n		2	View Account Balance"
				+ "\n		0	LogOut "
				+ "\n"+"\n"+"\n"+"\n"+"\n"
				+ ""
				+ ""
				+ ""
				);
		
	}
	
	public static void invalidArguments() {
		System.out.println(
				"There's a problem with the information you provided"
				+ "\n"+"\n"+"\n"+"\n"+"\n"
				);
	}
	
	public static void invalidOption() {
		System.out.println(
				"Enter a valid Option"
				+ "\n"+"\n"+"\n"+"\n"+"\n"
				);
	}
	public static void end() {
		
		System.out.println(
			"Thanks for using Mocking Bank"
			+ "\n"+"\n"+"\n"+"\n"+"\n"
				);
	}


	public static void crearCuenta() {
		System.out.println(
				 "Creacion Cuenta"
				+" 1 Savings "
				+"\n 2 Checking"		 
				+"\n"+"\n"+"\n"+"\n"+"\n"
				);
		
		
	}


	public static void initialAmount() {
		System.out.println(
				 "Initial Amount"
						 
				+"\n"+"\n"+"\n"+"\n"+"\n"
				);
	}


	public static void selectAccount() {
		System.out.println(
				"\n"
				+"\n"
				+"\n"
				+"Select an account"
				+"\n"+"\n"+"\n"+"\n"+"\n"
				);
	}


	public static void depositMoney() {
		
		System.out.println(
			"\n"
			+"	0  Cancel transaction"	
			+"\n"
			+"	1  Deposit"
			+"\n"
			+"	2  Withdraw"		 
			+"\n"+"\n"+"\n"+"\n"+"\n"
			);
		
	}


	public static void balanceCuenta(Account cuenta) {
		System.out.print(cuenta.getAccountNumber()
				+"--------------------------------------------");
		System.out.printf("$%.2f", cuenta.getTotalMoney());
		
	}


	


	public static void depositOrwithdraw() {
		System.out.println(
				"\n"
				+"	1  Deposit"
				+"\n"
				+"	2  Withdraw"		 
				+"\n"+"\n"+"\n"+"\n"+"\n"
				);
	}


	public static void amount() {
		System.out.println(
				"\n"
				+"	Write the desired amount"
				+"\n");
		
		// TODO Auto-generated method stub
		
	}


	
}
