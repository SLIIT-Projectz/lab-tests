package com.test;

public class AlienPack {
	private Alien[] aliens;
	
	public AlienPack(int size) {
		aliens = new Alien[size];
	}
	
	public void addAlien(Alien alien, int index) {
		aliens[index] = alien;
	}
	
	public Alien[] getAliens() {
		return aliens;
	}

}

