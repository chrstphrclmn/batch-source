package com.animal;

import com.exception.TooSadException;

public class AnimalDriver {
	
	public static void main(String[] args) throws TooSadException {
		
		Wolf wolf = new Wolf();
		Dolphin dolphin = new Dolphin();
		
		//Snake object instantiated using the Animal type to demonstrate polymorphism
		//upcast
		Animal snake = new Snake();
		//downcast
		Snake snake1 = (Snake) snake;
		
		Turtle turtle = new Turtle();
		
		//all instantiated objects above can be considered Animals and therefore can be stored in an array of Animal type objects
		
		Animal[] animals = {wolf, dolphin, turtle, snake1};
		
		for (int i = 0; i < animals.length; i++) {
			
			animals[i].breathe();
			animals[i].eat();
			System.out.println("The " + animals[i].getSpecies().toLowerCase() + "'s x position is: " + animals[i].getLocation()[0]+ "\n" + "Its y position is: "+ animals[i].getLocation()[1]+ ".");
			
		}
		
		// calls individual move()methods
		
		wolf.walk();
		turtle.walk();
		snake1.slither();
		dolphin.swim();
		
		for (int i = 0; i < animals.length; i++) {
			System.out.println("The " + animals[i].getSpecies().toLowerCase() + "'s x position is: " + animals[i].getLocation()[0]+ "\n" + "Its y position is: "+ animals[i].getLocation()[1]+ ".");
		}
		
		
		//overloaded eat() method used
		wolf.eat(turtle);
		
		//provides situation where custom exception would be thrown
		wolf.setNumOfLegs(3);
		
		//determines if exception should be thrown
		
		if (wolf.getNumOfLegs() < 4) {
					
				// throws exception
				throw new TooSadException();
			}
	}

}
