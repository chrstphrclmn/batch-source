package com.revature;

public class Calculator {
	
	/*
	 * We'll create a calculator that accepts a string input 
	 * It can accept 0, 1, or 2 numbers separated by a comma
	 * 
	 * If we provide 0 numbers (empty string) we want our
	 *    calculator to return 0
	 * If we provide 1 we want it to return that number
	 * If we provide 2 we want it to return the sum of them
	 * If we provide an invalid or null input, we want it to
	 *    return -1
	 * 
	 */
	
	public static int add(String input) {
		
		if(input == null) {
			
			return -1;
		}
		
		if(input == "") {
			
			return 0;
		}
		
		String[] values = input.replaceAll("[^-a-z0-9]", " ").trim().replaceAll(" +", " ").split(" ");
		
		int ret = 0;
		int temp = 0;
		
		for (String s : values) {
			
			try {
				
				temp = Integer.parseInt(s.trim());
				if(temp < 1000) {
					
					ret += temp;
				}
			}
			catch (IllegalArgumentException e) {
				
				return -1;
			}
			
			if (temp < 0) {
				
				throw new IllegalArgumentException();
			}

		}

		
		return ret;
	}

}
