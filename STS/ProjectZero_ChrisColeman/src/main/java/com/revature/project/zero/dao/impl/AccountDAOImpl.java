package com.revature.project.zero.dao.impl;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.project.zero.ConnectionUtil;
import com.revature.project.zero.dao.AccountDAO;
import com.revature.project.zero.model.Account;

public class AccountDAOImpl implements AccountDAO {
	

	@Override
	public List<Account> getAccounts() {
		
		String sql = "select * from account";
		
		List<Account> accounts = new ArrayList<>();
		
		try (Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			
			while(rs.next()) {
				int accountNum = rs.getInt("accountnum");
				String accountType = rs.getString("accounttype");
				double value = rs.getDouble("value");
				Account a = new Account(accountNum, accountType, value);
				accounts.add(a);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return accounts;
		
		
	}

	@Override
	public Account getAccountByNum(int accountNum) {

		
		String sql = "select * from account where accountnum = ?";
		Account a = null;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setInt(1, accountNum); // jdbc 1 based index
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int accountNumber = rs.getInt("accountnum");
				String accountType = rs.getString("accounttype");
				double value = rs.getDouble("value");
				a = new Account(accountNumber, accountType, value);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return a;
	}

	@Override
	public int createAccount(Account a) {
		
		int accountsCreated = 0;
		String sql = "insert into account (accounttype, value, accountnum) values (?, ?, ?)";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, a.getAccountType());
			ps.setDouble(2, a.getValue());
			ps.setInt(3, a.getAccountNum());
			
			accountsCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return accountsCreated;
		
	}

	@Override
	public int updateAccount(Account a) {
		
		int accountsUpdated = 0;
		String sql = "update account "
				+ "set accounttype = ?, "
				+ "value = ? "
				+ "where accountnum = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, a.getAccountType());
			ps.setDouble(2, a.getValue());
			ps.setInt(3, a.getAccountNum());
			
			accountsUpdated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return accountsUpdated;
		
	}

	@Override
	public int deleteAccount(Account a) {
		
		int rowsDeleted = 0;
		String sql = "delete from account where accountnum = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setInt(1, a.getAccountNum());
			rowsDeleted = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowsDeleted;
		
	}

	@Override
	public double depSlashWithdraw(double ammount, int a) {

		String sql = "{call depslashwithdraw(?,?)}";

		double retValue = -1000000;
		try(Connection c = ConnectionUtil.getConnection();
			CallableStatement cs = c.prepareCall(sql)){
			cs.setDouble(1, ammount);
			cs.setInt(2, a);
			
			ResultSet rs = cs.executeQuery();
			rs.next();
			retValue = rs.getDouble(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return retValue;
		
	}
		
	}
	
	


