package com.animal;

public class Mammal extends Animal {
	
	public Mammal() {
		
		//uses a setter method inherited from the Animal class
		
		setIsWarmBlooded(true);
		
	}
	
	//implementation of hashcode and equals

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
	
	
	
}
