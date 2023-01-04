package 알고리즘;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 문제
 *  수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 
 *  수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 
 *  순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
 *  수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
 * 입력
 *  첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.
 * 출력
 *  수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
ex) 5 17
=>	4
 */
public class 숨바꼭질_1697 {
	static int time = 0;
	static boolean[] checked;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		// 초기화
		checked = new boolean[100001];
		
		bfs(n, k);
		System.out.println(time);
	}
	
	public static void bfs(int x, int y) {
		checked[x] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(x);
		while(q.peek() != null) {
			int size = q.size();
			boolean escape = false;
			// 1,3,9,27... (체크된것 제외 1,3,7,10,16...)
			for(int i=0; i<size; i++) {
				int tmp = q.poll();
				if(tmp == y) {
					escape = true;
					break;
				}
				
				if(tmp > 0 && !checked[tmp-1]) {
					checked[tmp-1] = true;
					q.offer(tmp-1);
				}
				if(tmp < 100000 && !checked[tmp+1]) {
					checked[tmp+1] = true;
					q.offer(tmp+1);
				}
				if(tmp < 50001 && !checked[tmp*2]) {
					checked[tmp*2] = true;
					q.offer(tmp*2);
				}
			}
			if(escape) break;
			time++;
		}
	}
}