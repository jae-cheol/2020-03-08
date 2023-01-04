package 비트연산자;

import java.util.Random;
public class AND연산 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random ran = new Random();
		int num = ran.nextInt(100);
		System.out.println(num & 1);
		/**
		 * &연산은 모두1일 경우에만 1이 되기때문에,,,,,
		 * 2진법에서는 맨 마지막 자리로 홀/짝이 판단되기 때문. 
		 */
		if((num & 1) > 0) {
			System.out.println(num + "은 홀수");
		} else {
			System.out.println(num + "은 짝수");
		}
	}

}
