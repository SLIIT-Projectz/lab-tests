package com.test3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Manager extends Employee{
	String Department;
	int ProductNo1, ProductNo2, ProductNo3;
	
	Manager(){
		this.Department = "";
		this.ProductNo1 = 0;
		this.ProductNo2 = 0;
		this.ProductNo3 = 0;
	}
	
	public void Read() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Department : ");
		this.Department = sc.nextLine();
		
		try {
			System.out.println("Enter the ProductNo 1 : ");
			this.ProductNo1 = sc.nextInt();
			System.out.println("Enter the ProductNo 2 : ");
			this.ProductNo2 = sc.nextInt();
			System.out.println("Enter the ProductNo 3 : ");
			this.ProductNo3 = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("unfortunately, you have entered an invalid input!");
		}
		
		super.Read();
		
		sc.close();
	}
	
	public void Print() {
		System.out.println("Department : " + this.Department);
		System.out.println("Product No 1 : " + this.ProductNo1);
		System.out.println("Product No 2 : " + this.ProductNo2);
		System.out.println("Product No 3 : " + this.ProductNo3);
		
		super.Print();
	}
}
