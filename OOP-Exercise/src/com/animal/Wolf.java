package com.animal;

public class Wolf extends Mammal implements Legged{
	
	public Wolf() {
		
		//setter methods inherited from the Animal class
			
		setNumOfLegs(4);
		setLocation(10,11);
		setSpecies("Wolf");
		
	}
	
	//overloaded eat() method that uses an Animal type object as a parameter
	
	public void eat(Animal prey) {
		System.out.println("The "+ prey.getSpecies().toLowerCase() + " was eaten by the wolf");
	}
	
	//overridden walk() method from the Legged interface
	
	@Override
	public void walk() {
		
		System.out.println("The wolf walks.");
		move(4,6);
		
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
