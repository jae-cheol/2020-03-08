package prob1;

public class Q1 {
	public static void main(String[] args) {
		for(int i=1; i<=99; i++) {
			if(i%3 == 0) {
				System.out.println(i + " 짝");
			}
		}
	}
}

/*
 * String 관련 함수들을 먼저 알아야 됨.
 * 
 * 수를 문자열로 다루기 위해
 * String number = String.valueOf(369);
 * 
 * 문자열의 길이를 구하기 위해
 * int length = number.length();
 * 
 * 카운트를 세기 위해
 * char o = number.charAt(i);
 * 
 */