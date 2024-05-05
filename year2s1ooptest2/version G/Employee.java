package com.test3;

import java.util.Scanner;

public class Employee {
	String EmpId, name, address;
	
	Employee(){
		this.EmpId = "";
		this.name = "";
		this.address = "";
	}
	
	public void Read() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Employee iD : ");
		this.EmpId = sc.nextLine();
		System.out.print("\nEnter the Employee Name : ");
		this.name = sc.nextLine();
		System.out.print("\nEnter the Employee Adress : ");
		this.address = sc.nextLine();
		
		sc.close();
	}
	
	public void Print() {
		System.out.println("Employee ID : " + this.EmpId);
		System.out.println("Employee Name : " + this.name);
		System.out.println("Employee Address : " + this.address);
	}
}
