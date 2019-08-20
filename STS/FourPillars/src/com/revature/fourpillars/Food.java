package com.revature.fourpillars;



public abstract class Food implements Edible{
	
	
	public void feedSomeone() {
		
		System.out.println("The food is being eaten.");
		
	}
	
	public void rot() {
		
		System.out.println("The food is rotting.");
		
	}

}
