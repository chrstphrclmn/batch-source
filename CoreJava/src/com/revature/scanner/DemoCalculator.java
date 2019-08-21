package com.revature.scanner;

import java.util.Scanner;

public class DemoCalculator {

	private static Scanner scanner = new Scanner(System.in);

	public void calculate() {
		System.out.println("Please enter the operation you would like to perform");
		String operationString = scanner.nextLine();
		int [] nums = getNums();
		switch (operationString) {
		case "+": System.out.println(nums[0] + nums[1]);
			break;
		case "-": System.out.println(nums[0] - nums[1]);
			break;
		case "*": System.out.println(nums[0] * nums[1]);
			break;
		case "/": System.out.println(nums[0] / nums[1]);
			break;
		default:
			System.out.println("Invalid Operation");
		}
	}
	
	public int[] getNums() {
		int[] nums = new int[2];
		System.out.println("Please enter first number:");
		nums[0] = getNum();
		System.out.println("Please enter second number");
		nums[1] = getNum();
		return nums;
	}

	private int getNum() {
		String input = scanner.nextLine();
		if(input.matches("\\d+^$")) {
			return Integer.parseInt(input);
		}else {
			System.out.println("Please enter a number");
			return getNum();
		}
	}
}
