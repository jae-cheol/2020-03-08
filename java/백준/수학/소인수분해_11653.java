package 수학;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 문제
 *  정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.
 * 입력
 *  첫째 줄에 정수 N (1 ≤ N ≤ 10,000,000)이 주어진다.
 * 출력
 *  N의 소인수분해 결과를 한 줄에 하나씩 오름차순으로 출력한다. N이 1인 경우 아무것도 출력하지 않는다.
ex1)72
=>	2
	2
	2
	3
	3
ex2)3
=>	3
ex3)6
=>	2
	3
ex4)2
=>	2
ex5)9991
=>	97
	103
 */
public class 소인수분해_11653 {

	public static void main(String[] args) throws Exception {
		// 입력
		InputStream is = System.in;						// byte
		InputStreamReader isr = new InputStreamReader(is);// character
		BufferedReader br = new BufferedReader(isr);	// String
		
		// 출력
		StringBuffer sb = new StringBuffer();
		
		int n = Integer.parseInt(br.readLine());	// 입력:정수
		
		if(n > 1) {
			int var = 1;
			for(int i=2; i<=n; i=var) {
				// 나누어 떨어지면
				if(n%i == 0) {
					sb.append(i);
					sb.append("\n");
					n /= i;
					if(n==1) break;
					var = 2;
				} else {
					var++;
				}
			}
			System.out.println(sb.toString());
		}
	}

}
