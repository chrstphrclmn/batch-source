package com.animal;

public class Dolphin extends Mammal{
	
	private int numOfFins;
	
	public Dolphin() {
		
		numOfFins = 3;
		
		//setter methods from the Animal class
		
		setNumOfLegs(0);
		setLocation(10,1);
		setSpecies("Dolphin");
		
	}
	
	public void swim() {
		
		System.out.println("The dolphin swims.");
		
		//inherited from the Animal class
		
		move(5,4);
		
	}
	
	//overrides the breathe() method from the Animal class
	
	public void breathe() {
		
		System.out.println("The dolphin breathes through its blow hole.");
		
	}
	
	//implementation of hashcode and equals

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numOfFins;
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
		Dolphin other = (Dolphin) obj;
		if (numOfFins != other.numOfFins)
			return false;
		return true;
	}
	
	
}
