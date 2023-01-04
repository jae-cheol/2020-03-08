package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class _1로만들기 {

	public static void main(String[] args) throws IOException {
		InputStream is = System.in;						// 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr);	// 스트링
		int x = Integer.parseInt(br.readLine());
		
		int[] d = new int[30];
		
		for(int i=2; i<=x; i++) {
			d[i] = d[i-1] + 1;
			if(i%2 == 0) {
				d[i] = Math.min(d[i], d[i/2]+1);
			}
			if(i%3 == 0) {
				d[i] = Math.min(d[i], d[i/3]+1);
			}
			if(i%5 == 0) {
				d[i] = Math.min(d[i], d[i/5]+1);
			}
		}
		System.out.println(d[x]);
	}

}
