package com.revature.generics;

import java.util.ArrayList;
import java.util.Collection;

public class Driver {

	
	public static void main(String[] args) {
		
		ArrayList<String> arrList = new ArrayList<>();
		Integer[] intArr = {1, 2, 3, 4, 5};
		
		arrList.add("Test");
		
		print(intArr);
		print(arrList);
	}
	
	public static <T> void print(T[] arr){
		
		for(T i: arr) {
			
			System.out.println(i);
		}
	}
	
	public static <T extends Collection<E>, E> void print(T list) {
		
		for(E item: list) {
			
			System.out.println(item);
		}
	}
}
