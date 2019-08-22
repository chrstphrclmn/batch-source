package com.transportation_machines;

public class Car extends Locomotive implements Movable {

	String name;
	
	public void drive() {
		
	}
	public Car (String name) {
		hasWheels = true;
		this.name = name;
	}
	public void move() {
		
	}
}
