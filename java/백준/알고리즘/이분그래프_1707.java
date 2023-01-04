//package 알고리즘;
//
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
///**
// * 문제
// *  그래프의 정점의 집합을 둘로 분할하여, 각 집합에 속한 정점끼리는 서로 인접하지 않도록 분할할 수 있을 때, 
// *  그러한 그래프를 특별히 이분 그래프 (Bipartite Graph) 라 부른다.
// *  그래프가 입력으로 주어졌을 때, 이 그래프가 이분 그래프인지 아닌지 판별하는 프로그램을 작성하시오.
// * 입력
// *  입력은 여러 개의 테스트 케이스로 구성되어 있는데, 첫째 줄에 테스트 케이스의 개수 K(2≤K≤5)가 주어진다. 
// *  각 테스트 케이스의 첫째 줄에는 그래프의 정점의 개수 V(1≤V≤20,000)와 간선의 개수 E(1≤E≤200,000)가 빈 칸을 사이에 두고 순서대로 주어진다. 
// *  각 정점에는 1부터 V까지 차례로 번호가 붙어 있다. 이어서 둘째 줄부터 E개의 줄에 걸쳐 간선에 대한 정보가 주어지는데, 
// *  각 줄에 인접한 두 정점의 번호가 빈 칸을 사이에 두고 주어진다.
// * 출력
// *  K개의 줄에 걸쳐 입력으로 주어진 그래프가 이분 그래프이면 YES, 아니면 NO를 순서대로 출력한다.
//ex)
//2
//3 2
//1 3
//2 3
//4 4
//1 2
//2 3
//3 4
//4 2
//=>	YES
//	NO
// */
//public class 이분그래프_1707 {
//	static int[][] graph;
//	static int[][][] nGraph;
//	static boolean[][] checked;
//	static boolean[][][] linked;
//	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int k = sc.nextInt();	// 테스트 케이스의 개수.
//		graph = new int[k][k];	// 테스트 케이스의 정점과 간선의 개수.
//		nGraph = new int[k][200000][200000];	// n번째 테스트 케이스의 연결된 간선.
//		checked = new boolean[k][20000];
//		linked = new boolean[k][20000][20000];	// 정점 연결 여부.
//		
//		for(int i=0; i<k; i++) {
//			graph[i][0] = sc.nextInt();	// i번째 테스트 케이스의 정점의 개수.
//			int e = graph[i][1] = sc.nextInt();	// i번째 테스트 케이스의 간선의 개수.
//			for(int j=0; j<e; j++) {
//				int link1 = nGraph[i][j][0] = sc.nextInt();
//				int link2 = nGraph[i][j][1] = sc.nextInt();
//				linked[i][link1][link2] = linked[i][link2][link1] = true;
//			}
//		}
//		
////		for(int i=0; i<k; i++) {
////			System.out.println(graph[i][0] + " " + graph[i][1]);
////			for(int j=0; j<graph[i][1]; j++) {
////				System.out.println(nGraph[j][0] + " " + nGraph[j][1]);
////			}
////		}
//		
//		for(int i=0; i<k; i++) {
//			bfs(i);	// i번째를 이분 그래프인지 판단.
//		}
//	}
//	
//	public static void bfs(int n) {
//		Queue<Point> q = new LinkedList<Point>();
//		q.offer(new Point(nGraph[n][0][0], "red"));
//		checked[n][0] = true;
//		
//		while(q.peek() != null) {
//			int poll = q.peek().x;
//			String bg = q.peek().bg;
//			q.poll();
//			for(int i=0; i<graph[i][0]; i++) {
//				if(linked[n][poll][i] && !checked[n][i]) {
//					checked[n][i] = true;
//					if(bg)
//					q.offer(new Point(i, "blue"));
//				}
//			}
//		}
//	}
//
//}
