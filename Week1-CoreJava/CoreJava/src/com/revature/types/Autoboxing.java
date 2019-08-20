package com.revature.types;

public class Autoboxing {

	public static void main(String[] args) {
		
		// boxing - we explicitly "box" the primitive
		int num1 = 7; // primitive
		Integer num2 = new Integer(num1); //convert this value to an object
		
		// unboxing - we explicitly convert Integer to a primitive int value
		Integer num3 = new Integer(9);
		int num4 = num3.intValue();
		
		// autoboxing - the primitive value is implicitly converted to an object
		int num5 = 6;
		Integer num6 = num5;
		
		// autounboxing - the object value is implicitly convered to a primitive
		Integer num7 = new Integer(76);
		int num8 = num7;
		

	}

}
