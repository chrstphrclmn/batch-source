package com.revature.daos;

import java.sql.Connection;
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
				Double amount = rs.getDouble("amount");
				String note = rs.getString("receipt_note");
				Integer employee_id = rs.getInt("employee_id");
				boolean approved = rs.getBoolean("approved");
				
				Receipts rm = new Receipts(receipt_id, amount, note, employee_id, approved);
				
				receipts.add(rm);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Receipts getReceiptById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteReceiptById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateReceipt(Receipts r) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
