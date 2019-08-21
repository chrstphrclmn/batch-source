package com.example.vehicles;

//inherits all of the methods of a vehicle (abstraction)
//must use the setter methods in vehicle (encapsulation)
public class Car extends Vehicle {

	public Car() {
		super();
		this.setType("Car");
		this.setNumOfWheels(4);
		this.setSpeed(80);
	}

	//implemented method from driveable
	@Override
	public void drive() {

		this.setCurrMileage((this.getSpeed() + this.getCurrMileage()));

	}

}
