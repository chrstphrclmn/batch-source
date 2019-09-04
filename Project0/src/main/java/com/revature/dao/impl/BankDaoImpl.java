package com.revature.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.revature.dao.BankDao;
import com.revature.model.Bank;
import com.revature.util.ConnectionUtil;

public class BankDaoImpl implements BankDao {

	@Override
	public Bank getBankByAccId(int id) {
		String sql = "select * from project0.bank where account_id = ?";
		Bank b = null;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int bankId = rs.getInt("id");
				int accId = rs.getInt("account_id");
				double amount = rs.getDouble("amount");
				b = new Bank(bankId, accId, amount);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return b;
	}

	@Override
	public int createBank(Bank d) {
		int bankCreated = 0;
		String sql = "insert into project0.bank (account_id, amount) values (?, ?)";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setInt(1, d.getAccountId());
			ps.setDouble(2, d.getAmount());
			
			bankCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bankCreated;
	}

	@Override
	public void amountModify(Bank d, double amount) {
		String sql = "{call project0.amount_modify(?,?)}";
		
		try(Connection c = ConnectionUtil.getConnection();
			CallableStatement cs = c.prepareCall(sql)){
			cs.setInt(2, d.getiD());
			cs.setDouble(1, amount);
			
			cs.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
