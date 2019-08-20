package com.revature.fourpillars;


//The Apple Class "Inherits" from the food class.
public class Apple extends Food {
	
	
	
	public void fallDown() {
		
		
		Integer bumps = this.getNumOfFoodItems();
		System.out.println(bumps.toString()+" apples fall off the tree.");
	}

	@Override
	public void rotSomewhere() {
		System.out.println("The apple(s) rot on the ground.");
		
	}

}
