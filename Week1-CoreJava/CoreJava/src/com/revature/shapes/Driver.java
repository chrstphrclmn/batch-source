package com.revature.shapes;

public class Driver {

	public static void main(String[] args) {
		Rectangle r = new Rectangle(3,6);
		System.out.println(r.toString());
		
		Rectangle s = new Square(5);
		System.out.println(s.toString());
		s.draw();
		s.setNumOfSides(-5); 
	}

}
