package 알고리즘;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 문제
 *  보물섬 지도를 발견한 후크 선장은 보물을 찾아나섰다. 보물섬 지도는 아래 그림과 같이 직사각형 모양이며 여러 칸으로 나뉘어져 있다. 
 *  각 칸은 육지(L)나 바다(W)로 표시되어 있다. 이 지도에서 이동은 상하좌우로 이웃한 육지로만 가능하며, 한 칸 이동하는데 한 시간이 걸린다. 
 *  보물은 서로 간에 최단 거리로 이동하는데 있어 가장 긴 시간이 걸리는 육지 두 곳에 나뉘어 묻혀있다. 
 *  육지를 나타내는 두 곳 사이를 최단 거리로 이동하려면 같은 곳을 두 번 이상 지나가거나, 멀리 돌아가서는 안 된다.
 *  예를 들어 위와 같이 지도가 주어졌다면 보물은 아래 표시된 두 곳에 묻혀 있게 되고, 이 둘 사이의 최단 거리로 이동하는 시간은 8시간이 된다.
 *  보물 지도가 주어질 때, 보물이 묻혀 있는 두 곳 간의 최단 거리로 이동하는 시간을 구하는 프로그램을 작성하시오.
 * 입력
 *  첫째 줄에는 보물 지도의 세로의 크기와 가로의 크기가 빈칸을 사이에 두고 주어진다. 이어 L과 W로 표시된 보물 지도가 아래의 예와 같이 주어지며, 
 *  각 문자 사이에는 빈 칸이 없다. 보물 지도의 가로, 세로의 크기는 각각 50이하이다.
 * 출력
 *  첫째 줄에 보물이 묻혀 있는 두 곳 사이를 최단 거리로 이동하는 시간을 출력한다.
ex)
5 7
WLLWWWL
LLLWLLL
LWLWLWW
LWLWLLL
WLLWLWW
=>	8
ex)
7 7
WLLLLLW
LWLWLWW
LLLWLWW
LWWWLWW
LLLLLWW
LWWWWWW
WWWWWWW
=>	10
ex)
2 2
LL
LL
=>	2
ex)
7 7
LWWWWWW
WLLLWWW
WLLLWWW
WLLLWWW
WWWWLLW
WLLLLLW
WLLWWWL
=>	6
 */

public class 보물섬_2589 {
	static int[] x = {1,-1,0,0};// x좌표 : 오 왼 아래 위
	static int[] y = {0,0,1,-1};// y좌표 : 오 왼 아래 위
	static int height;			// 세로
	static int width;			// 가로
	static String[][] earth;	// L:땅 , W:물
	static boolean[][] checked;	// 방문지점 체크
	static int[][] depth;		// 최단거리
	static int ans = 0;			// 정답
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		height = sc.nextInt();	// 세로
		width = sc.nextInt();	// 가로
		
		// 초기화
		earth = new String[height+1][width+1];
		
		String s = "";	// 입력:한줄
		String c = "";	// 한줄에 입력된 한문자
//		int cnt = 0;
		for(int i=1; i<=height; i++) {
			s = sc.next();
			for(int j=1; j<=width; j++) {
				c = String.valueOf(s.charAt(j-1));
				earth[i][j] = c;
//				if("L".equals(c)) {
//					cnt++;
//				}
			}
		}
		
		// 입력값 출력 테스트
//		for(int i=1; i<=height; i++) {
//			for(int j=1; j<=width; j++) {
//				System.out.print(earth[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println("cnt : " + cnt);
		

		// 문제풀이
		for(int i=1; i<=height; i++) {		// 5
			for(int j=1; j<=width; j++) {	// 7
				if("L".equals(earth[i][j])) {
					// 초기화
					checked = new boolean[height+1][width+1];
					depth = new int[height+1][width+1];
					
					bfs(earth[i][j], i, j);
//					for(int k=1; k<=height; k++) {		// 5
//						for(int l=1; l<=width; l++) {	// 7
//							System.out.print(depth[k][l]);
//						}
//						System.out.println();
//					}
//					System.out.println();
				}
			}
		}
		
		// 정답
		System.out.println(ans);
	}
	
	public static void bfs(String start, int yy, int xx) {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(yy, xx));
		checked[yy][xx] = true;
		
		while(q.peek() != null) {
			int yyy = q.peek().x;
			int xxx = q.peek().y;
			q.poll();
			
			for(int i=0; i<4; i++) {
				int ny = yyy + y[i];	// 행 : y좌표 : 5
				int nx = xxx + x[i];	// 열 : x좌표 : 7
				if(nx>0 && ny>0 && nx<=width && ny<=height) {
					if("L".equals(earth[ny][nx]) && !checked[ny][nx]) {
						checked[ny][nx] = true;
						q.offer(new Point(ny, nx));
						
						// 최단거리
						depth[ny][nx] = depth[yyy][xxx] + 1;

						// 정답 저장.
						if(depth[ny][nx] > ans) {
							ans = depth[ny][nx];
						}
					}
				}
			}
		}
	}
}
