package 알고리즘;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 문제
 *  철수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다. 
 *  토마토는 아래의 그림과 같이 격자 모양 상자의 칸에 하나씩 넣어서 창고에 보관한다. 
 *  창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 
 *  보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다. 
 *  하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다. 
 *  대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 
 *  철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.
 *  토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때, 
 *  며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
 * 입력
 *  첫 줄에는 상자의 크기를 나타내는 두 정수 M,N이 주어진다. M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수를 나타낸다. 
 *  단, 2 ≤ M,N ≤ 1,000 이다. 둘째 줄부터는 하나의 상자에 저장된 토마토들의 정보가 주어진다. 
 *  즉, 둘째 줄부터 N개의 줄에는 상자에 담긴 토마토의 정보가 주어진다. 하나의 줄에는 상자 가로줄에 들어있는 토마토의 상태가 M개의 정수로 주어진다. 
 *  정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.
 *  토마토가 하나 이상 있는 경우만 입력으로 주어진다.
 * 출력
 *  여러분은 토마토가 모두 익을 때까지의 최소 날짜를 출력해야 한다. 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 
 *  토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.
ex1)
6 4
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 1
=>	8
ex2)
6 4
0 -1 0 0 0 0
-1 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 1
=> -1
ex3)
6 4
1 -1 0 0 0 0
0 -1 0 0 0 0
0 0 0 0 -1 0
0 0 0 0 -1 1
=>	6
 */
public class 토마토_7576 {
	static int[][] search = {{0,1}, {1,0}, {0,-1}, {-1,0}};	// 오,아래,왼,위
	static int m = 0;	// 열
	static int n = 0;	// 행
	static int[][] tomatoBox;
	static boolean[][] checked;
	static int[][] depth;
	static int ans = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();	// 열
		n = sc.nextInt();	// 행
		
		tomatoBox = new int[n+1][m+1];
		checked = new boolean[n+1][m+1];
		depth = new int[n+1][m+1];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				tomatoBox[i][j] = sc.nextInt();
			}
		}

		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(tomatoBox[i][j] == 1 && !checked[i][j]) {
					bfs(i, j);	
				}
			}
		}

		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(!checked[i][j] && tomatoBox[i][j] == 0) {
					System.out.println("-1");
					return;
				}
			}
		}
		System.out.println(ans);
	}
	
	public static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(x, y, 0));
		checked[x][y] = true;
		depth[x][y] = 0;
		
		while(q.peek() != null) {
			Point p = q.poll();
			int pX = p.x;
			int pY = p.y;
			int pCnt = p.cnt;
			for(int i=0; i<4; i++) {
				int nx = pX + search[i][0];
				int ny = pY + search[i][1];
				if(nx>0 && ny>0 && nx<=n && ny<=m) {
					if(tomatoBox[nx][ny] == 0 && !checked[nx][ny]) {
						checked[nx][ny] = true;
						// 기존이 최단거리라면, 기존으로 세팅.
						if(depth[nx][ny] < pCnt) {
							q.offer(new Point(nx, ny, depth[nx][ny]));
							ans = depth[nx][ny];
						}
						// 기존이 최단거리가 아니라면, +1.
						else {
							q.offer(new Point(nx, ny, pCnt+1));
							depth[nx][ny] = depth[nx][ny] + 1;
							ans = depth[nx][ny];
						}
					}
				}
			}
		}
	}
}
