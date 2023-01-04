package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class _2xn타일링 {

	static int[] ar = new int[1001];
	public static void main(String[] args) throws IOException {
		InputStream is = System.in;						// 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr);	// 스트링
		int n = Integer.parseInt(br.readLine());	// 입력값
		dp(n);
		StringBuffer sb = new StringBuffer();
		sb.append(ar[n]);
		System.out.println(sb.toString());
	}
	
	// DP
	public static void dp(int n) {
		ar[1] = 1;
		ar[2] = 2;
		if(n==1 || n==2) {
			return;
		} else {
			for(int i=3; i<=n; i++) {
				ar[i] = (ar[i-1] + ar[i-2])%10007;
			}
		}
	}

}
