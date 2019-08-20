package com.revature.types;

public class Autoboxing {
	
	public static void main(String args[]) {
		//Boxing
		int num1 = 7;
		Integer num2 = new Integer(num1);
		
		//Unboxing
		Integer num3 = new Integer(9);
		int num4 = num3.intValue();
		
		//Autoboxing
		int num5 = 6;
		Integer num6 = num5;
		
		//Autounboxing
		Integer num7 = 8;
		int num8 = num7;
		
		
		
		
	}

}
