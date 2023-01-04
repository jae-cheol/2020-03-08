package 수학;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 문제
 *  두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
 * 입력
 *  첫째 줄에 A와 B가 주어진다. (0 < A,B < 1010000)
 * 출력
 *  첫째 줄에 A+B를 출력한다.
ex)9223372036854775807 9223372036854775808
=>	18446744073709551615
 */
public class 큰수AB_10757 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigDecimal a = new BigDecimal(sc.next());
		BigDecimal b = new BigDecimal(sc.next());
		
		try {
			System.out.println(a.divide(b));	
		} catch(ArithmeticException ae) {
			System.out.println(a.divide(b, 2000, BigDecimal.ROUND_DOWN));
		}
	}

}
