package com.animal;

abstract public class Animal {
	/*The Animal class shows the use of the concepts of abstraction, encapsulation, inheritance, and polymorphism 
	 * either in itself or through its interaction with other classes. 
	 * It is an abstract class that abstracts away certain implementation details to allow a user to focus on the functionality of the specific animal classes.
	 * It is inherited by both the Mammal and Reptile classes, which in turn are inherited by the Snake, Turtle, Wolf and Dolphin classes.
	 * It has private variables that can only be accessed through getter and setter methods.
	 * It is used in the AnimalDriver class to create an array of Animal type objects that all of the animals can be stored in.
	 * It has its breathe() method overridden by the Dolphin class.
	 * It has its eat() method overloaded by the Wolf class.
	 * It is used to upcast to from the Snake class to instantiate a snake object to show that the Snake class is polymorphic.
	 */
	
	//private methods
	
	private int numOfLegs;
	private int xLocation;
	private int yLocation;
	private boolean isWarmBlooded;
	private String species;
	
	//used by the Wolf, Turtle, Snake and Dolphin class
	
	public void move(int x, int y) {
		
		this.xLocation += x;
		this.yLocation += y;
		
	}
	
	//overridden by the Dolphin class.
	
	public void breathe() {
		
		System.out.println("The "+ this.getSpecies().toLowerCase() + " breathes.");
		
	}
	
	//overloaded by the Wolf class.
	
	public void eat() {
		
		System.out.println("The "+ this.getSpecies().toLowerCase() + " eats.");
		
	}
	
	//used to set private variables
	
	public void setNumOfLegs(int numOfLegs) {
		
		this.numOfLegs = numOfLegs;
		
	}
	
	public void setLocation(int xLocation, int yLocation) {
		
		this.xLocation = xLocation;
		this.yLocation = yLocation;
		
	}
	
	public void setIsWarmBlooded(boolean isWarmBlooded) {
		
		this.isWarmBlooded = isWarmBlooded;
		
	}
	
	public void setSpecies(String species) {
		
		this.species = species;
		
	}
	
	//used to retrieve information from private variables
	
	public String getSpecies() {
		
		return this.species;
		
	}
	
	public int getNumOfLegs() {
		
		return this.numOfLegs;
		
	}
	
	public int[] getLocation() {
		
		int[] location = {this.xLocation, this.yLocation};
		
		return location;
		
	}
	
	//implementation of hashcode and equals

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isWarmBlooded ? 1231 : 1237);
		result = prime * result + numOfLegs;
		result = prime * result + xLocation;
		result = prime * result + yLocation;
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
		Animal other = (Animal) obj;
		if (isWarmBlooded != other.isWarmBlooded)
			return false;
		if (numOfLegs != other.numOfLegs)
			return false;
		if (xLocation != other.xLocation)
			return false;
		if (yLocation != other.yLocation)
			return false;
		return true;
	}
	
	
}


