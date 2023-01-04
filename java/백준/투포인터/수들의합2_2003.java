package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 수들의합2_2003 {

	public static void main(String[] args) throws IOException {
		// 입력
		InputStream is = System.in;						// byte
		InputStreamReader isr = new InputStreamReader(is);// character
		BufferedReader br = new BufferedReader(isr);	// String

		// 출력
		StringBuffer sb = new StringBuffer();

		String[] s1 = br.readLine().split(" ");
		int n = Integer.parseInt(s1[0]);	// 수열의 크기
		int m = Integer.parseInt(s1[1]);	// 합이되어야 하는 수
		String[] s2 = br.readLine().split(" ");		// 수열에 포함되는 수
		int[] num = new int[n];
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(s2[i]);
		}
		int len = num.length;

		int sum = 0;
		int cnt = 0;
		
		int pointer1 = 0;
		int pointer2 = 0;
		while(true) {
			if(sum < m) {
				if(pointer2 == len) break;
				sum += num[pointer2++];
			} else if(sum > m) {
				sum -= num[pointer1++];
			} else if(sum == m) {
				cnt++;
				sum -= num[pointer1++];
			}
		}
		sb.append(cnt);
		System.out.println(sb.toString());
	}

}
