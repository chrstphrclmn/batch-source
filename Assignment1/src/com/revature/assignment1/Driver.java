package com.revature.assignment1;

public class Driver {
	public static void main(String[] args) {
		Audi myAudi = new Audi();   //Audi Object
		myAudi.wheelException();	//Checks if object is 4 wheeled car.
		myAudi.startEngine();	    //From Interface
		myAudi.drive();			    //From Interface
		myAudi.stopEngine();	    //From Interface
		myAudi.autoPilot();		    //Abstract Method from Abstract Car Class
		myAudi.gasCar();		    //Concrete Method from Abstract Car Class
		myAudi.setMyLicensePlate("TGH-456"); //Uses encapsulation to set plate number from abstract class
		System.out.println("The license plate is " + myAudi.getMyLicensePlate() + "."); //Uses encapsulation to get plate number from abstract class
		System.out.println("---------------------------------------");
		System.out.println("");
		
		Honda myHonda = new Honda(); //Honda Object
		myHonda.wheelException();	//Checks if object is 4 wheeled car.
		myHonda.startEngine();	     //From Interface
		myHonda.drive();			 //From Interface
		myHonda.stopEngine();		 //From Interface
		myHonda.autoPilot();         //Abstract Method from Abstract Car Class
		myHonda.gasCar();            //Concrete Method from Abstract Car Class
		myHonda.setMyLicensePlate("VVM-954"); //Uses encapsulation to set plate number from abstract class
		System.out.println("The license plate is " + myHonda.getMyLicensePlate() + "."); //Uses encapsulation to get plate number from abstract class
		System.out.println("---------------------------------------");
		System.out.println("");
		
		Tesla myTesla = new Tesla(); //Tesla Object
		myTesla.wheelException();	//Checks if object is 4 wheeled car.
		myTesla.startEngine();	     //From Interface
		myTesla.drive();			 //From Interface
		myTesla.stopEngine();		 //From Interface
		myTesla.autoPilot();         //Abstract Method from Abstract Car Class
		myTesla.electricCar();       //Concrete Method from Abstract Car Class
		myTesla.setMyLicensePlate("TES-886");	//Uses encapsulation to set plate number from abstract class
		System.out.println("The license plate is " + myTesla.getMyLicensePlate() + "."); //Uses encapsulation to get plate number from abstract class
		System.out.println("---------------------------------------");
		System.out.println("");
	}
}
