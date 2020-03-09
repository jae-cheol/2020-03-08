package 랜덤;

import java.util.Random;

public class RandomMain {

	public static void main(String[] args) {
		
		double d = Math.random();
		System.out.println("d : " + d);
		double d2 = d * 100;
		System.out.println("d2 : " + d2);
		int num = (int)d2;
		System.out.println("num : " + num);
		System.out.println("result : " + (num+1));
		
	
		System.out.println((int)(Math.random() * 100) + 1);
		
		
		Random r = new Random();
		
		int random = r.nextInt(100) + 1;	// (0 ~ 100-1 사이의 난수 추출) + 1 ==> 1 ~ 100
		System.out.println("random : " + random);
	}
}
