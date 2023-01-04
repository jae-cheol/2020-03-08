package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AB6_10953 {

	public static void main(String[] args) throws IOException {
		// 입력
		InputStream is = System.in;						// byte
		InputStreamReader isr = new InputStreamReader(is);// character
		BufferedReader br = new BufferedReader(isr);	// String

		// 출력
		StringBuffer sb = new StringBuffer();
		
		int t = Integer.parseInt(br.readLine());	// 테스트 케이스의 개수
		for(int i=0; i<t; i++) {
			String[] s = br.readLine().split(",");		// A,B
			int[] num = new int[t];
			for(int j=0; j<2; j++) {
				num[j] = Integer.parseInt(s[j]);
			}
			sb.append(num[0] + num[1]);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
