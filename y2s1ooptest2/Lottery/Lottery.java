package com.test3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Lottery {
	int[] lotteryNumbers = new int[5];
	int[] userNumbers = new int[5];
	ArrayList<Integer> matchDigit = new ArrayList<Integer>();
	int temp;
	
	Lottery() {
		Random ran = new Random();
		
		for(int i=0; i<5; i++) {
			lotteryNumbers[i] = ran.nextInt(10);
		}
	}
	
	public void acceptInput() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("User's numbers: ");
		for(int i=0; i<5; i++) {
			this.userNumbers[i] = sc.nextInt();
		}
		
		sc.close();
	}
	
	public int compareLottery() {
		int matchingNo = 0;
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(this.lotteryNumbers[i] == this.userNumbers[j]) {
					this.matchDigit.add(this.lotteryNumbers[i]);
					matchingNo++;
				}
			}
		}
		return matchingNo;
	}
	
	public void displayLottery() {
		System.out.print("Lottery Numbers: ");
		for(int i=0; i<5; i++) {
			System.out.print(this.lotteryNumbers[i] + " ");
		}
	}
	
	public void displayMatch() {
		System.out.print("Matching digits: ");
		
		for(Integer matched: matchDigit) {
			System.out.print(matched + " ");
		}
	}
}
