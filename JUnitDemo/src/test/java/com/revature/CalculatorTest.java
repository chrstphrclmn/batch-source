package com.revature;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {
	
	@Test
	public void emptyStringReturnsZero() {
		int sum = Calculator.add("");
		assertEquals(0, sum);
	}

	@Test
	public void addThreeNmbers() {
		int sum = Calculator.add("5", "8", "3");
		System.out.println(sum);
		assertEquals(16, sum);
	}
	
	@Test
	public void singleValueReturns() {
		int sum = Calculator.add("5");
		assertEquals(5, sum);
	}
	
	@Test
	public void twoNumbersReturnSum() {
		int sum = Calculator.add("6,8", "8,6");
		System.out.println(sum);
		assertEquals(28, sum);
	}
	
	@Test
	public void invalidInput() {
		int sum = Calculator.add("fahskhfkj");
		assertEquals(-1, sum);
	}
	
	@Test
	public void testNullInput() {
		String[] array = null;
		int sum = Calculator.add(array);
		assertEquals(-1, sum);
	}
	
	@Test
	public void newLineDelimeter() {
		int sum = Calculator.add("5\n");
		assertEquals(5, sum);
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void throwsIllegalArgumentException() {
		Calculator.add("6,1000", "8,-1");
	}
	
	@Test
	public void numberGreaterThan1000() {
		int sum = Calculator.add("6,1000", "8,6");
		System.out.println(sum);
		assertEquals(20, sum);
	}

}
