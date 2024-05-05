package com.test3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AlarmClock {
	int Hour, Minute, Second;
	
	AlarmClock(){
		this.Hour = 12;
		this.Minute = 0;
		this.Second = 0;
	}
	
	public void InputAlarm() {
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter the Hour : ");
			int hour = sc.nextInt();
			System.out.println("Enter the Minute : ");
			int minute = sc.nextInt();
			System.out.println("Enter the Second : ");
			int second = sc.nextInt();
			
			if (hour < 0 || hour > 12 || minute < 0 || minute > 59 || second < 0 || second > 59) {
	            throw new InvalidTimeException("Invalid time format. Hours should be between 0 to 12, and minutes/seconds should be between 0 to 59.");
	        }
			
			this.Hour = hour;
			this.Minute = minute;
			this.Second = second;
			
		} catch(InputMismatchException e) {
			System.out.println(e.getMessage());
		} catch(InvalidTimeException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void ShowAlarm() {
		System.out.println("Alarm set at " + this.Hour + " Hours " + this.Minute + " Minutes and " + this.Second + " Seconds");
	}
	
	public void setAlarm() {
		
	}
}
