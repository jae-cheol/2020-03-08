package 스트링;

import java.util.Arrays;
/*
 * substring(~)		: ~부분부터 짜르기.
 * substring(~,~)	: ~부터 ~까지 짜르기.
 * concat()			: 연결
 * replace(~,~)		: ~를 ~로 변경
 * trim()			: 양 옆 공백을 제거.
 * toUpperCase()	: 대문자로 변경
 * toLowerCase()	: 소문자로 변경
 * split()			: 해당 문자를 기준으로 자름.
 */
public class StringMain02 {

	public static void main(String[] args) {
		
		String str = "Hello world";
		
//		String sub = str.substring(3, 7);
		// 같은표현
//		sub = str.substring(3, str.length());
		String sub = str.substring(2);
		System.out.println("substring() : " + sub);

//		str = str + "!!!";
		str = str.concat("!!!");
		System.out.println("concat() : " + str);


		String result = str.replace('o', 'p');
		System.out.println("replace() : " + result);
		result = str.replace("ll", "rrRRRRR");
		System.out.println("replace() : " + result);
		
//		str = "       hello       ";
		str = "       Hello World         ";
		System.out.println(str);
		System.out.println("trim전 str의 길이 : " + str.length());
		
		str = str.trim();
		System.out.println("trim()후 str : [" + str + "], 길이 : " + str.length());
		
		System.out.println("str : " + str);
		System.out.println("toUpperCase() : " + str.toUpperCase());
		System.out.println("toLowerCase() : " + str.toLowerCase());
		System.out.println("str : " + str);
		
		str = "홍길동전:허균:조선시대";
		String[] strArr = str.split(":");
		System.out.println("split() : " + Arrays.toString(strArr));

//		int idx = str.indexOf(':');
//		String title = str.substring(0, idx);
//		
//		int idx2 = str.indexOf(":", idx+1);
//		String author = str.substring(idx+1, idx2);
//		
//		String date = str.substring(idx2+1);
//		System.out.println(title + ", " + author + ", " + date);
		
		int num = 123;
		System.out.println(String.valueOf(num) + 100);
		
		char[] chars = {'A', 'B', 'C', 'D'};
		System.out.println(String.valueOf(chars));
	}
}