package com.revature.bankingapp.sysoutgui.views;

import java.util.List;

import com.revature.bankingapp.sysoutgui.model.SubAccount;

public class AccountView {

	public static void showAccounts(List<SubAccount> subAccounts) {
		System.out.println("\n Welcome to Bank Revature!");
		System.out.println("Select an option and press enter");
		System.out.println("| Options:                                       |");
		System.out.println("|        C. Create an account                    |");
		for (int i = 0; i < subAccounts.size(); i++) {
			System.out.println("|        " + i + ". " + subAccounts.get(i).getType() + " Account, Id: "
					+ subAccounts.get(i).getId() + "           ");
		}
		System.out.println("|        L. Logout                               |");
		System.out.println("|        E. Exit                                 |");
	}

	public static int showTransferAccounts(List<SubAccount> subAccounts, String notification, long skip) {
		int indexSkipped = 0;
		System.out.println("Select the account that will be " + notification);
		System.out.println("|   Account Management                   |");
		System.out.println("| Options:                               |");
		for (int i = 0, j = 0; i < subAccounts.size(); i++) {
			SubAccount subAccount = subAccounts.get(i);
			if (subAccount.getId() != skip) {
				System.out.println("|        " + j + ". " + subAccount.getType() + " Account, Id: "
						+ subAccounts.get(i).getId() + "           ");
				j++;
			}else {
				indexSkipped = i;
			}
		}
		System.out.println("|        B. Go back                      |");
		System.out.println("|        L. Logout                       |");
		System.out.println("|        E. Exit                         |");
		return indexSkipped;
	}

	public static void showSubAccountCreation() {
		System.out.println("Select an option and press enter");
		System.out.println("|   Account Management                 |");
		System.out.println("| Options:                             |");
		System.out.println("|        C. Create a checking account  |");
		System.out.println("|        S. Create a savings account   |");
		System.out.println("|        B. Go back                    |");
		System.out.println("|        L. Logout                     |");
		System.out.println("|        E. Exit                       |");
	}

	public static void showSubAccountOptions() {
		System.out.println("\n Select an option and press enter");
		System.out.println("|   Account Management       |");
		System.out.println("| Options:                   |");
		System.out.println("|        D. Deposit Money    |");
		System.out.println("|        W. Withdraw Money   |");
		System.out.println("|        T. Transfer funds   |");
		System.out.println("|        V. View Balance     |");
		System.out.println("|        H. View History     |");
		System.out.println("|        B. Go back          |");
		System.out.println("|        L. Logout           |");
		System.out.println("|        E. Exit             |");
	}
}
