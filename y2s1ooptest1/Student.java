package com.labtest1;

public class Student {
	String name;
	int age;
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}


	public int getAge() {
		return age;
	}

	
	public void displayInfo() {
		System.out.println("Student Name : " + this.name);
		System.out.println("Student Age : " + this.age);
	}
}
