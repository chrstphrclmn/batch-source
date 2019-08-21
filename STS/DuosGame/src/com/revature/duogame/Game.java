package com.revature.duogame;

import java.util.Random;
import java.util.Scanner;

public class Game {
	
	public int target = 0;
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	
	public void play() {
		
		
		target = rand.nextInt(100);
		this.guess(1,0,100);
		
	}
	
	public void guess(int count, int low, int high) {
		
		int guess = 0;
		
		
		
		System.out.println("Please guess a number between " + low + " and " + high + ".");
		
		try {
			guess = Integer.parseInt(scan.nextLine());
		}catch(NumberFormatException ex){
			System.out.println("Please guess with an Integer.");
			guess(count, low, high);
		}
		
		if(guess > high || guess < low) {
			
			System.out.println("That number is out of bounds.");
			guess(count, low, high);
		}
		
		
		if(guess == target) {
			System.out.println("You win. Number of Attempts: "+count);
		}
		else if(guess < target) {
			System.out.println("You are too low.");
			count++;
			low = guess;
			this.guess(count, low, high);
		}
		else {
			System.out.println("You are too high.");
			count++;
			high = guess;
			this.guess(count, low, high);
		}
		
		
	}

}
