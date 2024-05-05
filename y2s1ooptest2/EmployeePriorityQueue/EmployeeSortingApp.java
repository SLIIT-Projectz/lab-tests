package com.test3;

import java.util.PriorityQueue;

public class EmployeeSortingApp {

	public static void main(String[] args) {
		PriorityQueue<EmployeeQ2> p = new PriorityQueue<EmployeeQ2>();
		PriorityQueue<EmployeeQ2> p2 = new PriorityQueue<EmployeeQ2>();

		p.add(new EmployeeQ2(1, "Employee1", 10));
		p.add(new EmployeeQ2(9, "Employee1", 17));
		p.add(new EmployeeQ2(7, "Employee1", 03));
		p.add(new EmployeeQ2(4, "Employee1", 24));
		p.add(new EmployeeQ2(5, "Employee1", 10));
//	}

		for(EmployeeQ2 ob: p) {
			System.out.println("ID: " + ob.id + ", Name: " + ob.name + ", Hours: " + ob.hours);
			
			if(ob.hours > 15) {
				p2.add(ob);
			}
		}
		
		System.out.println("\n");
		
		for(EmployeeQ2 ob: p2) {
			System.out.println("ID: " + ob.id + ", Name: " + ob.name + ", Hours: " + ob.hours);
		}
		
		
	}
}
