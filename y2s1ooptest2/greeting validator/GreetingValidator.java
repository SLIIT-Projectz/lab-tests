package com.test3;

import java.util.Scanner;

public class GreetingValidator {
	public static void main(String args[]) {
		String name;
		int age;
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter the name : ");
			name = sc.nextLine();
			System.out.println("Enter the age : ");
			age = sc.nextInt();
			
			if(age <= 120 && age >= 0 ) {
				System.out.println("Hello there, " + name + " ... your age is " + age);
			} else {
				throw new InvalidInputException("Invalid age: Age should be a positive integer less than or equal to 120");
			}
		} catch (InvalidInputException e) {
			System.out.println(e);
		}
	}
}
