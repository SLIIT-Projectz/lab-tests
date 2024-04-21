package com.labtest1;

public class EmpApp {

	public static void main(String[] args) {
		ParttimeEmployee ob1 = new ParttimeEmployee("Alice", 2000.00,7);
		ParttimeEmployee ob2 = new ParttimeEmployee("Alice2", 2001.00,71);
		
		ob1.displayEmpInfo();
		ob2.displayEmpInfo();
	}

}
