package com.test3;

import java.util.Scanner;

public class DemoApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String teleNo;
		
		try {
			System.out.println("Enter the telephone number : ");
			teleNo = sc.nextLine().trim();
			if(teleNo.length() != 10) {
				throw new InvalidPhoneNumberDigits("The phone number must have exactly 10 digits");
			}
			if(teleNo.charAt(0) != '0') {
				throw new InvalidPhoneNumberStart("The phone number must start with 0");
			}
			
			System.out.println("The phone number is : " + teleNo);
			
		} catch(InvalidPhoneNumberDigits e) {
			System.out.println(e);
		} catch(InvalidPhoneNumberStart e) {
			System.out.println(e);
		}finally {
			sc.close();
		}

	}

}
