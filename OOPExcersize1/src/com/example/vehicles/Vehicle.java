package com.example.vehicles;

import com.example.exceptions.IncorrectWheelsException;
import com.example.exceptions.NegativeMilesException;
import com.example.interfaces.Driveable;

//All vehicles should be driveable
public abstract class Vehicle implements Driveable {

	// Every vehicle will have a number of wheels, a make, and a model.

	private int numOfWheels;
	private String type;
	private int currMileage;
	private int maxMileage;
	private boolean isDrivable;
	private int speed;

	// Every time you create a vehicle it will start as driveable with 0 current
	// miles
	public Vehicle() {
		isDrivable = true;
		currMileage = 0;
	}

	public Vehicle(String type) {
		this();
		this.type = type;
	}

	// getters and setters for all values

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}


	public int getNumOfWheels() {
		return numOfWheels;
	}

	// checks and makes sure that the number of wheels is either 2 or 4
	public void setNumOfWheels(int numOfWheels) {
		if (numOfWheels < 2 || numOfWheels > 4 || numOfWheels == 3) {
			throw new IncorrectWheelsException("A vehicle can only have 2 or 4 wheels, not " + numOfWheels);
		} else {
			this.numOfWheels = numOfWheels;
		}
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCurrMileage() {
		return currMileage;
	}

	// makes sure that the current mileage is not negative
	public void setCurrMileage(int currMileage) {
		if (currMileage < 0) {
			throw new NegativeMilesException("Miles can not be negative");
		} else {
			this.currMileage = currMileage;
		}
	}

	public int getMaxMileage() {
		return maxMileage;
	}

	// makes sure that the max mileage is not negative
	public void setMaxMileage(int maxMileage) {
		if (maxMileage < 0) {
			throw new NegativeMilesException("Miles can not be negative");
		} else {
			this.maxMileage = maxMileage;
		}
	}

	public boolean isDrivable() {
		return isDrivable;
	}

	public void setDrivable(boolean isDrivable) {
		this.isDrivable = isDrivable;
	}

	//toString method for driving aspect
	@Override
	public String toString() {
		return "Vehicle type= " + type + ", travelled= " + currMileage + " miles ";
	}
}
