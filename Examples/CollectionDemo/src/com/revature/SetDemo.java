package com.revature;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetDemo {
	
	public static void main(String[] args) {
		
		/*
		 * HashSet
		 * 	- No Repeating Values
		 *  - Not sorted or organized
		 *  - Order can change over time
		 *  - Relies on the hashcode method
		 *  - Contains HashMap; uses a dummy value
		 */
		
		HashSet<Integer> hset1 = new HashSet<>();
		for(int i = 0 ; i < 10 ; i ++) hset1.add(i * 14 % 39);
		System.out.println(hset1);
		
		/*
		 * LinkedHashSet
		 * 	- HashSet with a LinkedList running through the elements
		 * 	- Less Efficient than a HashSet since the LinkedList must be maintained
		 * 	- Maintains and retains insertion order
		 */
		
		LinkedHashSet<Integer> hset2 = new LinkedHashSet<>();
		for(int i = 0 ; i < 10 ; i ++) hset2.add(i * 14 % 39);
		System.out.println(hset2);
		
		/*
		 * TreeSet
		 * 	- Sorted using natural ordering
		 * 	- Implements a binary search tree to maintain order
		 */
		
		TreeSet<Integer> tset1 = new TreeSet<>();
		for(int i = 0 ; i < 10 ; i ++) tset1.add(i * 14 % 39);
		System.out.println(tset1);
	}

}
