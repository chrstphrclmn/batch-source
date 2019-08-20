package com.revature.fourpillars;

import java.util.Scanner;

public class FoodDriver {
	
	

	private static Scanner scan;

	public static void main(String[] args) throws FamineException {
		
		scan = new Scanner(System.in);
		System.out.println("How much broccoli do you want?");
		
		String numOfFoodItems = scan.nextLine();
		int num = Integer.parseInt(numOfFoodItems);
		
		if (num<=0) {
			throw new FamineException("You're starving!");
		}
		else {
			//This is an example of covariance.  Since broccoli has no methods of it's own, we can actually use a food variable.
			Food brocc = new Broccoli();
			brocc.feedSomeone();
			brocc.rotSomewhere();
		}
		
		Apple lots = new Apple(5);
		lots.fallDown();
		lots.feedSomeone();
		lots.rotSomewhere();
		
		Beef cow = new Beef();
		cow.feedSomeone();
		cow.rotSomewhere();
		

		
		
	}

}
