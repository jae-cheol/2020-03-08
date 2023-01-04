package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 부분합_1806 {

	public static void main(String[] args) throws IOException {
		// 입력
		InputStream is = System.in;						// byte
		InputStreamReader isr = new InputStreamReader(is);// character
		BufferedReader br = new BufferedReader(isr);	// String

		// 출력
		StringBuffer sb = new StringBuffer();
		
		String[] s1 = br.readLine().split(" ");
		int n = Integer.parseInt(s1[0]);	// 수열의 길이
		int s = Integer.parseInt(s1[1]);	// 최소 부분합
		String[] s2 = br.readLine().split(" ");		// 수열에 포함되는 수
		int[] num = new int[n];
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(s2[i]);
		}
		
		int ans = 100000;
		int sum = 0;
		
		int pointer1 = 0;
		int pointer2 = 0;
		
		while(true) {
			if(pointer2 == n && sum<s) break;
			
			if(sum < s) {
				sum += num[pointer2++];
			} else if(sum >= s) {
				ans = Math.min(ans, (pointer2-pointer1));
				sum -= num[pointer1++];
			}
		}
		if(ans == 100000) {
			System.out.println("0");
		} else {
			System.out.println(ans);
		}

	}

}
