package com.revature;

public class Calculator {

	public static int add(String input) throws NegativeNumberException {
		if (input == null) {
			return -1;
		}
		if ("".equals(input)) {
			return 0;
		}
		int sum = 0;
		String[] values = input.trim().split("[,\n]");
		for (String s : values) {
			s = s.trim();
			if (!s.matches("^\\d+$")) {
				if (s.charAt(0) == '-')
					throw new NegativeNumberException("Number can not be negative");

				return -1;
			}
			if(Integer.parseInt(s) > 1000) 
				continue;
			sum += Integer.parseInt(s);
		}
		return sum;
		
	}

}
