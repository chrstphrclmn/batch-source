package com.revature.bankingapp.sysoutgui.model;

public class TransactionHistory {

	private Long id;
	private String history;
	private Long subaccount_id;

	public TransactionHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransactionHistory(Long id, String history, Long subaccount_id) {
		super();
		this.id = id;
		this.history = history;
		this.subaccount_id = subaccount_id;
	}

	public TransactionHistory(String history, Long subaccount_id) {
		super();
		this.history = history;
		this.subaccount_id = subaccount_id;
	}

	@Override
	public String toString() {
		return "TransactionHistory [id=" + id + ", history=" + history + ", subaccount_id=" + subaccount_id + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public Long getSubaccount_id() {
		return subaccount_id;
	}

	public void setSubaccount_id(Long subaccount_id) {
		this.subaccount_id = subaccount_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		TransactionHistory other = (TransactionHistory) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
