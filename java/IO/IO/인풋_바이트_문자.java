package IO;

import java.io.InputStream;
import java.io.InputStreamReader;
/*
 * System.in			: 키보드 입력.
 * InputStream			: 바이트 형태로 입력을 받음.
 * InputStreamReader	: 문자로 입력을 받음.
 * 
 * read(byte[] b) 메소드는 한꺼번에 원하는 양을 읽음.
 */
public class 인풋_바이트_문자 {
	public static void main(String[] args) {
		System.out.println("입력을 하시오. 종료는 ctrl+z를 입력하시오");
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		try {
			char[] chars = new char[100]; // 배열의 크기만큼만 읽어 들임.
			while(true) {
				int c = isr.read(chars); // 입력된 키의 문자 값을 read()로 읽음.
				// int c = is.read(); // 한 바이트만 읽어들임. - 0~255까지 사용.
				if(c == -1) break;
				System.out.println(chars);
				// System.out.print((char)c);
			}
		} catch (Exception e) {e.printStackTrace();}
	}
}