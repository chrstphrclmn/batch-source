package com.revature.guessinggame;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		play();
	}

	static void play() {
		int r = (int) ((Math.random()) * (100));
		try (Scanner scanner = new Scanner(System.in);) {
			int attempts = 0, max = 100, min = 0;
			while (true) {
				System.out.println("Enter the number between " + min + " and " + max);
				String inputString = scanner.nextLine();
				int inputNumber;
				try {
					inputNumber = Integer.parseInt(inputString);
				} catch (Exception e) {
					System.out.println("Invalid number");
					continue;
				}
				if (inputNumber > max || inputNumber < min) {
					System.out.println("Out of range");
				}
				if (inputNumber == r) {
					System.out.println("The number is correct! \n Number of attempts: " + attempts);
					break;
				} else if (inputNumber > r) {
					max = inputNumber;
					attempts++;
					System.out.println("The number entered is greater");
				} else {
					min = inputNumber;
					attempts++;
					System.out.println("The number entered is less");
				}
			}
		}
	}

}
