package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 배열합치기_11728 {

	public static void main(String[] args) throws IOException {
		// 입력
		InputStream is = System.in;						// byte
		InputStreamReader isr = new InputStreamReader(is);// character
		BufferedReader br = new BufferedReader(isr);	// String

		// 출력
		StringBuffer sb = new StringBuffer();

		String[] s1 = br.readLine().split(" ");
		String[] s2 = br.readLine().split(" ");	// 1번째 배열
		String[] s3 = br.readLine().split(" ");	// 2번째 배열
		String[] concate = new String[s2.length + s3.length];
		System.arraycopy(s2, 0, concate, 0, s2.length);
		System.arraycopy(s3, 0, concate, s2.length, s3.length);
		
		int[] numArr = new int[concate.length];
		for(int i=0; i<concate.length; i++) {
			numArr[i] = Integer.parseInt(concate[i]);
		}
		Arrays.sort(numArr);
		
		for(int i : numArr) {
			sb.append(i);
			sb.append(" ");
		}
		System.out.println(sb.toString());
	}

}
