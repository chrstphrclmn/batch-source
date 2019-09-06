package com.revature.daoImplementation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.dao.AccountDAO;
import com.revature.dao.UserDAO;
import com.revature.model.Account;

import connectionUtil.ConnectionUtil;

public class AccountDaoImpl implements AccountDAO {
	@Override
	public int createAccount(String userName, String pass, int accountNum, double accountBal) {
		int accountCreated = 0;
		String sql = "insert into accounts (account_number,account_balance,user_id) values(?,?,?)";
		Account a = new Account(accountNum,accountBal);
		UserDAO udao = new UserDaoImpl();
		int userId = udao.loginUser(userName, pass);
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
				ps.setInt(1, a.getAccountNum());
				ps.setDouble(2, a.getAccountBalance());
				ps.setInt(3, userId);
				accountCreated = ps.executeUpdate();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		return accountCreated;
	}
	public double accountBalance(String userName, String passWord) {
		double balance = 0;
		String sql = "Select account_balance from accounts where user_id = ?";
		UserDAO udao = new UserDaoImpl();
		int num = udao.loginUser(userName, passWord);
		ResultSet rs;
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql);){
				ps.setInt(1,num);
				rs = ps.executeQuery();
				while(rs.next()) {
					balance = Double.parseDouble(rs.getString(1));
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		return balance;
	}

	public double depositAccount(String userName, String passWord, double amount) {
		AccountDAO adao = new AccountDaoImpl();
		UserDAO udao = new UserDaoImpl();
		String sql = "update accounts set account_balance = ? where user_id = ?";
		int id = udao.loginUser(userName, passWord);
		amount = amount + adao.accountBalance(userName, passWord);
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
				ps.setDouble(1, amount);
				ps.setDouble(2, id);
				ps.executeUpdate();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		return amount;
	}

	@Override
	public int withdrawAccount(String userName, String passWord, double amount) {
		String sql = "{call withdraw(?,?)}";
		UserDAO udao = new UserDaoImpl();
		int id = udao.loginUser(userName, passWord);
		try(Connection c = ConnectionUtil.getConnection();
				CallableStatement cs = c.prepareCall(sql)){
				cs.setDouble(1, amount);
				cs.setInt(2, id);
				cs.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return 0;
	}
	@Override
	public int accountID(String user, String pass) {
		int id = 0;
		String sql = "Select account_id from accounts where user_id = ?";
		UserDAO udao = new UserDaoImpl();
		int num = udao.loginUser(user, pass);
		ResultSet rs;
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql);){
				ps.setInt(1,num);
				rs = ps.executeQuery();
				while(rs.next()) {
					id = Integer.parseInt(rs.getString(1));
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		return id;
	}

}