package com.labtest1;

public class Vehicle {
	String model;
	double rentalPricePerDay;
	
	public Vehicle(String model, double rentalPricePerDay) {
		this.model = model;
		this.rentalPricePerDay = rentalPricePerDay;
	}
	
	public double calculateRentalCost(int days) {
		return this.rentalPricePerDay * days;
	}
}
