package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 효율적인화폐구성 {

	public static void main(String[] args) throws IOException {
		InputStream is = System.in;						// 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr);	// 스트링
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);	// 금액
		
		int[] dp = new int[m+1];	// dp
		Arrays.fill(dp, 10001);
		// 화폐 단위 저장
		dp[0] = 0;
		
		int[] k = new int[n];
		for(int i=0; i<n; i++) {
			k[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<n; i++) {
			for(int j=k[i]; j<=m; j++) {
				if(dp[j-k[i]] != 10001) {
					dp[j] = Math.min(dp[j], dp[j-k[i]] + 1);
				}
			}
		}
		if(dp[m] == 10001) {
			System.out.println(-1);
		} else {
			System.out.println(dp[m]);
		}
		
		
		
	}

}
