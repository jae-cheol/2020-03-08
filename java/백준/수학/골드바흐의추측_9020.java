package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 골드바흐의추측_9020 {

	public static void main(String[] args) throws IOException {
		// 입력
		InputStream is = System.in;						// byte
		InputStreamReader isr = new InputStreamReader(is);// character
		BufferedReader br = new BufferedReader(isr);	// String

		// 출력
		StringBuffer sb = new StringBuffer();
		
		// 에라토스테네스의 체 : 합성수(false) , 소수(true)
		int limit = 10000;
		int sqrt = (int)Math.sqrt(limit);
		List<Boolean> l = new ArrayList<Boolean>();
		l.add(false);
		l.add(false);
		for(int i=2; i<=limit; i++) {
			l.add(true);
		}
		for(int i=2; i<=sqrt; i++) {
			if(l.get(i)) {
				for(int j=i+i; j<=limit; j+=i) {
					l.set(j, false);
				}
			}
		}
		
		int t = Integer.parseInt(br.readLine());	// 테스트 케이스의 개수
 
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			int tmp = n+1;
			int ans = 0;
			int a = 0;
			int b = 0;
			for(int j=2; j<n; j++) {
				if(l.get(j) && l.get(n-j)) {
					// 차이가 더 작다면 임시저장한다.
					a = j;
					b = n-j;
					if(b-a >= 0) {
						if(tmp > b-a) {
							tmp = b-a; 
							ans = j;
						}
					}
				}
			}
			sb.append(ans + " " + (n-ans));
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
