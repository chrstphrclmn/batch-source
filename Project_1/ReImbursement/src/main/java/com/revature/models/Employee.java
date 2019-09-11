package com.revature.models;

public class Employee {
	
	
	private int employee_id;
	private String first_name;
	private String last_name;
	private int reports_to;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Employee(int employee_id, String first_name, String last_name, int reports_to) {
		super();
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.reports_to = reports_to;
	}


	public int getEmployee_id() {
		return employee_id;
	}


	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public int getReports_to() {
		return reports_to;
	}


	public void setReports_to(int reports_to) {
		this.reports_to = reports_to;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employee_id;
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + reports_to;
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
		Employee other = (Employee) obj;
		if (employee_id != other.employee_id)
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (reports_to != other.reports_to)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", reports_to=" + reports_to + "]";
	}
	
	
	
	
}
