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
		/*
		 * if (values.length == 1) { if (values[0].matches("^\\d+$")) { return
		 * Integer.parseInt(values[0]); } else return -1; } else { if (values.length ==
		 * 2) { if (values[0].matches("^\\d+$") && values[1].matches("^\\d+$")) { return
		 * Integer.parseInt(values[0]) + Integer.parseInt(values[1]); } else return -1;
		 * } else return -1; }
		 */
	}

}
