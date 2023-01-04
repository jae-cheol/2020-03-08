package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 두수의합_3273 {

	public static void main(String[] args) throws IOException {
		// 입력
		InputStream is = System.in;						// byte
		InputStreamReader isr = new InputStreamReader(is);// character
		BufferedReader br = new BufferedReader(isr);	// String

		// 출력
		StringBuffer sb = new StringBuffer();
		
		int n = Integer.parseInt(br.readLine());	// 수열의 크기
		String[] s = br.readLine().split(" ");		// 수열에 포함되는 수
		int[] num = new int[n];
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(s[i]);
		}
		Arrays.sort(num);
		int x = Integer.parseInt(br.readLine());	// 합이되어야 하는 수

		int cnt = 0;
		
		int left = 0;
		int right = n-1;
		while(left < right) {
			if(x == num[left] + num[right]) {
				cnt++;
				right--;
				left++;
			} else if(x > num[left] + num[right]) {
				left++;
			} else {
				right--;
			}
		}
		sb.append(cnt);
		System.out.println(sb.toString());
	}

}
