package com.test3;

public class EmployeeQ2 implements Comparable<EmployeeQ2> {
    int id, hours;
    String name;
    
    public EmployeeQ2() {
        this.id = 0;
        this.name = " ";
        this.hours = 0;
    }
    
    public EmployeeQ2(int id, String name, int hours) {
        this.id = id;
        this.name = name;
        this.hours = hours;
    }
    
    @Override
    public int compareTo(EmployeeQ2 other) {
        return Integer.compare(this.id, other.id);
    }
}
