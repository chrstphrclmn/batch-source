package com.revature.assignment1;

import java.util.Scanner;

public abstract class Car implements Drivable {
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
			if(userIn != "4") {
				throw new NumOfWheelsException("Not a Car!");
		} 
	}}
