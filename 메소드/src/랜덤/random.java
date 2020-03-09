package 랜덤;

import java.util.Random;

public class random {
	/*
	 * random(100) = 1~100 사이의 정수가 나옴.
	 * 
	 * 실수로 바꾸려면 int i ---> double i
	 */
	static int random(int i) {
		Random r = new Random();
		i = r.nextInt(i) + 1; // r.nextInt(4) = 1~3 범위에서 나옴.
		return i;
	}

	public static void main(String[] args) {

	}
}
