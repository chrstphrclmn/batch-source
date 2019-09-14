package Revature.Project1.Model;

public class Reimbursement {
	
	private int reimbId;
	private String empName;
	private double amount;
	private String description;
	private int userId;
	private String managedBy;
	
	public Reimbursement() {
		super();
	}
	
	public Reimbursement(String name, double amount, String description, int userId) {
		this.empName = name;
		this.amount = amount;
		this.description = description;
		this.userId = userId;
	}
	
	public Reimbursement(int reimbId, String name, double amount, String description, int userId) {
		this.reimbId = reimbId;
		this.empName = name;
		this.amount = amount;
		this.description = description;
		this.userId = userId;
	}
	
	public Reimbursement(int reimbId, String name, double amount, String description, int userId, String managedBy) {
		this.reimbId = reimbId;
		this.empName = name;
		this.amount = amount;
		this.description = description;
		this.userId = userId;
		this.managedBy = managedBy;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Reimbursement(double amount, String description, int userId) {
		this.amount = amount;
		this.description = description;
		this.userId = userId;
	}
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		result = prime * result + ((managedBy == null) ? 0 : managedBy.hashCode());
		result = prime * result + reimbId;
		result = prime * result + userId;
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
		Reimbursement other = (Reimbursement) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		if (managedBy == null) {
			if (other.managedBy != null)
				return false;
		} else if (!managedBy.equals(other.managedBy))
			return false;
		if (reimbId != other.reimbId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbId=" + reimbId + ", empName=" + empName + ", amount=" + amount + ", description="
				+ description + ", userId=" + userId + ", managedBy=" + managedBy + "]";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getReimbId() {
		return reimbId;
	}

	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}

	public String getManagedBy() {
		return managedBy;
	}

	public void setManagedBy(String managedBy) {
		this.managedBy = managedBy;
	}
	
	
	
}
