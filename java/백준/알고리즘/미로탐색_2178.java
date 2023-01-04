package 알고리즘;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * 문제
 *  N×M크기의 배열로 표현되는 미로가 있다.
 *  1	0	1	1	1	1
 *  1	0	1	0	1	0
 *  1	0	1	0	1	1
 *  1	1	1	0	1	1
 *  미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
 *  위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
 * 입력
 *  첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.
 * 출력
 *  첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.
ex1)
4 6
101111
101010
101011
111011
=>	15
ex2)
4 6
110110
110110
111111
111101
=>	9
 */
public class 미로탐색_2178 {
	static int[][] search = {{0,1}, {-1,0}, {0,-1}, {1,0}};	// 오,아래,왼,위
	static int n = 0;	// 입력:행
	static int m = 0;	// 입력:열
	static int[][] maze;		// 미로
	static boolean[][] checked;	// 방문체크
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();	// 행
		m = sc.nextInt();	// 열
		checked = new boolean[n+1][m+1];	// 방문체크
		maze = new int[n+1][m+1];	// 미로
		for(int i=1; i<=n; i++) {
			String s = sc.next();
			for(int j=1; j<=m; j++) {
				maze[i][j] = Integer.parseInt(String.valueOf(s.charAt(j-1)));
			}
		}
		
		// 문제풀이
		bfs();
	}
	
	public static void bfs() {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(1,1,1));
		checked[1][1] = true;
		
		while(q.peek() != null) {
			Point p = q.poll();
			int pX = p.x;
			int pY = p.y;
			int pCnt = p.cnt;
			
			// 정답 출력
			if(pX == n && pY == m) {
				System.out.println(pCnt);
				return;
			}
			
			for(int i=0; i<4; i++) {
				int nx = pX + search[i][0]; 
				int ny = pY + search[i][1];
				if(nx>0 && ny>0 && nx<=n && ny<=m) {
					if(maze[nx][ny] == 1 && !checked[nx][ny]) {
						q.offer(new Point(nx, ny, pCnt+1));
						checked[nx][ny] = true;
					}
				}
			}
		}
	}

}
