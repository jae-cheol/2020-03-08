package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 금광 {

	public static void main(String[] args) throws IOException {
		InputStream is = System.in;						// 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr);	// 스트링
		int t = Integer.parseInt(br.readLine());	// 테스트 케이스
		
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<t; i++) {
			String[] s1 = br.readLine().split(" ");
			int n = Integer.parseInt(s1[0]);	// 행
			int m = Integer.parseInt(s1[1]);	// 열

			int[][] matrix = new int[n][m];
			String[] s2 = br.readLine().split(" ");
			for(int j=0; j<n; j++) {	// 행
				for(int k=0; k<m; k++) {// 열
					matrix[j][k] = Integer.parseInt(s2[j*m + k]);
				}
			}

			int sum = 0;
			for(int k=0; k<m; k++) {	// 열
				int tmp = 0;
				for(int j=0; j<n; j++) {// 행
					tmp = Math.max(tmp, matrix[j][k]);
				}
				sum += tmp;
			}
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb.toString());
		
	}

}
//2
//3 4
//1 3 3 2 2 1 4 1 0 6 4 7
//4 4
//1 3 1 5 2 2 4 1 5 0 2 3 0 6 1 2
//
//1 3 1 5
//2 2 4 1
//5 0 2 3
//0 6 1 2
