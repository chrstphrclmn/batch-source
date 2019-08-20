package com.revature.types;

import java.util.Arrays;

public class ArrayDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] intArr1 = new int[5];
		int intArr2[] = new int[5];
		int[] intArr3 = {4,6,2,6,1};
		
		for(int i=0; i<intArr3.length; i++) {
			System.out.print(intArr3[i]);
		}
		System.out.println();
		for(int currentInt : intArr3) {
			System.out.print(currentInt);
		}
		
		int[][] int2DArr = new int[3][3];
		
		printAll("hello", "world", "cats", "dogs");

	}
	
	public static void printAll(String... strArr) {
		
		System.out.println(Arrays.toString(strArr));
	}

}
