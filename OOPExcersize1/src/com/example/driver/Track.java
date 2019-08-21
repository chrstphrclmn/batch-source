package com.example.driver;


import java.util.concurrent.TimeUnit;

import com.example.exceptions.NotDistinctException;
import com.example.vehicles.Car;
import com.example.vehicles.Motercycle;
import com.example.vehicles.SportsCar;
import com.example.vehicles.Vehicle;

public class Track {

	// creates an instance of each type of vehicle and sends them to the track
	public static void main(String[] args) {
		// examples of polymorphism
		Vehicle a = new Car();
		Vehicle b = new Motercycle();
		Vehicle c = new SportsCar();
		Vehicle[] vehics = { a, b, c};
		Go(vehics);
	}

	public static boolean isDistinct(Vehicle[] v) {
		// uses .equals function in vehicles to check memory space to make sure that
		// they are all different
		for (int i = 0; i < v.length; i++) {
			for (int j = i + 1; j < v.length; j++) {
				if (v[i] != null && v[i].equals(v[j])) {
					return true;
				}
			}
		}
		return false;
	}

	// a simulation of vehicles driving on the track
	public static void Go(Vehicle[] vehics) {
		// checks and makes sure that all vehicles are different.
		if (isDistinct(vehics)) {
			throw new NotDistinctException("All vehicles must be distinct");
		}
		System.out.println("Todays racers are: ");
		String announce = "";
		// sets the track length
		for (Vehicle x : vehics) {
			announce += x.getType() + " stored at location: " + x.hashCode() + "\n";
			x.setMaxMileage(20000);
		}
		System.out.println(announce);
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// keeps track of how many 'minutes' it takes for the vehicle to reach the end
		// of the track
		int counts[] = new int[vehics.length];
		int count;

		for (int i = 0; i < vehics.length; i++) {
			count = 0;
			boolean done = false;
			// makes sure the vehicle keeps driving until it at least hits the end of the
			// track

			while (!done) {
				if (vehics[i].isDrivable()) {
					System.out.println("Driving...");
					vehics[i].drive();

					// checks if the vehicle has reached the end
					if (vehics[i].getCurrMileage() >= vehics[i].getMaxMileage()) {
						vehics[i].setDrivable(false);
					}
					count++;
				} else {
					// quits out of the loop and either starts the next vehicle or completes the
					// program
					done = true;
					counts[i] = count;
				}
			}
		}
		// prints out the results
		System.out.println("\nCompleted driving, results:");
		String results = "";
		for (int i = 0; i < vehics.length; i++) {
			results += vehics[i].toString() + "in " + counts[i] + " minutes.\n";
		}
		System.out.println(results);

	}
}
