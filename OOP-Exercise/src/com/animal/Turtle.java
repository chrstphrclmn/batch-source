package com.animal;

public class Turtle extends Reptile implements Legged {

	public Turtle() {
		
		// setter methods inherited from the Animal class
		
		setNumOfLegs(4);
		setLocation(5,11);
		setSpecies("Turtle");
	}
	
	//overrides the walk method implemented from the Legged interface
	
	@Override
	public void walk() {
		
		System.out.println("The turtle walks.");
		move(1,1);
		
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
