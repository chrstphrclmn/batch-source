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
		
		String sql = "select * from users";
		
		List<User> users = new ArrayList<User>();
		
		try(Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			
			while(rs.next()) {
//				User u = new User();
//				u.setUser_name(rs.getString("user_name"));
//				u.setPassKey(rs.getString("pass_word"));
//				u.setBalance(rs.getFloat("balance"));
				Integer userId = rs.getInt("user_id");				
				String userName = rs.getString("user_name");
				String passWord = rs.getString("pass_word");
				Float balance = rs.getFloat("balance");
				User u = new User(userId, userName, passWord, balance);
				users.add(u);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User getUserById(int id) {
		User u = null;
		
		// sql statement
		String sql = "select * from users where user_id = ?";
		
		
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
				System.out.println(userName + ":" + passWord + ":" + balance);
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
		String userName = scanner.nextLine().trim();
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
		
		String sql = "Select * from users where user_name = ? and pass_word = ?";
		
		try (Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, userName);
			ps.setString(2, passWord);
			
			ResultSet rs = ps.executeQuery();
			
			// if query works, then create result object
			while(rs.next()) {
				// only get username, password and balance bc that's all we need to work with for now
				String correctUserName = rs.getString("user_name");
				String correctPassWord = rs.getString("pass_word");
				float correctBalance = rs.getFloat("balance");
				System.out.println(correctBalance);
				
				user.setUser_name(correctUserName);
				user.setPassKey(correctPassWord);
				user.setBalance(correctBalance);
			}
			rs.close();
			
//			if the query doesn't work:
			if(user.getPassKey() != null || user.getPassKey().equals(passWord)) {
//				we will pass user_name and password as parameters to loginSuccess to retrieve the info from the account
				loginSuccess(user.getUser_name(), user.getBalance());
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
		System.out.println("\n");
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
		
		String moneyToDeposit = scanner.nextLine();
		
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
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return true;
	}
	
	private boolean withdraw(String userName, Float balance) {
		System.out.println("Enter amount to withdraw: ");
		Scanner scanner = new Scanner(System.in);
		
		String moneyToWithDraw = scanner.nextLine();
		
		while(!(checkInput(moneyToWithDraw))) {
			System.out.println("Enter an actual amount");
			moneyToWithDraw = scanner.nextLine();
		}
		
		
		
		if(Float.parseFloat(moneyToWithDraw) > balance) {
			System.out.println("You don't have enough money in the account. Please enter amoutn equal to or less than your current balance");
		}else {
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
