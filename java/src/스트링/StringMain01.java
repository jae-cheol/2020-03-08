package 스트링;

import java.util.Arrays;
/*
 * int = char + char
 * substring()					: 찾는값의 위치까지 짜름.
 * str1.equals(str2)			: str1, str2의 대소문자까지 전부 싹 다 똑같은지 비교.
 *     .equalsIgnoreCase(str2)	: 			  대소문자를 무시하고 비교.
 * str3.lastIndexOf('u')		: str3에서 뒤에서부터 'u'를 찾아서 찾는값의 위치를 int형으로 리턴함.(첫자리 0부터 시작), 찾는값이 없으면 -1 리턴.
 *     .indexOf()				:
 *     .indexOf('l', 4)			:        앞에서부터 'l'을 찾는데 4번째위치부터 찾음.
 */
public class StringMain01 {
	public static void main(String[] args) {
		
		// char형은 연산하면 자동으로 int로 됨. 
		char ch = 'd';
		System.out.print(ch + " ");
		char ch2 = 'a';
		System.out.print(ch2 + " ");
		char d1 = (char)(ch+ch2);	// char의 범위를 벗어남.
		System.out.print(d1 + " ");
		int d2 = ch+ch2;	// char의 연산은 int형이 됨.
		System.out.println(d2);

		// 다 똑같은 출력
		String str = new String("ABCDE");
		str = new String(new char[] {'A', 'B', 'C', 'D', 'E'});
		str = new String(new byte[] {65, 66, 67, 68, 69});

		char[] temp = {'a','b', 'c', 'A', 'B', 'C', 'D', 'E', 'F'};
		str = new String(temp, 2, 5); // temp에서 0,1,2번째부터 ~ 5개 , cABCD

		char[] chars = new char[str.length()]; // str의 길이만큼(5개짜리) char배열 생성.
		// 문자열을 char배열에 복사
		str.getChars(1, 4, chars, 2); // str의 0,1번째부터 ~ 4번째까지를(ABCD) chars의 0,1,2번째에다가 넣는다. 뒤에껀 짤린다.
		System.out.println("chars : " + Arrays.toString(chars));
		
		///////////////////////////////////////////////////////////////////
		
		String str1 = new String("Hello");
		String str2 = new String("hello");
		if(str1 == str2) { System.out.println("주소비교 : 같다"); }
		else { System.out.println("주소비교 : 다르다(저장된 곳이 다르기 때문에 주소도 다름.)"); }
		if(str1.equalsIgnoreCase(str2)) { System.out.println("문자열비교 : 같다"); }
		else { System.out.println("문자열비교 : 다르다"); }
		
		///////////////////////////////////////////////////////////////////
		
		String str3 = "hello world";
		int searchIdx = str3.lastIndexOf('u');
		System.out.println("searchIdx(찾는값이 없으면 -1) : " + searchIdx);
		searchIdx = str3.indexOf('l', 4);
		System.out.println("4번지이후 searchIdx : " + searchIdx + "\n");
		
		// 문자열 안에서 하나의 문자 위치를 전부 탐색.
		System.out.println("< " + str3 + "에서 l의 위치 탐색 >");
//		int idx = str3.indexOf("l");
//		while(idx != -1) {
//			System.out.println(idx);
//			idx = str3.indexOf("l", idx+1);
//		}
		int idx = -1;
		while((idx = str3.indexOf("l", idx+1)) != -1)  
			System.out.print(idx + " // ");
	}
}