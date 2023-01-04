package 알고리즘;

import java.util.Scanner;

/**
 * 문제
 *  차세대 영농인 한나는 강원도 고랭지에서 유기농 배추를 재배하기로 하였다. 
 *  농약을 쓰지 않고 배추를 재배하려면 배추를 해충으로부터 보호하는 것이 중요하기 때문에, 
 *  한나는 해충 방지에 효과적인 배추흰지렁이를 구입하기로 결심한다. 
 *  이 지렁이는 배추근처에 서식하며 해충을 잡아 먹음으로써 배추를 보호한다. 
 *  특히, 어떤 배추에 배추흰지렁이가 한 마리라도 살고 있으면 이 지렁이는 인접한 다른 배추로 이동할 수 있어, 
 *  그 배추들 역시 해충으로부터 보호받을 수 있다.
 *  (한 배추의 상하좌우 네 방향에 다른 배추가 위치한 경우에 서로 인접해있다고 간주한다)
 *  한나가 배추를 재배하는 땅은 고르지 못해서 배추를 군데군데 심어놓았다. 
 *  배추들이 모여있는 곳에는 배추흰지렁이가 한 마리만 있으면 되므로 서로 인접해있는 배추들이 몇 군데에 퍼져있는지 조사하면 총 몇 마리의 지렁이가 필요한지 알 수 있다.
 *  예를 들어 배추밭이 아래와 같이 구성되어 있으면 최소 5마리의 배추흰지렁이가 필요하다.
 *  (0은 배추가 심어져 있지 않은 땅이고, 1은 배추가 심어져 있는 땅을 나타낸다.)
 * 입력
 *  입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다. 
 *  그 다음 줄부터 각각의 테스트 케이스에 대해 첫째 줄에는 배추를 심은 배추밭의 가로길이 M(1 ≤ M ≤ 50)과 세로길이 N(1 ≤ N ≤ 50), 
 *  그리고 배추가 심어져 있는 위치의 개수 K(1 ≤ K ≤ 2500)이 주어진다. 그 다음 K줄에는 배추의 위치 X(0 ≤ X ≤ M-1), Y(0 ≤ Y ≤ N-1)가 주어진다.
 * 출력
 *  각 테스트 케이스에 대해 필요한 최소의 배추흰지렁이 마리 수를 출력한다.
ex1)
2
10 8 17
0 0
1 0
1 1
4 2
4 3
4 5
2 4
3 4
7 4
8 4
9 4
7 5
8 5
9 5
7 6
8 6
9 6
10 10 1
5 5
=>	5
	1
ex2)
1
5 3 6
0 2
1 2
2 2
3 2
4 2
4 0
=>	2
 *
 */
public class 유기농배추_1012 {
	static int t = 0;				// 테스트케이스의 갯수
	static int[] m;					// t만큼:배추를 심은 배추밭의 가로길이
	static int[] n;					// t만큼:배추를 심은 배추밭의 세로길이
	static int[] k;					// t만큼:배추가 심어져 있는 위치의 개수
	static boolean[][][] checked;		// 유기농배추 체크
	static int[][][] cabbage;			// 유기농배추 위치
	static int[] mapX = {0,0,1,-1};	// 가로 : X 탐색 변수
	static int[] mapY = {1,-1,0,0};	// 세로 : Y 탐색 변수
	static int[] earthWorm;			// t만큼:흰지렁이의 수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();	// 테스트케이스의 갯수

		m = new int[t];	// 가로 길이
		n = new int[t];	// 세로 길이
		k = new int[t];	// 배추 갯수
		earthWorm = new int[t];	// 흰지렁이 수

		// 초기화
		checked = new boolean[t][50][50];
		cabbage = new int[t][50][50];
		
		// 입력,초기화 => 반복 : 테스트케이스의 갯수
		for(int i=0; i<t; i++) {
			m[i] = sc.nextInt();
			n[i] = sc.nextInt();
			k[i] = sc.nextInt();

			// 유기농배추 위치
			for(int j=0; j<k[i]; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				cabbage[i][y][x] = 1;
			}
		}

//		// 농장그림 => 반복 : 테스트케이스의 갯수
//		for(int i=0; i<t; i++) {			// 테스트케이스의 갯수
//			for(int j=0; j<n[i]; j++) {		// 세로길이
//				for(int l=0; l<m[i]; l++) {	// 가로길이
//					System.out.print(cabbage[i][j][l] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}
		
		// 문제풀이 => 반복 : 테스트케이스의 갯수
		for(int i=0; i<t; i++) {			// 테스트케이스의 갯수
			for(int j=0; j<n[i]; j++) {		// 세로길이
				for(int l=0; l<m[i]; l++) {	// 가로길이
					if(cabbage[i][j][l] == 1 && !checked[i][j][l]) {
						earthWorm[i]++;
						dfs(j,l,i);
					}
				}
			}
		}
		
		// 답 => 반복 : 테스트케이스의 갯수
		for(int i=0; i<t; i++) {			// 테스트케이스의 갯수
			System.out.println(earthWorm[i]);
		}

	}
	
	public static void dfs(int x, int y, int test) {
		checked[test][x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x + mapX[i];
			int ny = y + mapY[i];
			
			if(nx>=0 && ny>=0 && nx<n[test] && ny<m[test]) {
				if(cabbage[test][nx][ny] == 1 && !checked[test][nx][ny]) {
					dfs(nx,ny,test);
				}
			}
		}
	}

}
