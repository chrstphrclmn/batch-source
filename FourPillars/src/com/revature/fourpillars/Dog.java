package com.revature.fourpillars;

public class Dog extends Pet {  //example of Inheritence 
								//dog, fish, and pig are all also pets so they share methods that a pet would have
	
	public Dog() {
		super();
		super.setNumOfLegs(4);
	}
	
	public Dog(String name) {
		this();
		super.namePet(name);
	}
	
	public Dog(String name, int numOfLegs) {
		super();
		super.namePet(name);
		super.setNumOfLegs(numOfLegs);
		
	}
	
	
	@Override
	public void speak() {
		System.out.println("Woof!");
		
	}

	@Override
	public void doTrick() {
		
		
		int numLegs = super.getNumOfLegs();
		
		if(numLegs < 4) {
			System.out.println(this.getNameOfPet() +" only has "+ numLegs + " legs!");
			System.out.println("Do you also steal candy from children??");
		} else {
		
		
		System.out.println(this.getNameOfPet() + " waits patiently for something...");
		System.out.println("Perhaps " + this.getNameOfPet() + " wants a treat!");
		}
	}
	
	public void doTrick(String treat) {
		
		int numLegs = super.getNumOfLegs();
		
		if(numLegs < 4) {
			System.out.println(this.getNameOfPet() + " only has "+ numLegs + " legs!");
			System.out.println("Do you also steal candy from children??");
		} else {
		
		System.out.println(this.getNameOfPet() + " snatches " + treat + " right out of your hand!");
		System.out.println("Delicious!");
		System.out.println(this.getNameOfPet() + " does a tight circle and curls up into a ball.");
		System.out.println("It must be naptime!");
		}
	}
		
}
