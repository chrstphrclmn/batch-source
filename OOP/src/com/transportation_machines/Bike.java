package com.transportation_machines;

public class Bike extends Locomotive implements Movable {

	int x = 10; 
	//boolean haswheels;
	String name = "BMX";
	
	public Bike() {
		hasWheels = true;
	}
	public Bike (String name) {
		this.name = name;
	}
	
	public void move() {
		
	}
}
