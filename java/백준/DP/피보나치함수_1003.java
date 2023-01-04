package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 피보나치함수_1003 {

	public static void main(String[] args) throws IOException {
		// 입력
		InputStream is = System.in;						// byte
		InputStreamReader isr = new InputStreamReader(is);// character
		BufferedReader br = new BufferedReader(isr);	// String

		// 출력
		StringBuffer sb = new StringBuffer();

		int t = Integer.parseInt(br.readLine());
		int[][] dp = new int[41][41];
		dp[0][0] = dp[1][1] = 1;
		dp[0][1] = dp[1][0] = 0;
		for(int i=2; i<41; i++) {
			dp[i][0] = dp[i-1][0] + dp[i-2][0];
			dp[i][1] = dp[i-1][1] + dp[i-2][1];
		}
		
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
