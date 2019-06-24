package assignment3.exercise_3_4_sort;

import static org.junit.Assert.*;

import org.junit.Test;

public class JuTestSort {

	@Test
	public void test1() {
		
		double[]values = Sort.generateTestData(100); 

		assertTrue(Sort.isOrdered(values));
	}
	
	@Test
	public void test2() {
		double[]values = Sort.generateTestData(1000); 

		assertTrue(Sort.isOrdered(values));
	}
	
	@Test
	public void test3() {
		double[]values = Sort.generateTestData(10000); 

		assertTrue(Sort.isOrdered(values));
	}
	
	@Test
	public void test4() {
		double[]values = Sort.generateTestData(100000); 

		assertTrue(Sort.isOrdered(values));
	}

	
}
