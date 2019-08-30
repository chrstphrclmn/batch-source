package com.revature;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetExercises {

	public static void main(String[] args) {
		
		HashSet<Product> hset1 = new HashSet<>();
		
		hset1.add(new Product(1, 10, 4.5));
		hset1.add(new Product(2, 20, 5.5));
		hset1.add(new Product(3, 5, 6.5));
		
		for (Product p : hset1) {
			
			System.out.println(p.toString());
		}
		
		System.out.println("----");
		LinkedHashSet<Product> hset2 = new LinkedHashSet<>();
		
		hset2.add(new Product(1, 10, 4.5));
		hset2.add(new Product(2, 20, 5.5));
		hset2.add(new Product(3, 5, 6.5));

		for (Product p : hset2) {
			
			System.out.println(p.toString());
		}
		
		System.out.println("----");
		TreeSet<Product> tset = new TreeSet<>();
		
		tset.add(new Product(3, 10, 4.5));
		tset.add(new Product(1, 20, 5.5));
		tset.add(new Product(2, 5, 6.5));
		tset.add(new Product(4, 3, 8.7));
		
		for (Product p : tset) {
			
			System.out.println(p.toString());
		}

	}
}
