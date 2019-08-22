package com.revature.fourpillars;

public class Pig extends Pet {

	
	public Pig() {
		super();
		super.setNumOfLegs(4);
	}
	
	public Pig(String name) {
		this();
		super.namePet(name);
	}
	
	public Pig(String name, int limbs) {
		super();
		super.namePet(name);
		super.setNumOfLegs(limbs);
	}
	
	@Override
	public void speak() {
		System.out.println("Oink! Oink!");
		
	}

	@Override
	public void doTrick() {
		System.out.println("Pigs dont do tricks silly...");
		
	}
	
	

}
