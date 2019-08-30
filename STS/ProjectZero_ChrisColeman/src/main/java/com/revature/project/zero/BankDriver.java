package com.revature.project.zero;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class BankDriver {

	static String username = "";
	static String pass = "";
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args){
		
		
		
		
		System.out.println("Welcome to Fuax Green Bank.");
		queryUserDetails();
		
		try(Connection connection = ConnectionUtil.getConnection();) {
			
			System.out.println("Connection Successful.");
		} catch (SQLException e) {
			System.out.println("Connection failed.");
			e.printStackTrace();
		}
		
		scan.close();
	}
	
	public static void queryUserDetails() {
		
		System.out.println("Please enter 1 to login.");
		System.out.println("Please enter 2 to register.");

		String inputTest = scan.nextLine();
		
		if(inputTest.equals("1")) {
			login();
		}
		else if (inputTest.contentEquals("2")) {
			register();
		}
		else {
			System.out.println("That is not a valid command.");
			queryUserDetails();
		}
		
	}
	
	public static void login() {
		
		System.out.println("What is your username.");
		username = scan.nextLine();
		System.out.println("What is your password.");
		pass = scan.nextLine();
		
	}
	
	public static void register() {
		
		System.out.println("Please set a username.");
		username = scan.next();
		setPassword();
		
	}
	
	public static void setPassword() {
		System.out.println("Please choose a password.");
		String hold = scan.nextLine();
		System.out.println("Please reenter your password to confirm.");
		String hold2 = scan.nextLine();
		
		if(hold.equals(hold2)) {
			pass = hold;
		}
		else {
			System.out.println("Those passwords do not match.");
			setPassword();
		}
	}
	
	

}
