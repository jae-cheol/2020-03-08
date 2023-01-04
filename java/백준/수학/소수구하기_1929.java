package 수학;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 문제
 *  M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
 * 입력
 *  첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.
 * 출력
 *  한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
ex)3 16
=>	3
	5
	7
	11
	13
 */
public class 소수구하기_1929 {

	public static void main(String[] args) throws Exception {
		// 입력
		InputStream is = System.in;						// byte
		InputStreamReader isr = new InputStreamReader(is);// character
		BufferedReader br = new BufferedReader(isr);	// String
		
		// 출력
		StringBuffer sb = new StringBuffer();

		String[] line = br.readLine().split(" ");	// 입력
		int m = Integer.parseInt(line[0]);
		int n = Integer.parseInt(line[1]);
		
		int sqrt = (int)Math.sqrt(n);	// 최대 1,000(1,000,000이니깐)

		// n+1만큼 할당
		List<Boolean> l = new ArrayList<Boolean>(n+1);
		// 0번째와 1번째를 소수 아님으로 처리
		l.add(false);
		l.add(false);
		// 초기화 : 2~ n 까지 소수로 설정 ,,, add시키지않으면 size가 안 커진다.
		for(int i=2; i<=n; i++ )
			l.add(i, true);

		// 에라토스테네스의 체
		for(int i=2; i<=sqrt; i++){
			if(l.get(i)){
				for(int j = i+i; j<=n; j+=i) {
					l.set(j, false);	// 소수가 아님.
				}
				//i*i 미만은 이미 처리되었으므로 j의 시작값은 i*i로 최적화할 수 있다.
			}
		}
		
		for(int i=m; i<=n; i++) {
			if(l.get(i)) {
				sb.append(i);
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
		
	}

}
