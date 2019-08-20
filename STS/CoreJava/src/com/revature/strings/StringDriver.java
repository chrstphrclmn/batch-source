package com.revature.strings;

public class StringDriver {

	public static void main(String[] args) {

		//Both variables point at the same memory spot in the string pool.
		String string1 = "I'm a string!";
		String string2 = "I'm a string!";
		
		System.out.println(string1.equals(string2));
		System.out.println(string1 == string2);
		
		String alsoString1 = string1;
		string1 = string1 + "!";
		
		System.out.println(string1);
		System.out.println(alsoString1);
		
		System.out.println(string1.contentEquals(alsoString1));
		System.out.println(string1 == alsoString1);
		
		
		StringBuilder sb1 = new StringBuilder("I'm a stringbuilder object.");
		StringBuilder sb2 = new StringBuilder("I'm a stringbuilder object.");
		
		System.out.println(sb1 == sb2);
		System.out.println(sb1.toString().equals(sb2.toString()));
		
	}

}
