package main;

import java.util.List;

public class Application {
	
	public static void main(String[] args) {
		
		List<Account> x = Account.createAccounts(5);
		
		for(Account a : x) {
			
			System.out.printf("ID: %d\nType: %s\n", a.id, a.accountType);
		}
	}
}
