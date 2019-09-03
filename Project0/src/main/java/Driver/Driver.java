package Driver;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.revature.model.User;
import com.revature.service.AccountService;
import com.revature.service.UserService;

public class Driver {
	private static Logger logger = Logger.getLogger(Driver.class.getName());
	
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws SQLException {
		PropertyConfigurator.configure("C:\\Users\\Physics_Research\\Desktop\\log4j.properties");
		UserService us = new UserService();
		AccountService as = new AccountService();
		int choice;
		System.out.println("Welcome to the Project0 Banking App. Please select from the menu below.\n"
						+  "1. Create User\n"
						+  "2. Login User\n"
						+  "3. Delete User");
		choice = Integer.parseInt(sc.nextLine());
		switch(choice) {
		case 1: String accountEmail;
				String accountPass;
				System.out.println("Enter email of user to be created.");
				accountEmail = sc.nextLine();
				accountEmail = accountEmail.trim();
				accountEmail = accountEmail.toLowerCase();
				System.out.println("Enter password of user to be created.");
				accountPass = sc.nextLine();
				User u = new User(accountEmail,accountPass);
				us.createUser(u);
				logger.info("User Created");
				break;
		case 2: System.out.println("Enter User Email.");
				accountEmail = sc.nextLine();
				accountEmail = accountEmail.trim();
				System.out.println("Enter User Password.");
				accountPass = sc.nextLine();
				us.loginUser(accountEmail, accountPass);
				logger.info("Login Successful");
				System.out.println("Please select from the menu below.\n"
						+  "1. Get Account Balance\n"
						+  "2. Deposit Funds\n"
						+  "3. Withdraw Funds\n"
						+  "4. Create Account\n"
						+  "5. Logout");
					int choice2 = Integer.parseInt(sc.nextLine());
					switch(choice2) {
					case 1: double bal = as.accountBalance(accountEmail, accountPass);
							System.out.println("Account Balance is: "+ bal);
							break;
					case 2: System.out.println("Enter Amount to Deposit.");
					  		double deposit;
					  		deposit = Double.parseDouble(sc.nextLine());
					  		deposit = as.accountDeposit(accountEmail, accountPass, deposit);
					  		System.out.println("Amount Deposited. New Balance is: "+deposit);
					  		break;
					case 3:System.out.println("Enter amount to be withdrawn.");
						   double amount = Double.parseDouble(sc.nextLine());
						   as.accountWithraw(accountEmail, accountPass, amount);
						   double withdrawn = as.accountBalance(accountEmail, accountPass);
						   System.out.println("Amount withdrawn. New balance is: " + withdrawn);
						   break;
					case 4: int accountNum;
							System.out.println("Create 10 digit account number. 0 is not allowed as valid input.");
							accountNum = Integer.parseInt(sc.nextLine());
							System.out.println("Enter starting balance.");
							bal= Double.parseDouble(sc.nextLine());
							as.createAccount(accountEmail, accountPass, accountNum, bal);
							System.out.println("Account Created. Balance Added. Balance is: " + bal);
							break;
					case 5: logger.info("Logged Out");
					default:System.out.println("Please select from the menu.");
							break;
				}
				break;
		case 3: String accountDeleteEmail;
				String accountDeletePass;
				System.out.println("Enter email of user to be deleted.");
				accountDeleteEmail = sc.nextLine();
				System.out.println("Enter password of user to be deleted.");
				accountDeletePass = sc.nextLine();
				us.userDeleted(accountDeleteEmail, accountDeletePass);
				logger.info("User Deleted");
				break;
		default: System.out.println("Please select from menu.");
				}
	}
}
