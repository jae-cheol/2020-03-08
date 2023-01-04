package 수학;

import java.util.Scanner;

/**
 * 문제
 *  땅 위에 달팽이가 있다. 이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.
 *  달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다. 또, 정상에 올라간 후에는 미끄러지지 않는다.
 *  달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.
 * 입력
 *  첫째 줄에 세 정수 A, B, V가 공백으로 구분되어서 주어진다. (1 ≤ B < A ≤ V ≤ 1,000,000,000)
 * 출력
 *  첫째 줄에 달팽이가 나무 막대를 모두 올라가는데 며칠이 걸리는지 출력한다.
ex1) 2 1 5
=>	4
ex2) 5 1 6
=> 2
ex3) 100 99 1000000000
=> 999999901
 */
public class 달팽이는올라가고싶다_2869 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();	// 낮에 오르는 길이
		int b = sc.nextInt();	// 밤에 미끄러지는 길이
		int v = sc.nextInt();	// 나무막대의 높이
		
		int sum = 0;
		int ans = 0;
		while(true) {
			ans++;
			sum += a - b;
			if(sum + b >= v) {
				break;
			}
		}
		System.out.println(ans);
	}
}
