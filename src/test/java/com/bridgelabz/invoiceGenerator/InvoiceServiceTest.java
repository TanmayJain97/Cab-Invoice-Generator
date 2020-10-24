package com.bridgelabz.invoiceGenerator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.bridgelabz.invoiceGenerator.model.InvoiceSummary;
import com.bridgelabz.invoiceGenerator.model.MyRide;
import com.bridgelabz.invoiceGenerator.model.RideRepository;
import com.bridgelabz.invoiceGenerator.model.RideTypes;

public class InvoiceServiceTest {

	InvoiceService invoiceGen;
	InvoiceSummary summary;
	InvoiceSummary summaryByUID;
	RideRepository repo;
	String userId="user1";
	MyRide[] rides={
			new MyRide(RideTypes.NORMAL,2.0,5),
			new MyRide(RideTypes.NORMAL,0.1,1),
			new MyRide(RideTypes.PREMIUM,5,20),
	};

	@Before
	public void init() {
		invoiceGen=new InvoiceService();
		
		repo=new RideRepository();
		invoiceGen.addRepo(repo);
		
		invoiceGen.addRides(userId, rides);
		
		summary=invoiceGen.calcFare(rides);
		summaryByUID=invoiceGen.getInvoiceSummary(userId);
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
		InvoiceSummary expectedSummary=new InvoiceSummary(3, 115.0);
		assertEquals(expectedSummary, summary);
	}

	//Check for summary from RideRepo
	@Test
	public void givenUserId_ShouldReturnInvoiceSummary() {
		InvoiceSummary expectedSummary=new InvoiceSummary(3, 115.0);
		assertEquals(expectedSummary, summaryByUID);
	}
}