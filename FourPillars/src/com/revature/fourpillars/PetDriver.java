package com.revature.fourpillars;

public class PetDriver {

	public static void main(String[] args) {
		Fish nemo = new Fish("nemo");
		nemo.speak();
		nemo.doTrick();
		System.out.println("------------------");
		System.out.println();
		
		Dog spot = new Dog("spot");
		Dog lucky = new Dog("lucky",2);
		
		spot.speak();
		spot.doTrick();
		System.out.println("------------------");
		System.out.println();
		lucky.speak();
		lucky.doTrick();
		System.out.println("------------------");
		System.out.println();
		spot.doTrick("scooby snacks");
		
		
		System.out.println("-------------------");
		System.out.println();
		Pig crispy = new Pig("crispy",4);
		crispy.doTrick();
		crispy.speak();

	}

}
