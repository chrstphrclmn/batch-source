package com.revature.fourpillars;

public class Fish extends Pet {  //another example of inheritance 
	
	public Fish() {
		super();
		super.setNumOfLegs(0);
	}
	
	public Fish(String name) {
		this();
		super.namePet(name);
	}

	@Override
	public void speak() {  //example of polymorphism, all pets can perform these functions, though some may perform them differently.
		System.out.println("Blub... blub...");
		
	}

	@Override
	public void doTrick() {
		System.out.println( this.getNameOfPet() + " rolls over...");
		System.out.println(this.getNameOfPet() + " is dead!");
		
	}


	
	
}
