package com.revature.daos;

import java.util.List;

import com.revature.models.Receipts;

public interface ReceiptsDao {
	
	public int createReceipt(Receipts r);
	public List<Receipts> getReceipts();
	public Receipts getReceiptById(int id);
	public int deleteReceiptById(int id);
	public int approveReceipt(int id);
	public List<Receipts> getReceiptsByEmployeeId(int id);
	public List<Receipts> getApprovedReceipts(int id);
}
