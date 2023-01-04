package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class _123더하기_9095 {

	static int[] ar = new int[12];
	public static void main(String[] args) throws IOException {
		InputStream is = System.in;						// 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr);	// 스트링
		int t = Integer.parseInt(br.readLine());	// 테스트 케이스의 개수
		dp();
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());	// 정수
			sb.append(ar[n]).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	// DP
	public static void dp() {
		ar[1] = 1;
		ar[2] = 2;
		ar[3] = 4;
		for(int i=4; i<12; i++) {
			ar[i] = ar[i-1] + ar[i-2] + ar[i-3];
		}
	}
}
