package com.labtest1;

public class Car extends Vehicle{
	int numSeats;
	
	public Car(String model, double rentalPricePerDay, int numSeats) {
		super(model, rentalPricePerDay);
		this.numSeats = numSeats;
	}
}
