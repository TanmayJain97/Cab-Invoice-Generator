package com.bridgelabz.invoiceGenerator;

import com.bridgelabz.invoiceGenerator.model.InvoiceSummary;
import com.bridgelabz.invoiceGenerator.model.MyRide;
import com.bridgelabz.invoiceGenerator.model.RideRepository;

public class InvoiceService {

	private static final int TIME_COST=1;
	private static final double DIST_COST=10;
	private static final double MIN_FARE=5;
	private RideRepository rideRepo;
	
	public void addRepo(RideRepository repo) {
		this.rideRepo=repo;
	}

	public double calcFare(double distance, int time) {
		
		double totalFare=(distance*DIST_COST)+(time*TIME_COST);
		return Math.max(totalFare, MIN_FARE);
	}

	public InvoiceSummary calcFare(MyRide[] rides) {
		double totalFare=0;
		for (MyRide ride : rides) {
			totalFare=totalFare+ride.cabRide.calcFare(ride);
		}
		return new InvoiceSummary(rides.length, totalFare);
	}
	
	public void addRides(String userID, MyRide[] rides) {
		rideRepo.addRides(userID, rides);
	}
	
	public InvoiceSummary getInvoiceSummary(String userID) {
		return this.calcFare(rideRepo.getRides(userID));
	}
}