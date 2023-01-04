package 수학;

import java.util.Scanner;

/**
 * 문제
 *  무한히 큰 배열에 다음과 같이 분수들이 적혀있다.
 *  1/1	1/2	1/3	1/4	1/5	…
 *  2/1	2/2	2/3	2/4	…	…
 *  3/1	3/2	3/3	…	…	…
 *  4/1	4/2	…	…	…	…
 *  5/1	…	…	…	…	…
 *  …	…	…	…	…	…
 *  이와 같이 나열된 분수들을 1/1 -> 1/2 -> 2/1 -> 3/1 -> 2/2 -> … 과 같은 지그재그 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.
 *  X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.
 * 입력
 *  첫째 줄에 X(1 ≤ X ≤ 10,000,000)가 주어진다.
 * 출력
 *  첫째 줄에 분수를 출력한다.
ex)14
=>	2/4
 */
public class 분수찾기_1193 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();

		int line = 0;
		int cnt = 0;
		while(cnt < x) {
			line++;
			cnt = line*(line+1)/2;	// *등차수열 n(n+1)/2 : n번째 까지 항의 개수
		}

		int top = 1 + (cnt-x);
		int bottom = line - (cnt-x);
		if(line%2 != 0) {
			System.out.println(top+"/"+bottom);
		} else {
			System.out.println(bottom+"/"+top);
		}
		
	}

}
