package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 두용액_2470 {

	public static void main(String[] args) throws IOException {
		// 입력
		InputStream is = System.in;						// byte
		InputStreamReader isr = new InputStreamReader(is);// character
		BufferedReader br = new BufferedReader(isr);	// String

		// 출력
		StringBuffer sb = new StringBuffer();
		
		int n = Integer.parseInt(br.readLine());	// 용액의 개수
		String[] s = br.readLine().split(" ");		// 용액의 특성값
		int[] num = new int[n];
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(s[i]);
		}
		Arrays.sort(num);

		int ans = 2000000000;
		int sum = 0;
		int left = 0;
		int right = n-1;
		int ans1 = 0;
		int ans2 = 0;
		while(left < right) {
			sum = num[left] + num[right];
			if(Math.abs(sum) < ans) {
				ans = Math.abs(sum);
				ans1 = num[left];
				ans2 = num[right];	
			}
			
			if(0 > sum) {
				left++;
			} else if(0 < sum) {
				right--;
			} else {
				break;
			}
		}
		sb.append(ans1);
		sb.append(" ");
		sb.append(ans2);
		System.out.println(sb.toString());
	}

}
