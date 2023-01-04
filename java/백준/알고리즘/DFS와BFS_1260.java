package 알고리즘;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * 문제
 *  그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
 *  단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다.
 *  정점 번호는 1번부터 N번까지이다.
 * 입력
 *  첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다.
 *  다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다.
 *  입력으로 주어지는 간선은 양방향이다.
 * 출력
 *  첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
ex1)
4 5 1
1 2
1 3
1 4
2 4
3 4
=>	1 2 4 3
	1 2 3 4

ex2)
5 5 3
5 4
5 2
1 2
3 4
3 1
=>	3 1 2 5 4
	3 1 4 2 5

ex3)
1000 1 1000
999 1000
=>	1000 999
	1000 999
 */
public class DFS와BFS_1260 {
	static int n = 0;	// 정점
	static int m = 0;	// 간선
	static int v = 0;	// 탐색시작번호
	static boolean[][] line = new boolean[1001][1001];
	static boolean[] checked = new boolean[1001];
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		v = sc.nextInt();
		
		// 간선의 갯수만큼 2번째줄부터 입력받는 정점을 연결하는 간선을 연결. => 연결된 간선은 true.
		for(int i=1; i<=m; i++) {
			int line1 = sc.nextInt();
			int line2 = sc.nextInt();
			line[line1][line2] = line[line2][line1] = true;
		}
		dfs(v);
		System.out.println();
		checked = new boolean[1001];
		bfs();
	}
	
	public static void dfs(int start) {
		checked[start] = true;
		System.out.print(start + " ");
		
		// 정점의수만큼 반복하면서 체크한다. ,, 1부터체크하는이유:정점번호가작은것부터방문하기위해
		for(int i=1; i<=n; i++) {
			if(line[start][i] && !checked[i]) {
				dfs(i);
			}
		}
	}
	
	public static void bfs() {
		/**
		 * poll은 큐에서 꺼내서 없어짐.
		 * peek은 큐를 검사만 함.
		 */
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(v);
		checked[v] = true;
		System.out.print(v + " ");
		while(q.peek() != null) {
			int j = q.poll();
			for(int i=1; i<=n; i++) {
				if(line[j][i] && !checked[i]) {
					q.offer(i);
					checked[i] = true;
					System.out.print(i + " ");
				}
			}
		}
	}
}
