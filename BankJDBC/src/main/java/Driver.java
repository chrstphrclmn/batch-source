import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.model.User;


public class Driver {

	public static void main(String[] args) {

		
				welcomeScreen();
		
	}
	
	
	public static void welcomeScreen() {
		
		char userChoice = '0';
		Scanner input = new Scanner(System.in);
		while(userChoice != 'c') {
			System.out.println("Welcome to the Private Bank");
			System.out.println("Select from the following options: ");
			System.out.println("a. Login to your account");
			System.out.println("b. Create a new account");
			System.out.println("c. exit");
			System.out.println("Please enter your choice on the line below: ");
			
			userChoice = input.next().charAt(0);
			
			switch(userChoice) {
			case 'a':
				UserDao ua = new UserDaoImpl();
				System.out.println("Please enter your login credentials: ");
				ua.login();
				break;
			case 'b':
				
					UserDao uu = new UserDaoImpl();
					
//					create 2 passKey variables for confirmation of password
					String passKey = "";
					String passKey2 = "a";
					Scanner inputFromUser = new Scanner(System.in);
					System.out.println("Enter your user name to create an account: ");
					String userName = inputFromUser.nextLine().trim();
					while(!(checkIfEmpty(userName))) {
						System.out.println("User Name cannot be empty. Please enter a username: ");
						userName = inputFromUser.nextLine().trim();
					}
					
					
					
/*
 * create 2 lists. One for getting all users back from the DB 
 * Another one for only usernames that we can get from the previous list 
 */
//					List 1:
					List<User> usersList = uu.getUsers();
//					List2:
					List<String> userNames = new ArrayList<String>();
					
//					loop through List 1, get usernames from this list and insert into List 2. 
					for(User u: usersList) {
						userNames.add(u.getUser_name());
					}
				
//					Then check if List 2 already contains the user name entered by the user:
					while(userNames.contains(userName)) {
						System.out.println("Username already exists. "
								+ "please enter another username: ");
						userName = inputFromUser.nextLine().trim();
					}
					
					
					System.out.println("Enter password for your new account: ");
					passKey = inputFromUser.nextLine().trim();
					while(!(checkIfEmpty(passKey))) {
						System.out.println("Password cannot be empty. Please enter  a password: ");
						passKey = inputFromUser.nextLine().trim();
					}
					
				
					System.out.println("Confirm password: ");
					passKey2 = inputFromUser.nextLine().trim();
					while(!(checkIfEmpty(passKey2))) {
						System.out.println("Confirm passkey cannot be empty. Please enter a valid passkey: ");
						passKey2 = inputFromUser.nextLine().trim();
					}
					
/*					As long as pass keys don't match,
 *					this loop will keep repeating and asking for a new password
 */
					
					while(!(passKey.equals(passKey2))) {
						System.out.println("Passwords do not match");
						System.out.println("Enter password for your account: ");
						passKey = inputFromUser.nextLine().trim();
						System.out.println("Confirm your password: ");
						passKey2 = inputFromUser.nextLine().trim();
					}
					
					System.out.println("Enter starting balance: ");
					
					String balance = inputFromUser.nextLine().trim();
					
//					check if starting balance being entered is actually a number!
/*					If method returns false i.e. user input is not a number, loop will repeat!
 * 						bc while(!false = true){...}
 */
					
					
					while(!(checkInput(balance))) {
						System.out.println("Wrong input. Enter an actual number: ");
						balance = inputFromUser.nextLine();
					}
					
					User u = new User(userName, passKey, Float.parseFloat(balance));
					
					uu.createUser(u);
					
					System.out.println("Thanks for creating an account at the Private Bank! \n");
					
					break;
			case 'c':
				break;
			
			default:
				System.out.println("Invalid option!");
				break;
						
				
			}
		}
		System.out.println("Thanks for choosing the Private Bank. Have a good day!");
		input.close();
		
	}
	
	/*
	 * User input validation method to make sure a number is being entered
	 * Returns a boolean
	 *  
	 */
	private static boolean checkInput(String value) {
		if(value == null || value.isEmpty()) {
			return false;
		}
		for(char c : value.toCharArray()) {
				if(Character.isAlphabetic(c)) {
					return false;
				}
		}
		return true;
	}
	private static boolean checkIfEmpty(String value) {
		if(value == null || value.isEmpty()) {
			return false;
		}
		return true;
	}
	

}
