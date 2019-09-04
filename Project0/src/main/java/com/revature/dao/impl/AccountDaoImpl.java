package com.revature.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.AccountDao;
import com.revature.model.Account;
import com.revature.util.ConnectionUtil;

public class AccountDaoImpl implements AccountDao {

	@Override
	public Account getAccountByUN(String UN) {
		String sql = "select * from project0.account where un = ?";
		Account a = null;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, UN);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String accUN = rs.getString("un");
				int accId = rs.getInt("id");
				String accPW = rs.getString("pw");
				a = new Account(accId, accUN, accPW);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return a;
	}

	@Override
	public int createAccount(Account a) {
		int accountCreated = 0;
		String sql = "insert into project0.account (un, pw) values (?, ?)";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, a.getUserName());
			ps.setString(2, a.getPassWord());
			
			accountCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return accountCreated;
	}

	@Override
	public List<Account> getAccount() {
		String sql = "select * from project0.account";
		
		List<Account> accounts = new ArrayList<>();
		
		try (Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			
			while(rs.next()) {
				int accId = rs.getInt("id");
				String accUN = rs.getString("un");
				String accPW = rs.getString("pw");
				Account d = new Account(accId, accUN, accPW);
				accounts.add(d);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return accounts;
	
	} 
}
