package com.labtest1;

public class Motorcycle extends Vehicle {
	int engineCapacity;
	
	public Motorcycle(String model, double rentalPricePerDay, int engineCapacity) {
		super(model, rentalPricePerDay);
		this.engineCapacity = engineCapacity;
	}
}
