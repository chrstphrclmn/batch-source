package com.revature.bankingapp;

import java.util.Scanner;

//If I have multiple Scanners and close one, it will close the underlying inputstream (System.in), 
//so no other scanners can read from it. This is why I am using the singleton pattern to use a single scanner
public class SingletonScanner {
	// Eager
	private static final Scanner scanner = new Scanner(System.in);

	private SingletonScanner() {
	}

	public static Scanner getScannerInstance() {
		return scanner;
	}
}
