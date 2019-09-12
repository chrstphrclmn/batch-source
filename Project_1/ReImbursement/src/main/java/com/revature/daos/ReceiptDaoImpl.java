package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Receipts;
import com.revature.util.ConnectionUtil;

public class ReceiptDaoImpl implements ReceiptsDao {

	@Override
	public int createReceipt(Receipts r) {
		// TODO Auto-generated method stub
		
		
		return 0;
	}

	@Override
	public List<Receipts> getReceipts() {
		// TODO Auto-generated method stub
		
		String sql = "Select * from receipts";
		
		List<Receipts> receipts = new ArrayList<Receipts>();
		
		try(Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			
			while(rs.next()) {
				Integer receipt_id = rs.getInt("receipt_id");
				Double amount = rs.getDouble("receipt_amount");
				String note = rs.getString("receipt_note");
				Integer employee_id = rs.getInt("employee_id");
				boolean approved = rs.getBoolean("approved");
				
				Receipts rm = new Receipts(receipt_id, amount, note, employee_id, approved);
				
				receipts.add(rm);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return receipts;
	}

	@Override
	public Receipts getReceiptById(int id) {
		// TODO Auto-generated method stub
		
		
		Receipts rc = null;
		
		String sql = "Select * from receipts where receipt_id = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
//			loop through result
			
			while(rs.next()) {
				Integer receipt_id = rs.getInt("receipt_id");
				Double amount = rs.getDouble("receipt_amount");
				String note = rs.getString("receipt_note");
				Integer employee_id = rs.getInt("employee_id");
				boolean approved = rs.getBoolean("approved");
				
				rc = new Receipts(receipt_id, amount, note, employee_id, approved);
			}
			
			rs.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return rc;
	}

	@Override
	public int deleteReceiptById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int approveReceipt(int id) {
		// TODO Auto-generated method stub
		
		String sql = "Update receipts set approved = true where receipt_id = ?";
		
		
		return 0;
	}
	
	@Override
	public List<Receipts> getReceiptsByEmployeeId(int id){
		
		String sql = "Select * from receipts where employee_id = ?";
		
		List<Receipts> receipts = new ArrayList<Receipts>();
		
		try(Connection c = ConnectionUtil.getConnection(); 
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Integer receipt_id = rs.getInt("receipt_id");
				Double amount = rs.getDouble("receipt_amount");
				String note = rs.getString("receipt_note");
				Integer employee_id = rs.getInt("employee_id");
				boolean approved = rs.getBoolean("approved");
				
				Receipts rc = new Receipts(receipt_id, amount, note, employee_id, approved);
				
				receipts.add(rc);
			}
			
			rs.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return receipts;
	}
	
	
}
