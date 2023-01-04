package 스트링;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 진수_1373 {

	public static void main(String[] args) throws IOException {
		// 입력
		InputStream is = System.in;						// byte
		InputStreamReader isr = new InputStreamReader(is);// character
		BufferedReader br = new BufferedReader(isr);	// String

		// 출력
		StringBuffer sb = new StringBuffer();

		String binaryNumber = br.readLine();	// 2진수
		int len = binaryNumber.length();	// 길이

		// 길이
		while(len%3 != 0) {
			binaryNumber = "0" + binaryNumber;
			len = binaryNumber.length();
		}

		int i = -3;
		int j = 0;
		String ans = "";
		String octalNumber = "";
		int a=0, b=0, c=0;
		while(j != len) {
			i += 3;
			j += 3;
			octalNumber = binaryNumber.substring(i, j);
			a = Integer.parseInt(octalNumber.substring(0, 1)) * 2*2;
			b = Integer.parseInt(octalNumber.substring(1, 2)) * 2;
			c = Integer.parseInt(octalNumber.substring(2, 3));
			ans = ans + String.valueOf(a+b+c);
		}
		sb.append(ans);
		
		System.out.println(sb.toString());
	}
}
