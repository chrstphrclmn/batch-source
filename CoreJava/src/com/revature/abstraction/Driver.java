package com.revature.abstraction;

public class Driver {

	public static void main(String [] args) {
		MyConcreteClass myConcreteClass = new MyConcreteClass();
		myConcreteClass.myABstractMethod();
		myConcreteClass.myConcreteMethod();
	}
}
