package com.revature.models;

public class Receipts {

	private int receipt_id;
	private double amount;
	private String note;
	private int employee_id;
	private boolean approved;
	
	
	public Receipts() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Receipts(int receipt_id, double amount, String note, int employee_id, boolean approved) {
		super();
		this.receipt_id = receipt_id;
		this.amount = amount;
		this.note = note;
		this.employee_id = employee_id;
		this.approved = approved;
	}


	public int getReceipt_id() {
		return receipt_id;
	}


	public void setReceipt_id(int receipt_id) {
		this.receipt_id = receipt_id;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	public int getEmployee_id() {
		return employee_id;
	}


	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}


	public boolean isApproved() {
		return approved;
	}


	public void setApproved(boolean approved) {
		this.approved = approved;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (approved ? 1231 : 1237);
		result = prime * result + employee_id;
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result + receipt_id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Receipts other = (Receipts) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (approved != other.approved)
			return false;
		if (employee_id != other.employee_id)
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (receipt_id != other.receipt_id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Receipts [receipt_id=" + receipt_id + ", amount=" + amount + ", note=" + note + ", employee_id="
				+ employee_id + ", approved=" + approved + "]";
	}
	
	
	
	
	
}
