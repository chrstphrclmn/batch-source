package com.revature.project.zero.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.project.zero.ConnectionUtil;
import com.revature.project.zero.dao.TransactionDAO;
import com.revature.project.zero.model.Transaction;

public class TransactionDAOImpl implements TransactionDAO{

	@Override
	public List<Transaction> getTransactions() {


		String sql = "select * from transaction";
		
		List<Transaction> transactions = new ArrayList<>();
		
		try (Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			
			while(rs.next()) {
				int transactionID = rs.getInt("transactionid");
				int accountNum = rs.getInt("accountnum");
				String username = rs.getString("username");
				double transfer = rs.getDouble("transfer");
				Transaction a = new Transaction(transactionID, accountNum, username, transfer);
				transactions.add(a);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return transactions;
		
	}

	@Override
	public Transaction getTransactionByKey(int transactionID) {


		String sql = "select * from transaction where transactionid = ?";
		Transaction a = null;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setInt(1, transactionID); // jdbc 1 based index
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int newTransactionID = rs.getInt("transactionid");
				int accountNum = rs.getInt("accountnum");
				String username = rs.getString("username");
				double transfer = rs.getDouble("transfer");
				a = new Transaction(newTransactionID, accountNum, username, transfer);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return a;
		
	}

	@Override
	public int createTransaction(Transaction transaction) {


		int transactionsCreated = 0;
		String sql = "insert into transaction (transactionid, accountnum, username, transfer) "
				+ "values (?, ?, ?, ?)";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setInt(1, transaction.getTransactionID());
			ps.setInt(2, transaction.getAccountNum());
			ps.setString(3, transaction.getUsername());
			ps.setDouble(4, transaction.getTransfer());
			
			transactionsCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return transactionsCreated;
		
	}



}
