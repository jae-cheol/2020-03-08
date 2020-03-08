package 예외처리;

import java.util.Random;

public class ExceptionMain02 {

	public static void main(String[] args) {
		
		System.out.println("main start... ");
		
		Random r = new Random();
		int num = r.nextInt(2);		// 0 or 1
		System.out.println("추출된 정수 : " + num);

		try {
			System.out.println(1 / num);
		} catch(ArithmeticException ae) {
//			System.out.println(ae.getMessage());
			ae.printStackTrace();
		}
		
		System.out.println("main end...");
	}
}