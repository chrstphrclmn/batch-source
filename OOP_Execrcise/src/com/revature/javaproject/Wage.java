package com.revature.javaproject;


//Inheritance wage class extend worker class
public class Wage extends Worker{
	//encapsulation Other objects do not have access to this class
	private Integer WorkHour;
	private Integer IncomePerHour;
	private Integer Id;
	
	public Wage() {
		super();
		setNumOfWorker(15);
	}
	// constructor overloading - overloading is considered compile time or static polymorphism
	public Wage(int id, int WorkHour, int IncomePerHour) {
		this();
		this.Id = id;
		this.WorkHour = WorkHour;
		this.IncomePerHour = IncomePerHour;
	}
	
	public int getWorkHour() {
		return WorkHour;
	}

	public void setWorkHour(int WorkHour) {
		this.WorkHour = WorkHour;
	}
	
	public int getIncomePerHour() {
		return IncomePerHour;
	}

	public void setgetIncomePerHour(Integer IncomePerHour) {
		this.IncomePerHour = IncomePerHour;
	}
	
	public Integer getId() {
		return Id;
	}

	public void setId(int id) {
		this.Id = id;
	}
	
	 
	
	@Override
	public int calculateWage() {
		return WorkHour*IncomePerHour;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null){
			return false;
		}
		if (obj == this){
			return true;
		}
		if (getClass() != obj.getClass()){
			return false;
		}
		Wage obj2 = (Wage) obj;
		if (this.WorkHour != obj2.WorkHour || this.IncomePerHour != obj2.IncomePerHour) {
			return false;
		}
		return true;
		}

	@Override
	public int hashCode() {
		return this.getId().hashCode();
	}
}

