package com.labtest1;

public class Course extends Student{
	String courseName;
	
	public Course(String name, int age, String courseName) {
		super(name, age);
		this.courseName = courseName;
	}
	
	public void displayCourseInfo() {
		System.out.println("Student Name : " + this.name);
		System.out.println("Student Age : " + this.age);
		System.out.println("Course Name : " + this.courseName + "\n");
	}
}
