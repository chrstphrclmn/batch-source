package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.dao.UserDao;
import com.revature.model.User;
import com.revature.util.ConnectionUtil;


public class UserDaoImpl implements UserDao {

	@Override
	public List<User> getUsers() {
		// get all users
		
		String sql = "select * from users";
		
		List<User> users = new ArrayList<User>();
		
		// simple statement should because data does not need to be parametrized
		try(Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			
			while(rs.next()) {

				Integer userId = rs.getInt("user_id");				
				String userName = rs.getString("user_name");
				String passWord = rs.getString("pass_word");
				Float balance = rs.getFloat("balance");
				// create a new user
				User u = new User(userId, userName, passWord, balance);
				// keep adding the user to the ArrayList
				users.add(u);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		// return ArrayList of users
		return users;
	}

	@Override
	public User getUserById(int id) {
		User u = null;
		
		// sql statement
		String sql = "select * from users where user_id = ?";
		
		// Prepared Statement because data is also being sent
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setInt(1, id); // First question mark gets the id argument
			ResultSet rs = ps.executeQuery();
			
			// loop through results
			while(rs.next()) {
				Integer userId = rs.getInt("user_id");
				String userName = rs.getString("user_name");
				String passWord = rs.getString("pass_word");
				Float balance = rs.getFloat(4);
				u = new User(userName, passWord, balance);
			}
			
			// close the statement connection
			rs.close();
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	public int createUser(User u) {
		// TODO Auto-generated method stub
		int usersCreated = 0;
		
//		String passKey = "";
//		String passKey2 = "-";
//		Scanner inputFromUser = new Scanner(System.in);
//		
//		System.out.println("Enter your user name to create an account: ");
//		String userName = inputFromUser.nextLine();
//		
////		keep asking for password until they match
//		while(!(passKey.equals(passKey2))) {
//			System.out.println("Enter password for your account: ");
//			passKey = inputFromUser.nextLine();
//			System.out.println("Confirm your password: ");
//			passKey2 = inputFromUser.nextLine();
//		}
//		
//		@SuppressWarnings("deprecation")
//		Float balance = new Float(0.00f);
		
		
		// sql query
		String sql = "insert into users (user_name, pass_word, balance) values (?, ?, ?)";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setString(1, u.getUser_name());
			ps.setString(2, u.getPassKey());
			ps.setFloat(3, u.getBalance());
			
			usersCreated = ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		// returns 1 if user creation is successful. 0 otherwise.
		return usersCreated;
	}


	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		int rowsDeleted = 0;
		
		String sql = "delete from users where user_id = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setInt(1, id);
			
			rowsDeleted = ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowsDeleted;
	}

	@Override
	public void login() {
		// TODO Auto-generated method stub
		User user = new User();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please enter your user name: ");
		
		// getting rid of white spaces
		String userName = scanner.nextLine().trim();
		
		/* check if fields are left blank. If they are left blank, then program wont proceed until
		 * something is entered. If checkIfEmpty returns false (i.e. field was left empty) 
		 * loop will repeat until a value is entered.
		 */
		
		while(!(checkIfEmpty(userName))) {
			System.out.println("User Name cannot be empty. Please enter your User Name: ");
			userName = scanner.nextLine().trim();
		}
		
		System.out.println("Please enter your password: ");
		String passWord = scanner.nextLine().trim();
		
		while(!(checkIfEmpty(passWord))) {
			System.out.println("Password cannot be empty. Please enter your password: ");
			passWord = scanner.nextLine().trim();
		}
		
		// Check for username and password to authenticate
		
		String sql = "Select * from users where user_name = ? and pass_word = ?";
		
		try (Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, userName);
			ps.setString(2, passWord);
			
			ResultSet rs = ps.executeQuery();
			
			// if query works, then create result object
			while(rs.next()) {
				/* only get username, password and balance bc that's all we
				 * need to work with for now
				 */
				String correctUserName = rs.getString("user_name");
				String correctPassWord = rs.getString("pass_word");
				Float correctBalance = rs.getFloat("balance");
				
				user.setUser_name(correctUserName);
				user.setPassKey(correctPassWord);
				user.setBalance(correctBalance);
			}
			rs.close();
			
			// If user entered password matches the password in DB, then run loginSuccess command
			if(user.getPassKey() != null || user.getPassKey().equals(passWord)) {
//				we will pass user_name and password as parameters to loginSuccess to retrieve the info from the account
				loginSuccess(user.getUser_name(), user.getBalance());
			}else {
				System.out.println("Invalid username or password");
				login();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	
	
	private void loginSuccess(String user, Float balance) {
		char selected = 'e';
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to your account. Choose from the following options: ");
		System.out.println("\n");
	
		while(selected != 'a') {
			System.out.println("a. Log Out");
			System.out.println("b. Check Balance");
			System.out.println("c. Withdraw Money");
			System.out.println("d. Deposit Money");
			
			selected = scanner.next().charAt(0);
			
			switch(selected) {
			case 'a':
				System.out.println("Thanks for visiting. Have a nice day!");
				System.out.println("\n");
				break;
			case 'b':
				balance(user);
				break;
			case 'c':
				withdraw(user, balance);
				break;
			case 'd':
				deposit(user);
				break;
			}
		}
	}
	
	private void balance(String user_name) {
		User u = null;
		
		String sql = "Select balance from users where user_name = ?";
		
		try (Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, user_name);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				// just need data from balance column to print out:
				Float balance = rs.getFloat("balance");
				System.out.println("Balance is: " + balance);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean deposit(String user) {
		System.out.println("Enter amount you want to deposit into your account: ");
		Scanner scanner = new Scanner(System.in);
		
		// ask user how much they want to deposit
		String moneyToDeposit = scanner.nextLine();
		
		// Validate input. Making sure they enter a valid number:
		while(!(checkInput(moneyToDeposit))) {
			System.out.println("Invalid amount entered. Please enter an actual number: ");
			moneyToDeposit = scanner.nextLine();
		}
		
		
//		callable statement. Defined in sql script. Takes in username and amount to deposit.
		
		String sql = "{call deposit(?, ?)}";
		
		try(Connection c = ConnectionUtil.getConnection(); 
				CallableStatement cs = c.prepareCall(sql)){
			cs.setString(1, user);
			cs.setFloat(2, Float.parseFloat(moneyToDeposit));
			
			cs.execute();
			
			// print balance again after the transaction:
			
			balance(user);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return true;
	}
	
	private boolean withdraw(String userName, Float balance) {
		System.out.println("Enter amount to withdraw: ");
		Scanner scanner = new Scanner(System.in);
		
		// ask user how much money to withdraw
		String moneyToWithDraw = scanner.nextLine();
		
		// Validate the input to make sure it's a valid number
		
		while(!(checkInput(moneyToWithDraw))) {
			System.out.println("Enter an actual amount");
			moneyToWithDraw = scanner.nextLine();
		}
		
		
		// Check to make sure they can't withdraw more than they have
		
		if(Float.parseFloat(moneyToWithDraw) > balance) {
			System.out.println("You don't have enough money in the account. "
					+ "Please enter amoutn equal to or less than your current balance");
		}else {
			
			// callable statement. Call withdraw function in sql script if validation passes
			String sql = "{call withdraw(?, ?)}";
			try(Connection c = ConnectionUtil.getConnection();
					CallableStatement cs = c.prepareCall(sql)){
				cs.setString(1, userName);
				cs.setFloat(2, Float.parseFloat(moneyToWithDraw));
				
				cs.execute();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		return true;
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
	
	private static boolean checkIfEmpty(String value) {
		if(value == null || value.isEmpty()) {
			return false;
		}
		return true;
	}
	
	
}
