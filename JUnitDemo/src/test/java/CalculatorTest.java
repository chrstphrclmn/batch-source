import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.Calculator;
import com.revature.NegativeNumberException;

public class CalculatorTest {

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
		int sum = Calculator.add("fjksaddlfjakslf");
		assertEquals(-1, sum);
	}
	@Test
	public void invalidInput2() {
		int sum = Calculator.add("8,12,14,dog");
		assertEquals(-1,sum);
	}

	@Test
	public void testNullInput() {
		int sum = Calculator.add(null);
		assertEquals(-1, sum);
	}

	@Test
	public void testUnknownNumberOfInputs1() {
		int sum = Calculator.add("8,5,2,45,12,1");
		assertEquals(73, sum);
	}
	
	@Test
	public void testUnknownNumberOfInputs2() {
		int sum = Calculator.add("8,9,10,12,14,18,22,24,28,30");
		assertEquals(175, sum);
	}
	
	@Test
	public void testNewLine1() {
		int sum = Calculator.add("8,9,10\n12,14");
		assertEquals(53, sum);
	}
	
	@Test 
	public void testNewLine2() {
		int sum = Calculator.add("10,20\n10\n20\n30");
		assertEquals(90, sum);
	}
	
	@Test(expected=NegativeNumberException.class)
	public void testNegativeNumber() {
		int sum = Calculator.add("5,-3");
		
	}
	@Test(expected=NegativeNumberException.class)
	public void testNegativeNumber2() {
		int sum = Calculator.add("5,8,12,-12");
		
	}
	
	@Test
	public void ignoreOver1000() {
		int sum = Calculator.add("12,24,10,1002,5,1200");
		assertEquals(51, sum);
	}
	
	@Test
	public void ignoreOver1000include1000() {
		int sum = Calculator.add("1000,1020,1030,1040");
		assertEquals(1000, sum);
	}
	
	@Test
	public void workWithSpaces() {
		int sum = Calculator.add("1000, 40, 20, 10,12,30");
		assertEquals(1112, sum);
	}
}
