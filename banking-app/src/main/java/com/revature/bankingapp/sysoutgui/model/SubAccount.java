package com.revature.bankingapp.sysoutgui.model;

public class SubAccount {

	private Long id;
	private String type;
	private Long accountId;
	private Double amount;

	public SubAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SubAccount(Long id, String type, Double amount, Long accountId) {
		super();
		this.id = id;
		this.type = type;
		this.accountId = accountId;
		this.amount = amount;
	}

	public SubAccount(String type, Double amount, Long accountId ) {
		super();
		this.type = type;
		this.accountId = accountId;
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
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
		SubAccount other = (SubAccount) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
