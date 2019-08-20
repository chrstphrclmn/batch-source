package com.revature.types;

public class DefaultDriver {
	
	//static and instance scoped variables will be assigned default values
	
	static boolean bool;
	static char ch;
	static double d;
	static int i;
	static String str;
	static boolean[] arr = new boolean[4];

	public static void main(String[] args) {
			
		System.out.println(bool);
		System.out.println(ch);
		System.out.println(d);
		System.out.println(i);
		System.out.println(str);
		System.out.println(arr);
		
		
	}

}
