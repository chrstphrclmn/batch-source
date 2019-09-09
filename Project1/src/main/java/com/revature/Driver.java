package com.revature;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.PropertyConfigurator;

import com.revature.model.Employee;
import com.revature.model.Request;
import com.revature.service.EmployeeService;
import com.revature.service.RequestService;
import com.revature.util.EncryptionUtil;
import com.revature.util.StringUtil;

public class Driver {
	
	final static String[] statusEnum = {"Unopened", "Opened", "Resolved"};
	
	static EmployeeService eservice = new EmployeeService();
	static RequestService rservice = new RequestService();
	static Scanner scan = new Scanner(System.in);
	
	static Employee user = null;

	public static void main(String[] args) {
		
		PropertyConfigurator.configure("C:\\Users\\micha\\Documents\\sts-3.9.7.RELEASE\\plugins\\org.apache.axis_1.4.0.v201411182030\\lib\\log4j.properties");
		
		consoleDriver();
	}
	
	public static void consoleDriver() {
		
		int opt = 0;
		
		while(true) {
			
			while(user == null) {
			
				System.out.printf("Select from Options:%n- 1 - Log into existing account%n- 2 - Exit Program%n");
				
				try {
					
					opt = scan.nextInt();
					scan.nextLine();
				}
				
				catch(InputMismatchException e) {
					
					System.out.printf("Invalid input.%n");
					scan.next();
				}
				
				switch(opt) {
				
				case 1:
					consoleLogIn();
					break;
					
				case 2:
					System.out.printf("Program Terminated.%n");
					return;
	
				}
			}
			
			while(user != null) {
				
				if(user.getAuthority() == 0) consoleEmployeeLoop();
				else consoleManagerLoop();
				
			}
		}
	}
	
	public static void consoleLogIn() {
		
		String username;
		String password;
		
		System.out.printf("Enter username.%n");
		username = scan.nextLine();
		
		System.out.printf("Enter password.%n");
		password = scan.nextLine();
		
		user = eservice.logInEmployee(username, password);
		
	}
	
	public static void consoleChangePassword() {
		
		String currentPassword;
		String newPassword;
		String confirmNewPassword;
		
		System.out.printf("Enter current password:%n");
		currentPassword = scan.nextLine();
		
		System.out.printf("Enter new password:%n");
		newPassword = scan.nextLine();
		
		System.out.printf("Confirm new password:%n");
		confirmNewPassword = scan.nextLine();
		
		if(!newPassword.contentEquals(confirmNewPassword)) {
			
			System.out.printf("New passwords do not match.%n");
			return;
		}
		
		if(eservice.changePassword(user, currentPassword, newPassword)) {
			
			System.out.printf("Password change successful.%n");
			return;
		}
		
		System.out.printf("Password change failed.%n");
			
	}

	public static void consoleEmployeeLoop() {
		
		int opt = 0;
		
		while(true) {
			
			System.out.printf("Employee Landing%nSelect from Options:%n- 1 - Manage Reimbursement Requests%n- 3 - Change Password%n- 4 - Log Out.%n");
			
			try {
				
				opt = scan.nextInt();
				scan.nextLine();
			}
			
			catch(InputMismatchException e) {
				
				System.out.printf("Invalid input.%n");
				scan.next();
			}
			
			switch(opt) {
			
			case 1:
				consoleRequestsLandingEmployee();
				break;
			
			case 3:
				consoleChangePassword();
				break;
				
			case 4:
				user.logout();
				user = null;
				return;

			}
		}
	}

	public static void consoleManagerLoop() {
		
		int opt = 0;
		
		while(true) {
			
			System.out.printf("Management Landing%nSelect from Options:%n- 1 - Manage Reimbursement Requests%n- 3 - Change Password%n- 4 - Log Out.%n");
			
			try {
				
				opt = scan.nextInt();
				scan.nextLine();
			}
			
			catch(InputMismatchException e) {
				
				System.out.printf("Invalid input.%n");
				scan.next();
			}
			
			switch(opt) {
			
			case 1:
				consoleRequestsLandingEmployee();
				break;
			
			case 3:
				consoleChangePassword();
				break;
				
			case 4:
				user.logout();
				user = null;
				return;

			}
		}
	}

	public static void consoleRequestsLandingEmployee() {
		
		int opt = 0;
		
		while(true) {
			
			System.out.printf("Select from Options:%n- 1 - View All Requests%n- 2 - View Pending Requests%n- 3 - View Approved Requests%n- 4 - Submit New Request%n- 5 - Return to Previous Menu%n");
		
			try {
				
				opt = scan.nextInt();
				scan.nextLine();
			}
			
			catch(InputMismatchException e) {
				
				System.out.printf("Invalid input.%n");
				scan.next();
			}
			
			switch(opt) {
			
			case 1:
				consoleViewAllRequests();
				break;
			
			case 2:
				consoleViewAllPendingRequests();
				break;
			
			case 3:
				consoleViewAllResolvedRequests();
				break;
				
			case 4:
				consoleSubmitNewRequest();
				break;
				
			case 5:
				return;
	
			}
		}
	}
	
	public static void consoleViewAllRequests() {
		
		List<Request> requests = rservice.getRequestsByApplicant(user);
		
		System.out.println();
		
		for(Request r : requests) {
			
			System.out.printf("%3d - %s: $%.2f%n", r.getRequestId(), statusEnum[r.getStatus()], r.getAmount());
		}
		
		System.out.println();
	}
	
	public static void consoleViewAllPendingRequests() {
		
		List<Request> requests = rservice.getRequestsByApplicant(user);
		
		System.out.println();
		
		for(Request r : requests) {
			
			if(r.getStatus() != 2) System.out.printf("%3d - %s: $%.2f%n", r.getRequestId(), statusEnum[r.getStatus()], r.getAmount());
		}
		
		System.out.println();
	}
	
	public static void consoleViewAllResolvedRequests() {
		
		List<Request> requests = rservice.getRequestsByApplicant(user);
		
		System.out.println();
		
		for(Request r : requests) {
			
			if(r.getStatus() == 2) System.out.printf("%3d - %s: $%.2f%n", r.getRequestId(), statusEnum[r.getStatus()], r.getAmount());
		}
		
		System.out.println();
	}
	
	public static void consoleSubmitNewRequest() {
		
		double amount = 0;
		String description;
		String reference;
		
		while(true) {
			
			System.out.printf("Enter a valid monetary amount to be reimbursed.%n");
			
			try {
				
				amount = scan.nextDouble();
				scan.nextLine();
			}
			
			catch(InputMismatchException e) {
				
				System.out.printf("Invalid input.%n");
				scan.next();
			}
			
			if(StringUtil.isValidAmount(amount)) break;
		}
		
		System.out.printf("Enter a description for your reimbursement.%n");
		description = scan.nextLine();
		
		System.out.printf("Submit an additional reference for your reimbursement.%n");
		reference = scan.nextLine();
		
		if(rservice.createRequest(new Request(user, rservice.getNextRequestId(), amount, description, reference))) {
			
			System.out.printf("Request successfully created.%n");
			return;
		}
		
		System.out.printf("Request creation failed.%n");
	}
}
