package com.labtest1;

public class StudentApp {

	public static void main(String[] args) {
		Course ob1 = new Course("Alice", 20, "Java Programming");
		Course ob2 = new Course("Alice2", 202, "Java Programming 2");
		
		ob1.displayCourseInfo();
		ob2.displayCourseInfo();
	}

}
