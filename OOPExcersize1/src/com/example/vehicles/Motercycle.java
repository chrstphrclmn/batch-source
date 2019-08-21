package com.example.vehicles;

public class Motercycle extends Vehicle {

	//inherits all of the methods of a vehicle (abstraction)
	//must use the setter methods in vehicle (encapsulation)
	public Motercycle() {
		super();
		this.setType("Motercycle");
		this.setNumOfWheels(2);
		this.setSpeed(70);
	}

	//implemented method from driveable
	@Override
	public void drive() {
		if (this.isDrivable()) {
			this.setCurrMileage((this.getSpeed() + this.getCurrMileage()));
		}

	}

}
