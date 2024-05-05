package com.test3;

public class charArrayApp {

	public static void main(String[] args) {
		char[] myArray = {'c', 'h', 'e', 'c', 'k'};
		CharArray c1 = new CharArray(myArray);
		
		c1.swapFirstAndLast();
		c1.DisplayArray();
		c1.DisplayString();

	}

}
