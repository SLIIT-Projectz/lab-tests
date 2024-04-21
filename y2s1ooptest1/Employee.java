package com.labtest1;

public class Employee {
	String name;
	double salary;
	
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public void displayInfo() {
		System.out.println("Employee Name : " + this.name);
		System.out.println("Employee Salary : " + this.salary);
	}
}
