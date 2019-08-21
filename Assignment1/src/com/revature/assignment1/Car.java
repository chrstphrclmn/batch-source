package com.revature.assignment1;

import java.util.Scanner;

public abstract class Car implements Drivable {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((licensePlate == null) ? 0 : licensePlate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (licensePlate == null) {
			if (other.licensePlate != null)
				return false;
		} else if (!licensePlate.equals(other.licensePlate))
			return false;
		return true;
	}

	private Scanner sc = new Scanner(System.in);
	
	private String licensePlate;
	
	public abstract void autoPilot();
	public void electricCar() {
		System.out.println("The car uses electric fuel.");
	}
	public void gasCar() {
		System.out.println("This car uses gasoline fuel.");
	}
	
	public void setMyLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	
	public String getMyLicensePlate() {
		return licensePlate;
	}
	
	public void wheelException() {
		System.out.println("Please enter number of wheels.");
		String userIn = sc.nextLine();
		int carWheel = Integer.parseInt(userIn);
			if(carWheel != 4) {
				throw new NumOfWheelsException("Not a Car!");
		} 
	}}
