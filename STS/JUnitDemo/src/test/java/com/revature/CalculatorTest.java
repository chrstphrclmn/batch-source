package com.revature;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void emptyStringReturnsZero() {
		int sum = Calculator.add("");
		assertEquals(0,sum);
	}
	
	@Test
	public void singleValueREturns() {
		int sum = Calculator.add("5");
		assertEquals(5,sum);
		
		
	}
	
	
	@Test
	public void twoNumbersReturnSum() {
		int sum = Calculator.add("6,8");
		assertEquals(14,sum);
	}
	
	@Test
	public void invalidInput() {
		int sum = Calculator.add("fahsklaksd");
		assertEquals(-1, sum);
	}
	
	
}
