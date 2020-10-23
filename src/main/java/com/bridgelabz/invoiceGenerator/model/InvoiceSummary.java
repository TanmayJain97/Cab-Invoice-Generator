package com.bridgelabz.invoiceGenerator.model;

public class InvoiceSummary {
	
	public int noOfRides = 0;
	public double fare=0;
	public double avgFare=0;
	
	public InvoiceSummary(int noOfRides, double fare) {
		this.noOfRides = noOfRides;
		this.fare = fare;
		try {
			this.avgFare=fare/noOfRides;
		}catch (ArithmeticException exception) {
			System.out.println("Cannot instantiate zero rides.");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(avgFare);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(fare);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + noOfRides;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceSummary other = (InvoiceSummary) obj;
		if (Double.doubleToLongBits(avgFare) != Double.doubleToLongBits(other.avgFare))
			return false;
		if (Double.doubleToLongBits(fare) != Double.doubleToLongBits(other.fare))
			return false;
		if (noOfRides != other.noOfRides)
			return false;
		return true;
	}
}