package com.bridgelabz.invoiceGenerator.model;

import java.util.*;

public class RideRepository {
	
	Map<String,ArrayList<MyRide>> rideMap;

	public RideRepository() {
		this.rideMap = new HashMap<>();
	}
	
	public void addRides(String userID,MyRide[] rides) {
		this.rideMap.put(userID, new ArrayList<>(Arrays.asList(rides)));
	}
	
	public MyRide[] getRides(String userID) {
		return this.rideMap.get(userID).toArray(new MyRide[0]);
	}
}