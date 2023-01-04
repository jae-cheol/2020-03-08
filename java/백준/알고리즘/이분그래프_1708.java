package 알고리즘;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * 문제
 *  그래프의 정점의 집합을 둘로 분할하여, 각 집합에 속한 정점끼리는 서로 인접하지 않도록 분할할 수 있을 때, 
 *  그러한 그래프를 특별히 이분 그래프 (Bipartite Graph) 라 부른다.
 *  그래프가 입력으로 주어졌을 때, 이 그래프가 이분 그래프인지 아닌지 판별하는 프로그램을 작성하시오.
 * 입력
 *  입력은 여러 개의 테스트 케이스로 구성되어 있는데, 첫째 줄에 테스트 케이스의 개수 K(2≤K≤5)가 주어진다. 
 *  각 테스트 케이스의 첫째 줄에는 그래프의 정점의 개수 V(1≤V≤20,000)와 간선의 개수 E(1≤E≤200,000)가 빈 칸을 사이에 두고 순서대로 주어진다. 
 *  각 정점에는 1부터 V까지 차례로 번호가 붙어 있다. 이어서 둘째 줄부터 E개의 줄에 걸쳐 간선에 대한 정보가 주어지는데, 
 *  각 줄에 인접한 두 정점의 번호가 빈 칸을 사이에 두고 주어진다.
 * 출력
 *  K개의 줄에 걸쳐 입력으로 주어진 그래프가 이분 그래프이면 YES, 아니면 NO를 순서대로 출력한다.
ex)
2
3 2
1 3
2 3
4 4
1 2
2 3
3 4
4 2
=>	YES
	NO
 */
public class 이분그래프_1708 {
	public static int[] group;	// 속하지않음:0 , 1번그룹:1 , 2번그룹:-1
	public static List<ArrayList<Integer>> graph;
	public static String ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int K = sc.nextInt();	// 테스트 케이스의 개수
		
		for (int i = 0; i < K; i++) {
			ans = "YES";
			int V = sc.nextInt();	// 정점의 개수
			int E = sc.nextInt();	// 간선의 개수
			
			graph = new ArrayList<ArrayList<Integer>>();
			
			for (int j = 0; j < V; j++) {
				graph.add(new ArrayList<Integer>());
			}
			for (int j = 0; j < E; j++) {
				int A = sc.nextInt()-1;
				int B = sc.nextInt()-1;
				
				graph.get(A).add(B);
				graph.get(B).add(A);
			}
			group = new int[V];
			for (int j = 0; j < V; j++) {
				if(group[j] == 0) {
					if(!bfs(j)) break;
				}
			}
			
			System.out.println(ans);
		}
	}

	public static boolean bfs(int n) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(n);
		group[n] = 1;
		
		while(q.peek() != null) {
			int poll = q.poll();
			
			for(int i : graph.get(poll)) {
				if(group[poll] == group[i]) {
					//인접한 곳이 나와 같은 group인지 체크
					ans = "NO";
					return false;
				}
				if(group[i] == 0) {
					//방문하지 않았으면 자신과 반대되는 group을 넣는다.
					group[i] = group[poll]*-1;
					q.offer(i);
				}
			}
		}
		
		return true;
	}
}
