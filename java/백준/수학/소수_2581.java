package 수학;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 문제
 *  자연수 M과 N이 주어질 때 M이상 N이하의 자연수 중 소수인 것을 모두 골라 이들 소수의 합과 최솟값을 찾는 프로그램을 작성하시오.
 *  예를 들어 M=60, N=100인 경우 60이상 100이하의 자연수 중 소수는 61, 67, 71, 73, 79, 83, 89, 97 총 8개가 있으므로, 
 *  이들 소수의 합은 620이고, 최솟값은 61이 된다.
 * 입력
 *  입력의 첫째 줄에 M이, 둘째 줄에 N이 주어진다.
 *  M과 N은 10,000이하의 자연수이며, M은 N보다 작거나 같다.
 * 출력
 *  M이상 N이하의 자연수 중 소수인 것을 모두 찾아 첫째 줄에 그 합을, 둘째 줄에 그 중 최솟값을 출력한다. 
 *  단, M이상 N이하의 자연수 중 소수가 없을 경우는 첫째 줄에 -1을 출력한다.
ex1)
60
100
=>	620
	61
ex2)
64
65
=>	-1
 */
public class 소수_2581 {

	public static void main(String[] args) throws Exception {
		InputStream is = System.in;						// byte
		InputStreamReader isr = new InputStreamReader(is);// character
		BufferedReader br = new BufferedReader(isr);	// String
		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		int ansSum = 0;
		int ansMin = 0;
		
		boolean first = true;
		while(m<=n) {
			if(m == 1) {
				m++;
				continue;
			}
			int sqrt = (int) Math.sqrt(m);
			boolean b = true;	// 소수라고 가정한다 : 합성수라면 false로 변경됨.
			for(int i=2; i<=sqrt; i++) {
				// 합성수
				if(m%i == 0) {
					b = false;
					break;
				}
			}
			
			// 소수일때 합을 구한다.
			if(b) {
				ansSum += m;	// 출력:합
				if(first) {
					ansMin = m;
					first = false;
				}
			}
			m++;
		}
		if(ansSum != 0 && ansMin != 0) {
			System.out.println(ansSum);
			System.out.println(ansMin);
		} else {
			System.out.println("-1");
		}
	}

}
