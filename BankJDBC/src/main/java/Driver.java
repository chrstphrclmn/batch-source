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
		while(userChoice != 'd') {
			System.out.println("Welcome to the Private Bank");
			System.out.println("Select from the following options: ");
			System.out.println("a. Login to your account");
			System.out.println("b. Create a new account");
			System.out.println("d. exit");
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
					String passKey = "";
					String passKey2 = "-";
					Scanner inputFromUser = new Scanner(System.in);
					System.out.println("Enter your user name to create an account: ");
					String userName = inputFromUser.nextLine().trim();

					List<User> usersList = uu.getUsers();
					List<String> userNames = new ArrayList<String>();
					
					for(User u: usersList) {
						userNames.add(u.getUser_name());
					}
				
					while(userNames.contains(userName)) {
						System.out.println("Username already exists. please enter another username: ");
						userName = inputFromUser.nextLine().trim();
					}
					
					while(!(passKey.equals(passKey2))) {
						System.out.println("Enter password for your account: ");
						passKey = inputFromUser.nextLine();
						System.out.println("Confirm your password: ");
						passKey2 = inputFromUser.nextLine();
					}
					System.out.println("Enter starting balance: ");
					
					String balance = inputFromUser.nextLine();
					
					while(!(checkInput(balance))) {
						System.out.println("Wrong input. Enter an actual number: ");
						balance = inputFromUser.nextLine();
					}
					
					User u = new User(userName, passKey, Float.parseFloat(balance));
					
					uu.createUser(u);
					
					System.out.println("Thanks for creating opening an account at the Private Bank! \n");
					
					break;
			
			default:
				System.out.println("Invalid option!");
				break;
						
				
			}
		}
		System.out.println("Thanks for choosing the Private Bank");
		input.close();
		
	}
	
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
	

}
