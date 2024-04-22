package com.test;

public class MenInBlack {
	int score;
	protected AlienPack alienpack;
	
	public MenInBlack(AlienPack alienpack) {
		this.alienpack = alienpack;
		this.score = 0;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public AlienPack getAlienpack() {
		return alienpack;
	}

	public void setAlienpack(AlienPack alienpack) {
		this.alienpack = alienpack;
	}
	
	public void kill() {
		Alien[] aliens = alienpack.getAliens();
		for(Alien alien: aliens) {
			score += alien.getScore();
		}
	}
	
}
