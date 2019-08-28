package com.revature.bankingapp.sysoutgui.views;

public class AccountView {

	private static String [] InputFields = {"First Name: ", "Last Name: ", "Email: ", "Username: ", "Password: ", "Confirm Password"};

	public static String[] getInputFields() {
		return InputFields;
	}

	public static void showAccounts() {
		System.out.println("\n Welcome to Bank Revature!");
		System.out.println("Select an option and press enter");
		System.out.println("| Options:                                       |");
		System.out.println("|        C. Create a checking or savings account |");
		System.out.println("|        L. Logout                               |");
		System.out.println("|        E. Exit                                 |");
	}
	
	public static void showSubAccountCreation() {
		System.out.println("Select an option and press enter");
		System.out.println("| Options:                             |");
		System.out.println("|        C. Create a checking account  |");
		System.out.println("|        S. Create a savings account   |");
		System.out.println("|        B. Go back                    |");
		System.out.println("|        L. Logout                     |");
		System.out.println("|        E. Exit                       |");
	}
}
