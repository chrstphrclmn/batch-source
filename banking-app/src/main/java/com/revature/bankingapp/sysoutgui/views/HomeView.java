package com.revature.bankingapp.sysoutgui.views;

public class HomeView {

	private static String [] InputFields = {"First Name: ", "Last Name: ", "Email: ", "Username: ", "Password: ", "Confirm Password: "};

	public static String[] getInputFields() {
		return InputFields;
	}

	public static void showHome() {
		System.out.println("\n Welcome to Bank Revature!");
		System.out.println("Select an option and press enter");
		System.out.println("| Options:                        |");
		System.out.println("|        C. Create a user Account |");
		System.out.println("|        L. Login                 |");
		System.out.println("|        E. Exit                  |");
	}

	public static void showForm(String form) {
		System.out.println("\n Select an option and press enter");
		switch(form.toLowerCase()) {
		case "sign up":
			System.out.println("|   Sign up                  |");
			break;
		case "login":
			System.out.println("|   Login                    |");
			break;
		}
		
		System.out.println("| Options:                   |");
		System.out.println("|        T. Type information |");
		System.out.println("|        B. Go back          |");
		System.out.println("|        E. Exit             |");
	}

	public static void showFormat() {
		System.out.println("| Please enter the following information, each followed by the 'enter' key.");
	}
}
