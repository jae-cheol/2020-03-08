package 비트교육센터;
/**
 * char의 초기화는 ' ' 공백으로 초기화 해줘야한다.
 *
 */
public class prob1 {

	public static void main(String[] args) {
//		System.out.println(length);
		String number = "";
		int length = 0;
		char c = ' ';
		for(int i=1; i<100; i++) {
			if(i%10 == 3 || i%10 == 6 || i%10 == 9 || i/10 == 3 || i/10 == 6 || i/10 == 9 ) {
				System.out.print(i + " ");	
			}
			number = String.valueOf( i );
			length = number.length();
			for(int j=0; j<length; j++) {
				c = number.charAt( j );
				if(c > 48 && c%3 == 0) {
					System.out.print("짝");
				}
			}
			if(i%10 == 3 || i%10 == 6 || i%10 == 9 || i/10 == 3 || i/10 == 6 || i/10 == 9 ) {
				System.out.println();
			}
		}
	}

}

/**
 * 문제1. 반복문을 이용하여 369게임에서 박수를 쳐야 하는 경우의 수를 순서대로 화면에 출력해보세요.
 * 
 * 실행 결과:  
 * 3 짝 
 * 6 짝 
 * 9 짝 
 * 13 짝 
 * 16 짝 
 * 19 짝 
 * 23 짝 
 * 26 짝 
 * 29 짝 
 * 30 짝 
 * 31 짝 
 * 32 짝 
 * 33 짝짝
 * 
 * 문제 설명 : 1부터 99까지만 실행하세요. 
 * 
 * 문제 힌트 및 제한 :   
 * 1.각 수를 문자열로 다루어야 합니다. 정수를 String으로 바꾸기 위해 다음코드를 사용합니다. 
 * String number = String.valueOf( 369 );
 * 
 * 2.바꾼 String의 길이를 구해서 loop를 돌아야 합니다. 길이는 다음과 같이 구합니다.
 * int length = number.length();
 * 
 * 3.loop 에서 각각의 위치의 문자(숫자)가 ‘3’, ‘6’, ‘9’인지 확인하고 카운트를 셉니다. 
 * 이를 위해 다음 코드를 사용합니다.
 * char c = number.charAt( i );
 */