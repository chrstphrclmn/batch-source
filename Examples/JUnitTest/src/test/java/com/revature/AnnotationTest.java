package com.revature;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AnnotationTest {

	@Test
	public void testOne() {
		
		System.out.println("Called Test One.");
		assertEquals(5, 5);
	}
	
	@Test
	public void testTwo() {
		
		System.out.println("Called Test Two.");
		assertTrue(false);
	}
}
