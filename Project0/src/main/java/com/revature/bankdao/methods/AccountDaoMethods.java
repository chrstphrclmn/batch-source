package com.revature.bankdao.methods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.bankdao.AccountDao;
import com.revature.dataaccess.ConnectionDB;
import com.revature.model.abstractObjects.Account;

public class AccountDaoMethods implements AccountDao {



	@Override
	public int createAccount(Account cuenta) {
		
		
		String sql = "select * from addaccount(?,?,?,?,"+
					cuenta.getTotalMoney()+")";
		
		try(Connection c = ConnectionDB.getConnection();
				PreparedStatement ps = c.prepareStatement(sql) ){
			
			ps.setInt(1, cuenta.getUserId());
			ps.setInt(2, cuenta.getType());
			ps.setString(3, cuenta.getUserName());
			ps.setInt(4, cuenta.getAccountNumber());
//			ps.setDouble(5, cuenta.getTotalMoney());
			
			ResultSet rs = ps.executeQuery();
			rs.next();
			cuenta.setAccountId(rs.getInt("cuentaid"));
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("hay");
			return 0;
			
		}
		System.out.println(cuenta.getAccountId());
		return 1;
		
	}

	@Override
	public Account getAccount(int cuentaId) {
		String sql = "select * from cuentas where cuentaId = ?";
		Account a = null;
		
		try(Connection c = ConnectionDB.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setInt(1, cuentaId); // jdbc 1 based index
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int accountId = rs.getInt("cuentaid");
				int userId= rs.getInt("userid");
				int type = rs.getInt("tipo");
				String userName= rs.getString("username");
				int accountNumber= rs.getInt("accountnumber");
				double totalMoney= rs.getDouble("totalMoney");
				
				
				a= new Account(accountId, userId, type,userName, 
						 accountNumber, totalMoney);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return a;
		
		
	}

	@Override
	public int linkAccount(int cuentaId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Integer> accountsLinked() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public int updateTotal(int cuentaId, double money) {
		double dinero=0;
		
		Account cuenta = getAccount(cuentaId);
		dinero = money + cuenta.getTotalMoney();
		
		if(dinero<0) {
			return 0;
		}
		
		String sql = "update cuentas set totalmoney ="+dinero+"where cuentas.cuentaid = ?";
		
		try(Connection c = ConnectionDB.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setInt(1, cuentaId); // jdbc 1 based index
			
			ResultSet rs = ps.executeQuery();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1; 
		
	}


	@Override
	public List<Account> getAccounts(int userId) {
		String sql = "select * from cuentas where userId="+userId;
		List<Account> accounts = new ArrayList<>();
		try (Connection c = ConnectionDB.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			
			while(rs.next()) {
				int accountId = rs.getInt("cuentaid");
				userId= rs.getInt("userid");
				int type = rs.getInt("tipo");
				String userName= rs.getString("username");
				int accountNumber= rs.getInt("accountnumber");
				double totalMoney= rs.getDouble("totalMoney");
				
				
				Account a= new Account(accountId, userId, type,userName, 
						 accountNumber, totalMoney);
				accounts.add(a);
				
			}
		
			return accounts;
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return null;
	}

	@Override
	public int deleteAccount(int cuentaId) {
		
		int rowsDeleted = 0;
		String sql = "delete from cuentas where cuentaId = ?";
		
		try(Connection c = ConnectionDB.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setInt(1, cuentaId);
			rowsDeleted = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowsDeleted;
		
		
	}

	
	
}
