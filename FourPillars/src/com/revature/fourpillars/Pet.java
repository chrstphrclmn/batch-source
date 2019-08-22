package com.revature.fourpillars;

import com.revature.exception.NegativeLimbsException;

public abstract class Pet implements Communicable { //example of polymorphism, a Pet can be many different objects, 
													//so the shared behavior can be written a single time in the abstract pet class
	
	private String name;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + numOfLegs;
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
		Pet other = (Pet) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numOfLegs != other.numOfLegs)
			return false;
		return true;
	}

	private int numOfLegs; //example of abstraction; the values are hidden to the outside world as they only need be concerned by the object itself
	
	public Pet() {
		super();
	}
	
	public int getNumOfLegs() {    //encapsulation example: because the members are private, methods are required to extract the objects static values
		return numOfLegs;
	}
	
	public void setNumOfLegs(int numOfLegs) {  //encapsulation technique for controlling what data is allowed to be stored in the object.
		if(numOfLegs < 0) {
			throw new NegativeLimbsException("Cannot have "+numOfLegs+" legs on a pet, you sicko.");
		}else {
		
		
		this.numOfLegs = numOfLegs;
		}
	}
	public String getNameOfPet() {
		return this.name;
	}
	
	public void namePet(String name) {
		this.name=name;
	}

}
