package ����ó��;

import java.util.Random;

public class ExceptionMain01 {

	public static void main(String[] args) {
		
		System.out.println("main start... ");
		
		Random r = new Random();
		int num = r.nextInt(2);		// 0 or 1
		System.out.println("����� ���� : " + num);
		
		System.out.println(1 / num);
		
		System.out.println("main end...");
	}
}
