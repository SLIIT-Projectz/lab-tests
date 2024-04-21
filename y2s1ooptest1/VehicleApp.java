package com.labtest1;

public class VehicleApp {

	public static void main(String[] args) {
		Car c1 = new Car("model1", 5000.00, 5);
		Motorcycle m1 = new Motorcycle("model2", 1500.00, 2);
		
		System.out.println("Rental price of the car : " + c1.calculateRentalCost(3));
		System.out.println("Rental price of the Motorcycle : " + m1.calculateRentalCost(5));
	}

}
