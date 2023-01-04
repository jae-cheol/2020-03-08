package kr.co.day08.homework;

import java.util.Random;

public class Dice implements Game {
	public int startGame(int you) {
		Random r = new Random();
		int me = r.nextInt(3)+1;
		if(me == you) {
			System.out.println("You win");
			return 1;
		} else {
			System.out.println("You lose");
			return 0;
		}
	}
}
