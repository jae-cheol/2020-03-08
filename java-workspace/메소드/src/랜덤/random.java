package ����;

import java.util.Random;

public class random {
	/*
	 * random(100) = 1~100 ������ ������ ����.
	 * 
	 * �Ǽ��� �ٲٷ��� int i ---> double i
	 */
	static int random(int i) {
		Random r = new Random();
		i = r.nextInt(i) + 1; // r.nextInt(4) = 1~3 �������� ����.
		return i;
	}

	public static void main(String[] args) {

	}
}
