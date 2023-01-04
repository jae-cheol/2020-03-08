package 스트링;

import java.util.Scanner;

/**
 * 문제
 *  그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다. 예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, 
 *  kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만, aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
 *  단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.
 * 입력
 *  첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 단어가 들어온다. 
 *  단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.
 * 출력
 *  첫째 줄에 그룹 단어의 개수를 출력한다.
ex1)
3
happy
new
year
=> 3
ex2) 
4
aba
abab
abcabc
a
=> 1
 */
public class 그룹단어체커_1316 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		String[] sArr = new String[n];
		for(int i=0; i<n; i++) {
			sArr[i] = sc.next();
		}
		
		int ans = 0;
		for(int i=0; i<n; i++) {
			if(check(sArr[i])) {
				ans++;
			}
		}
		System.out.println(ans);
	}
	
	public static boolean check(String s) {
		// 26개의 알파벳 체크
		boolean[] alphabetCheck = new boolean[26];
		// 앞선 문자와 연속되는지 판별
		int prev = 0;
		
		String str = s;
		
		// 반복:문자열의 길이만큼
		for(int i=0; i<str.length(); i++) {
			int now = str.charAt(i);
			
			// 해당 문자가 중복된 문자인지 여부 검사
			if(prev != now) {
				// 해당 문자가 처음 나오는 경우
				if(!alphabetCheck[now-'a']) {
					alphabetCheck[now-'a'] = true;
					prev = now;
				} else {
					return false;
				}
			}
		}
		
		return true;
	}
}
