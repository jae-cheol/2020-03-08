package kr.co.day08.homework;

import java.util.Random;

public class ScissorsRockPaper implements Game {
	final static int SCISSOR = 0;
	final static int ROCK = 1;
	final static int PAPER = 2;
	
	public int startGame(int you) {
		Random r = new Random();
		int me = r.nextInt(3)+1;
		if((me+1)%3 == you) {
			System.out.println("You win");
			return 1;
		} else if(me == you) {
			System.out.println("비겼습니다.");
			return 0;
		} else { // (me+1)%3 != you
			System.out.println("You lose");
			return 0;
		}
//		if(me == you) {
//			System.out.println("비겼습니다.");
//			return 0;
//		} else if(me == 1 && you == 3 || me == 2 && you == 1 || me == 3 && you == 2) {
//			System.out.println("You lose");
//			return 0;
//		} else {
//			System.out.println("You win");
//			return 1;
//		}
	}
}
