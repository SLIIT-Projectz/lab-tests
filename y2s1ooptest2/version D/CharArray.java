package com.test3;

public class CharArray {
	char myCharArray[];
	
	public CharArray(char myCharArray[]) {
		this.myCharArray = myCharArray;
	}
	
	public void swapFirstAndLast() {
		int len = this.myCharArray.length;
		char first = this.myCharArray[0];
		this.myCharArray[0] = this.myCharArray[len-1];
		this.myCharArray[len-1] = first;
	}
	
	public void DisplayArray() {
		System.out.print("Char : ");
		for(char ob : this.myCharArray) {
			System.out.print(ob + " ");
		}
	}
	
	public void DisplayString() {
		String myString = new String(this.myCharArray);
		System.out.println("\nString : " + myString);
	}
}
