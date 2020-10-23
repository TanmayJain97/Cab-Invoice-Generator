package com.bridgelabz.invoiceGenerator;

import com.bridgelabz.invoiceGenerator.model.InvoiceSummary;
import com.bridgelabz.invoiceGenerator.model.MyRide;

public class InvoiceGenerator {

	public static final int TIME_COST=1;
	public static final double DIST_COST=10;
	public static final double MIN_FARE=5;
	
	public double calcFare(double distance, int time) {
		
		double totalFare=(distance*DIST_COST)+(time*TIME_COST);
		return Math.max(totalFare, MIN_FARE);
	}

	public InvoiceSummary calcFare(MyRide[] rides) {
		double totalFare=0;
		for (MyRide ride : rides) {
			totalFare=totalFare+this.calcFare(ride.distance, ride.time);
		}
		return new InvoiceSummary(rides.length, totalFare);
	}
}