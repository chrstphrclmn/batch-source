package com.revature.model.abstractObjects;

public class UserTransaction {
	
	int transactionType; //1 withdraw, 2 Deposit, 3 Transfer
	double valor;
	
	public UserTransaction() {
		super();
		
	}

	public UserTransaction(int transactionType, double valor) {
		super();
		this.transactionType = transactionType;
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + transactionType;
		long temp;
		temp = Double.doubleToLongBits(valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		UserTransaction other = (UserTransaction) obj;
		if (transactionType != other.transactionType)
			return false;
		if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserTransactions [transactionType=" + transactionType + ", valor=" + valor + "]";
	}
	

}
