package com.revature.fourpillars;



public abstract class Food implements Edible{
	
	
	//Setting the number of food items to private encapsulates it.
	private int numOfFoodItems;
	
	/* 
	 * We can have multiple constructors through method overloading, a.k.a. polymorphism,
	 * so long as they have different number of arguments required.
	 */
	public Food() {
		this.setNumOfFoodItems(1);
	}
	
	public Food(int numOfFoodItems) {
		
		//Even though it's named the same, the variable with local scope is called.
		this.setNumOfFoodItems(numOfFoodItems);
	}
	
	
	
	
	//using a getter and setter allows us to work through the encapsulation, specifically in the child classes.
	public int getNumOfFoodItems() {
		return numOfFoodItems;
	}

	public void setNumOfFoodItems(int numOfFoodItems) {
		this.numOfFoodItems = numOfFoodItems;
	}

	
	//Declaring feedSomeone as required by our Edible Interface.
	public void feedSomeone() {
		
		System.out.println("The food is being eaten.");
		
	}
	
	
	/*
	 * Here I am declaring rotSomewhere abstract which means we don't care how it happens,
	 * just that it does in the child class, an example of abstraction.
	 */
	public abstract void rotSomewhere();

}
