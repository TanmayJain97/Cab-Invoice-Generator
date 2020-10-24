package com.bridgelabz.invoiceGenerator.model;

public enum RideTypes {
	NORMAL(10.0,1,5.0), PREMIUM(15.0,2,20.0);

	private final double distCost;
	private final int timeCost;
	private final double minFare;


	private RideTypes(double distCost, int timeCost, double minFare) {
		this.distCost = distCost;
		this.timeCost = timeCost;
		this.minFare = minFare;
	}

	public double calcFare(MyRide ride) {

		double totalFare=(ride.distance*distCost)+(ride.time*timeCost);
		return Math.max(totalFare, minFare);
	}
}