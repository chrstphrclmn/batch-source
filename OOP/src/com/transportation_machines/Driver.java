package com.transportation_machines;

public class Driver {
	public static void main(String[] args) {
		System.out.println("Vroom");
		Car car = new Car("Mercedes");
		System.out.println(car.name);
		Car car1 = new Car("Ford");
		System.out.println(car1.name);
		Plane plane = new Plane();
		
	}

}
