package com.revature;

public class Calculator {

	/*
	 * We'll create a calculator that accepts a string input It can accept 0, 1, or
	 * 2 numbers separated by a comma
	 * 
	 * If we provide 0 numbers (empty string) we want our calculator to return 0 If
	 * we provide 1 we want it to return that number If we provide 2 we want it to
	 * return the sum of them If we provide an invalid or null input, we want it to
	 * return -1
	 * 
	 */

//	JUnit Paired Programming Exercise:
//		- allow for the calculator to take an unknown number of inputs
//		- allow for the calculator to support new line delimiters as well as commas
//		- calling add with a negative number will throw an exception
//		- numbers bigger than 1000 will be ignored

	public static int add(String... input) {
		if (input == null) {
			return -1;
		}
		if ("".equals(input[0])) {
			return 0;
		}
		Integer sum = 0;
		for (String string : input) {
			String[] sArray = string.split(",|[\r\n]");
			for (String z : sArray) {
				try {
					int number = Integer.parseInt(z);
					if (number < 1000 & number > 0) {
						sum += number;
					} else if (number < 0) {
						throw new IllegalArgumentException();
					}
				} catch (NumberFormatException nE) {
					nE.printStackTrace();
					return -1;
				}
			}
		}
		return sum;
	}
}
