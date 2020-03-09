package 배열;

import java.util.Arrays;

public class Arrays_toString메소드 {
	public static void main(String[] args) {

		// String[] strArr = {"자바", "웹&모바일", "교육"};
		String[] strArr = new String[] { "자바", "웹&모바일", "교육" };

		System.out.println("< Arrays.toString() 메소드를 이용한 출력 >");
		System.out.println(Arrays.toString(strArr)); // 기존에 있는것.
		System.out.println(arraysToString(strArr)); // 직접 만듬.
	}

	static String arraysToString(String[] strArr) { // 인자로 넘어온 배열
		String str = "[";
		for (int i = 0; i < strArr.length; i++) {
			str += strArr[i];
			if (i != strArr.length - 1)
				str += ", ";
		}
		str += "]";

		return str; // String 타입 함수이므로 리턴도 String형태를 넘겨줌.
	}
}
