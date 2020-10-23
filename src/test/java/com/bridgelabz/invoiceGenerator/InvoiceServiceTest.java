package com.bridgelabz.invoiceGenerator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {

	InvoiceGenerator invoiceGen;
	
	@Before
	public void init() {
		invoiceGen=new InvoiceGenerator();
	}
	
	//Check for fare
	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		double distance=2.0;
		int time=5;
		double fare=invoiceGen.calcFare(distance, time);
		assertEquals(25.0, fare, 0.0);
	}
	
	//Check for min fare
		@Test
		public void givenLessDistanceAndTime_ShouldReturnMinFare() {
			assertEquals(5.0, invoiceGen.calcFare(0.1, 1), 0.0);
		}
}