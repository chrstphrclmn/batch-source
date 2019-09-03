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

	public List<User> getUsers() {
		// TODO Auto-generated method stub
		
		String sql = "select * from users";
		
		List<User> users = new ArrayList<User>();
		
		try(Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			
			while(rs.next()) {
				int userId = rs.getInt("user_id");
				String userName = rs.getString("user_name");
				String passWord = rs.getString("pass_word");
				float balance = rs.getFloat("balance");
				User u = new User(userId, userName, passWord, balance);
				users.add(u);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public User getUserById(int id) {
		// TODO Auto-generated method stub
		
		// sql statement
		String sql = "select * from users where user_id = ?";
		
		User u = null;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setInt(1, id); // First question mark gets the id argument
			ResultSet rs = ps.executeQuery();
			
			// loop through results
			while(rs.next()) {
				int userId = rs.getInt("user_id");
				String userName = rs.getString("user_name");
				String passWord = rs.getString("pass_word");
				float balance = rs.getFloat("balance");
				u = new User(userId, userName, passWord, balance);
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

	public int updateUser(User u) {
		// TODO Auto-generated method stub
		int usersUpdated = 0;
		
		String sql = "update users " + "set user_name = ?, " + 
						"pass_word = ? " + "where user_id = ?";
		
		try (Connection c = ConnectionUtil.getConnection(); 
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, u.getUser_name());
			ps.setString(2, u.getPassKey());
			ps.setInt(3, u.getUser_id());
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return usersUpdated;
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
		String userName = scanner.nextLine();
		System.out.println("Please enter your password: ");
		String passWord = scanner.nextLine();
		
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
				deposit(user, balance);
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
	
	public boolean deposit(String user, Float balance) {
		System.out.println("Enter amount you want to deposit into your account: ");
		Float moneyToDeposit;
		Scanner scanner = new Scanner(System.in);
		
		moneyToDeposit = scanner.nextFloat();
		
		String sql = "{call deposit(?, ?)}";
		
		try(Connection c = ConnectionUtil.getConnection(); 
				CallableStatement cs = c.prepareCall(sql)){
			cs.setString(1, user);
			cs.setFloat(2, moneyToDeposit);
			
			cs.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return true;
	}
	
	private boolean withdraw(String userName, Float balance) {
		System.out.println("Enter amount to withdraw: ");
		Float moneyToWithDraw;
		Scanner scanner = new Scanner(System.in);
		
		moneyToWithDraw = scanner.nextFloat();
		
		if(moneyToWithDraw > balance) {
			System.out.println("You don't have enough money in the account. Please enter amoutn equal to or less than your current balance");
		}else {
			String sql = "{call withdraw(?, ?)}";
			try(Connection c = ConnectionUtil.getConnection();
					CallableStatement cs = c.prepareCall(sql)){
				cs.setString(1, userName);
				cs.setFloat(2, moneyToWithDraw);
				
				cs.execute();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		return true;
	}

	
	
}
