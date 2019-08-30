package com.revature;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.models.BankAccount;
import com.revature.models.UserAccount;
import com.revature.service.UserAccountService;

public class Driver {
	
	static Scanner scan = new Scanner(System.in);
	static UserAccountService service = new UserAccountService();
	static UserAccount user = null;

	public static void main(String[] args) {
	
		boolean flag = true;
		int opt = 0;
		
		while(flag == true) {
			
			while(user == null) {
				
				System.out.printf("Select Option:%n- 1 - Log Into Existing Account.%n- 2 - Create a New Account.%n");
				
				try {
					
					opt = scan.nextInt();	
					scan.nextLine();
				}
				
				catch(InputMismatchException e) {
					
					e.printStackTrace();
				}
				
				switch(opt) {
				
				case 1:
					
					logIn();
					break;
				
				
				case 2:
					
					createNewUser();
				}
			}
			
			while(user != null) {
				
				System.out.println("Select Option:%n- 1 - View Current Banking Accounts%n- 2 - Open a New Banking Account%n- 3 - Log Out of Account");
				
				try {
					
					opt = scan.nextInt();	
					scan.nextLine();
				}
				
				catch(InputMismatchException e) {
					
					e.printStackTrace();
				}
				
				switch(opt) {
				
				
				}
				
			}
		}
	}
	
	public static void logIn() {
		
		String username;
		String password;
		
		System.out.println("%nEnter a valid username or -q to quit.");
		username = scan.nextLine();
		
		if(username.contentEquals("-q")) return;
		
		System.out.println("Enter the password associated.");
		password = scan.nextLine();
		
		user = service.logInUserAccount(username, password);
	}
	
	public static void createNewUser() {
		
		String username;
		String password;
		String firstname;
		String lastname;
		String email;
		
		boolean flag = true;
		
		System.out.println("%nEnter desired username");
		
		while (flag == true) {
			
			username = scan.nextLine().trim();
			
			if(service.existingUsername(username)) {
				
				System.out.println("%nUsername already taken: Please enter another.");
			}
			
			else {
				
				flag = false;
			}
		}
		
		flag = true;
		
		System.out.println("%Enter desired password");
		
	}
}
