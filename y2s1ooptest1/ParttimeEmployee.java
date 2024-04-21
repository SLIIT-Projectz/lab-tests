package com.labtest1;

public class ParttimeEmployee extends Employee{
	int OTHrs;

	public ParttimeEmployee(String name, double salary, int OTHrs) {
		super(name, salary);
		this.OTHrs = OTHrs;
	}
	
	public void displayEmpInfo() {
		System.out.println("Employee Name : " + this.name);
		System.out.println("Salary : " + this.salary);
		System.out.println("OTHrs : " + this.OTHrs + "\n");
	}
	
}
