package com.animal;

public class Snake extends Reptile{
	
	public Snake() {
		
		//setter methods inherited from the animal class
		
		setNumOfLegs(0);
		setLocation(10,11);
		setSpecies("Snake");
		
	}
	
	public void slither() {
		
		System.out.println("The snake slithers.");
		
		//move() method inherited from the Animal class
		
		move(2,3);
		
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
