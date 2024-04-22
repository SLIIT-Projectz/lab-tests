package com.test;

public class MenInBlackLevel2 extends MenInBlack{

	public MenInBlackLevel2(AlienPack alienpack) {
		super(alienpack);
	}
	
	public void kill() {
		Alien[] aliens = alienpack.getAliens();
		for (Alien alien : aliens) {
            if (generateRandom() % 2 != 0) {
                setScore(getScore() - alien.getScore());
            } else {
                setScore(getScore() + alien.getScore());
            }
        }
	}
	
	private int generateRandom() {
		return (int) ((Math.random() * 100) + 1);
	}

}
