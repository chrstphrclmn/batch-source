package com.revature.javaproject;

public class Driver {
	public static void main(String[] args) {
		Wage w = new Wage(2, 8, 10);
		Wage w2 = new Wage(2, 8, 10);
		Wage w3 = new Wage(2,5,10);
		Wage w4 = new Wage(5,5,10);
		// abstraction hiding the implementation details. §°nly the functionality is provided
		System.out.println(w.calculateWage());
		System.out.println(w.hashCode() == w2.hashCode());
		System.out.println(w.equals(w2));
		System.out.println(w3.hashCode() == w2.hashCode());
		System.out.println(w3.equals(w2));
		System.out.println(w3.hashCode() == w4.hashCode());
		System.out.println(w3.equals(w4));
		Worker a = new Wage();
		a.setNumOfWorker(-3);
	}
}
