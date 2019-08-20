package com.revature.fourpillars;


//Beef inherits from food.
public class Beef extends Food {
	
	//We are overriding the parent version of this method, part of Polymorphism.
	public void feedSomeone() {
		System.out.println("The food is being eaten....with BBQ sauce");
	}

	@Override
	public void rotSomewhere() {
		System.out.println("The beef rots.");
		
	}

}
