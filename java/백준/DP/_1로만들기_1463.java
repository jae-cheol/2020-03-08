package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class _1로만들기_1463 {

	public static void main(String[] args) throws IOException {
		// 입력
		InputStream is = System.in;						// byte
		InputStreamReader isr = new InputStreamReader(is);// character
		BufferedReader br = new BufferedReader(isr);	// String

		// 출력
		StringBuffer sb = new StringBuffer();

		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		while(true) {
			if(n%3 == 0) {
				n /= 3;
			} else if(n%2 == 0) {
				n /= 2;
			} else {
				n -= 1;
			}
			cnt++;
			if(n == 1) break;
		}
		sb.append(cnt);
		
		System.out.println(sb.toString());
	}

}
