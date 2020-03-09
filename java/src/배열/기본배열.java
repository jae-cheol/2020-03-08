package 배열;

import java.util.Arrays;

public class 기본배열 {
	public static void main(String[] args) {
		//		String[] strArr = {"자바", "웹&모바일", "교육"};
		String[] strArr = new String[] {"자바", "웹&모바일", "교육"};
		
		System.out.println("< index를 이용한 배열 출력 >");
		for(int i = 0; i < strArr.length; i++) {
			System.out.print(strArr[i] + " ");
		}
		
		System.out.println("\n\n< 1.5버전의 for문을 이용한 출력 >");
		for(String str : strArr) {
			System.out.print(str + " ");
		}
		
		System.out.println("\n\n< Arrays.toString() 메소드를 이용한 출력 >");
		System.out.println(Arrays.toString(strArr)); // 기존에 있는것.
	}
}