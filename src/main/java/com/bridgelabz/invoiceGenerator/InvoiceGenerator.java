package com.bridgelabz.invoiceGenerator;

public class InvoiceGenerator {

	public static final int TIME_COST=1;
	public static final double DIST_COST=10;
	public static final double MIN_FARE=5;
	
	public double calcFare(double distance, int time) {
		
		double totalFare=(distance*DIST_COST)+(time*TIME_COST);
		if (totalFare<MIN_FARE) return MIN_FARE;
		return totalFare;
	}
}