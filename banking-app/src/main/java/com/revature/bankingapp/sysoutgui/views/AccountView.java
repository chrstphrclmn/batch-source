package com.revature.bankingapp.sysoutgui.views;

import java.util.List;

import com.revature.bankingapp.sysoutgui.model.SubAccount;

public class AccountView {

	public static void showAccounts(List<SubAccount> subAccounts) {
		System.out.println("\n Welcome to Bank Revature!");
		System.out.println("Select an option and press enter");
		System.out.println("| Options:                                       |");
		System.out.println("|        C. Create a checking or savings account |");
		for (int i = 0; i < subAccounts.size(); i++) {
            System.out.println("|        " + i + ". " + subAccounts.get(i).getType() +" " + subAccounts.get(i).getId() +"           ");
        }
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
	
	public static void showSubAccountOptions() {
		System.out.println("\n Select an option and press enter");
		System.out.println("|   Store Management         |");
		System.out.println("| Options:                   |");
		System.out.println("|        D. Deposit Money    |");
		System.out.println("|        W. Withdraw Money   |");
		System.out.println("|        V. View Balance     |");
		System.out.println("|        B. Go back          |");
		System.out.println("|        E. Exit             |");
	}
}
