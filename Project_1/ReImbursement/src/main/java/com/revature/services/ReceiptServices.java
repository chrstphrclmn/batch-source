package com.revature.services;

import com.revature.daos.ReceiptsDao;
import com.revature.daos.ReceiptDaoImpl;
import com.revature.models.Receipts;
import java.util.List;



public class ReceiptServices {
	
	
	private ReceiptsDao rd = new ReceiptDaoImpl();
	
	public List<Receipts> getAllReceipts(){
		return rd.getReceipts();
	}
	
	public Receipts getReceiptById(int id) {
		return rd.getReceiptById(id);
	}
	
	
	
}
