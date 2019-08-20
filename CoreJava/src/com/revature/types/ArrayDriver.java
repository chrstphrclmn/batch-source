package com.revature.types;

public class ArrayDriver {

	public static void main(String[] args) {
		int [] intArr1 = new int[5];
		int intArr2[] = new int[5];
		int [] intArr3 = {4,3,2,1};
		
		for(int i = 0; i < intArr3.length; i++) {
			System.out.println(intArr3[i] + " ");
		}
		
		for(int currentInt: intArr3) {
			System.out.println(currentInt + " ");
		}
		
		int[][] int2DArr = new int[3][3];
	}
	
	public static void printAll(String... strings) {
		
	}

}
