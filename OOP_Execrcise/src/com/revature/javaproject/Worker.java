package com.revature.javaproject;

import com.revature.javaproject.NegativeValueException;

public abstract class Worker implements Calculate{
	private Integer NumOfWorker;
	
	public Worker() {
		super();
	}
	
	public Integer getNumOfWorker() {
		return NumOfWorker;
	}
	//NegativeValueException
	public void setNumOfWorker(int NumOfWorker) {
		if(NumOfWorker<0) {
			throw new NegativeValueException("cannot set num of worker to "+NumOfWorker);
		} else {
			this.NumOfWorker = NumOfWorker;
			
		}
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
		Worker obj2 = (Worker) obj;
		return (this.NumOfWorker == obj2.NumOfWorker);
	}
	
	@Override
	public int hashCode() {
		return this.getNumOfWorker().hashCode();
	}
}
