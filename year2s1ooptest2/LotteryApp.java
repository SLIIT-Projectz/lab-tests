package com.test3;

public class LotteryApp {

	public static void main(String[] args) {
		Lottery l1 = new Lottery();
		
		l1.acceptInput();
		l1.displayLottery();
		
		System.out.println("\nNumber of matching digits: " + l1.compareLottery());
		l1.displayMatch();
	}

}
