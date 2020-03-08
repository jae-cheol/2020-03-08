package 스트링;
import java.util.Scanner;
/*
 * 18.05.27
 * 입력값 들... 예시
3
config.sys
configures
config.inf

3
config.sys
configures
config.ins

2
aa
ba

3
aaa
aba
aca

1
a

3
aaa
bab
bbb

2
aaaaa
ababa
 */
public class Sb_1032 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();		// 입력할 문자 갯수.
		String[] aString = new String[num];
		for(int i=0; i<num; i++) {
			aString[i] = sc.next();	// 입력한 문자들.
		}
		
		int nlength = aString[0].length();	// 입력한 문자 길이.
		
		StringBuilder s = new StringBuilder(aString[0]);// 입력길이에 맞는 임시문자열. 
		
		String[][] aStr = new String[num][nlength];	// 입력 받는 String 각각의 값.
		
		for(int i=0; i<num; i++) {
			for(int j=0; j<nlength; j++) {
				aStr[i][j] = String.valueOf(aString[i].charAt(j));
			}
		}
		
		for(int i=1; i<num; i++) {
			for(int j=0; j<nlength; j++) {
//				System.out.println("i : " + i);
//				System.out.println("j : " + j);
//				System.out.println("aStr[0][j] : " + aStr[0][j]);
//				System.out.println("aStr[i][j] : " + aStr[i][j]);
				if( !aStr[0][j].equals(aStr[i][j]) ) {	// 기준은 첫번째 입력한 문자열.
					s.replace(j, j+1, "?");
//					System.out.println(s);
				}
			}
		}
		System.out.println(s);
	}
}