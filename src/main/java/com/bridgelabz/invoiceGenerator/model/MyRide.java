package com.bridgelabz.invoiceGenerator.model;

public class MyRide {

	RideTypes type;
	public double distance;
	public int time;
	public RideTypes cabRide;
	
	public MyRide(RideTypes cabRide,double distance, int time) {
		this.cabRide=cabRide;
		this.distance = distance;
		this.time = time;
	}
}