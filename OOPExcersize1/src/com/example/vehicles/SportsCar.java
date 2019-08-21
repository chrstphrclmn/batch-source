package com.example.vehicles;

//inherits all of the methods of a vehicle (abstraction)
//must use the setter methods in vehicle (encapsulation)
public class SportsCar extends Vehicle {

	public SportsCar() {
		super();
		this.setType("SportsCar");
		this.setNumOfWheels(4);
		this.setSpeed(100);
	}
	
	//implemented method from driveable
	@Override
	public void drive() {
		this.setCurrMileage((this.getSpeed() + this.getCurrMileage()));

	}

}
