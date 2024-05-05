package com.test3;

public class student {
	String StudentId, StudentName;
	
	public student(String StudentId, String StudentName) {
		this.StudentId = StudentId;
		this.StudentName = StudentName;
	}
	
	public void display() {
		try {
			if(!this.StudentId.startsWith("IT") && this.StudentId.length() != 10) {
				throw new InvalidITNumberException("Invalid IT number");
			}
			try {
				int digitCheck = Integer.parseInt(this.StudentId.substring(2));
			} catch(NumberFormatException e) {
				throw new InvalidITNumberException("Invalid IT number");
			}
			System.out.println("Student ID : " + this.StudentId);
			System.out.println("Student Name : " + this.StudentName);
		} catch(InvalidITNumberException e) {
			System.out.println(e);
		}
		
	}
}
