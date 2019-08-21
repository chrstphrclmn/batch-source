package com.revature;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalculatorTest {
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public void emptyStringReturnsZero() {
		int sum = Calculator.add("");
		assertEquals(0, sum);
	}
	
	@Test
	public void singleValueReturns() {
		int sum = Calculator.add("5");
		assertEquals(5, sum);
	}
	
	@Test
	public void twoNumbersReturnSum() {
		int sum = Calculator.add("6,8");
		assertEquals(14, sum);
	}
	
	@Test
	public void invalidInput() {
		int sum = Calculator.add("fahskhfkj");
		assertEquals(-1, sum);
	}
	
	@Test
	public void testNullInput() {
		int sum = Calculator.add(null);
		assertEquals(-1, sum);
	}

	@Test
	public void testFourInputs() {
		
		int sum = Calculator.add("1, 2, 3, 4");
		assertEquals(10, sum);
	}
	
	@Test
	public void newLine() {
		int sum = Calculator.add("1,\n2\n3\n4");
		assertEquals(10, sum);
	}
	
	@Test
	public void negativeInputs() {
		
		expectedException.expect(IllegalArgumentException.class);
		Calculator.add("-1, -2, -3, -4");
	}
	
	@Test
	public void largeInput() {
		
		int sum = Calculator.add("1000, 1000");
		assertEquals(0, sum);
	}
}
