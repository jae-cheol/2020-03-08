package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 에라토스테네스의체_2960 {

	public static void main(String[] args) throws IOException {
		// 입력
		InputStream is = System.in;						// byte
		InputStreamReader isr = new InputStreamReader(is);// character
		BufferedReader br = new BufferedReader(isr);	// String

		String[] s = br.readLine().split(" ");
		
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);

		// 출력
		StringBuffer sb = new StringBuffer();
		
		int cnt = 0;
		
		// 에라토스테네스의 체 : 합성수(false) , 소수(true)
		int limit = n;
		List<Boolean> l = new ArrayList<Boolean>();
		l.add(false);
		l.add(false);
		for(int i=2; i<=limit; i++) {
			l.add(true);
		}
		for(int i=2; i<=limit; i++) {
			if(l.get(i)) {
				cnt++;
				for(int j=i*i; j<=limit; j+=i) {
					if(l.get(j)) {
						cnt++;
						l.set(j, false);
					}
					if(cnt == k) {
						sb.append(j);
						break;
					}
				}
				if(sb.length() == 0 && cnt == k) {
					sb.append(i);
				}
			}
			if(cnt == k) break;
		}
		System.out.println(sb.toString());
	}

}
