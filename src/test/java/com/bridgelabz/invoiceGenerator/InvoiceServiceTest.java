package com.bridgelabz.invoiceGenerator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.bridgelabz.invoiceGenerator.model.MyRide;

public class InvoiceServiceTest {

	InvoiceGenerator invoiceGen;
	MyRide[] rides={
		new MyRide(2.0,5),
		new MyRide(0.1,1)
};

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

	//Check for fare of multiple rides
	@Test
	public void givenMultipleRides_ShouldReturnFare() {
		assertEquals(30.0, invoiceGen.calcFare(rides), 0.0);
	}
}