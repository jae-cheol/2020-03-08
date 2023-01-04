package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RGB거리_1149 {

	static int[][] d = new int[1001][4];
	static int[][] rgb = new int[1001][4]; 
	public static void main(String[] args) throws IOException {
		InputStream is = System.in;						// 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr);	// 스트링
		int n = Integer.parseInt(br.readLine());	// 집의 수
		for(int i=1; i<=n; i++) {
			String[] s = br.readLine().split(" ");
			rgb[i][1] = Integer.parseInt(s[0]);
			rgb[i][2] = Integer.parseInt(s[1]);
			rgb[i][3] = Integer.parseInt(s[2]);
		}
		dp(n);
		StringBuffer sb = new StringBuffer();
		sb.append(Math.min(Math.min(d[n][1], d[n][2]), d[n][3]));
		System.out.println(sb.toString());
	}
	
	// DP
	public static void dp(int n) {
		/**
		 * rgb[1][1] + rgb[2][2]	// 첫번째줄 1번 + 두번째줄 2번
		 * rgb[1][1] + rgb[2][3]	// 첫번째줄 1번 + 두번쨰줄 3번
		 * rgb[1][2] + rgb[2][1]
		 * rgb[1][2] + rgb[2][3]
		 * rgb[1][3] + rgb[2][1]
		 * rgb[1][3] + rgb[2][2]
		 */
		for(int i=1; i<=n; i++) {
			d[i][1] = Math.min(d[i-1][2], d[i-1][3]) + rgb[i][1];
			d[i][2] = Math.min(d[i-1][1], d[i-1][3]) + rgb[i][2];
			d[i][3] = Math.min(d[i-1][1], d[i-1][2]) + rgb[i][3];
		}
	}
}
