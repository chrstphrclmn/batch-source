package com.revature.game;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game {

	public int num;
	public int min;
	public int max;
	
	public Game(){
		
		Random random = new Random();
		this.num = random.nextInt(101);
		this.min = 0;
		this.max = 100;
		
	}
	
	public void play() {
		
		Scanner scan = new Scanner(System.in);
		int val = 0;
		int attempts = 0;
		
		while(true) {
			
			System.out.printf("Enter a number between %d and %d\n", this.min, this.max);
			
			while(true) {
				
				try {
					val = scan.nextInt();
					break;
				}
				
				catch(InputMismatchException e) {
					
					System.out.println("Please enter a valid Integer.");
					scan.next();
				}
			}
			
			if(val < this.min || val > this.max) {
				
				System.out.printf("Out of number range\n");
			}
			
			else {
				
				attempts ++;
				
				if(val == this.num) {
					
					break;
				}
				
				else if(val > this.num) {
					
					System.out.println("Too High!");
					this.max = val;
				}
				else {
					
					System.out.println("Too Low!");
					this.min = val;
				}
				
			}
		}
		
		System.out.printf("Number Successfully Guessed\nAttempts: %d", attempts);
		scan.close();
	}
}
