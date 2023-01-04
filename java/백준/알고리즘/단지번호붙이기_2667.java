package 알고리즘;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 문제
 *  <그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 
 *  철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다. 
 *  여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 
 *  대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 
 *  지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
 * 입력
 *  첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 
 *  그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.
 * 출력
 *  첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.
ex)
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000
=> 	3
	7
	8
	9
 */
public class 단지번호붙이기_2667 {
    static int dx[] = {0,0,1,-1};	// 오,왼,아래,위 (x좌표 검사 - 세로줄)
    static int dy[] = {1,-1,0,0};	// 오,왼,아래,위 (y좌표 검사 - 가로줄)
	static boolean[][] checked;		// 간 곳 체크.
	static int count = 0;			// 단지의 수.
	static int n = 0;				// 입력 - 지도의 크기
	static int[][] complex;			// 입력 - n개의 자료(1,0)
	static int[] complexNum;		// 단지당 아파트의 수.
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		complex = new int[n+1][n+1];
		checked = new boolean[n+1][n+1];
		complexNum = new int[(n+1)*(n+1)];
		String line = "";
		
		// 1. 입력
		for(int i=1; i<=n; i++) {
			line = sc.next();
			for(int j=1; j<=n; j++) {
				complex[i][j] = Integer.parseInt(String.valueOf(line.charAt(j-1)));
			}
		}

//		// 2. 값 확인
//		for(int i=1; i<=n; i++) {
//			for(int j=1; j<=n; j++) {
//				System.out.print(complex[i][j] + " ");
//			}
//			System.out.println();
//		}

		// 3. 단지수 카운트, 단지에 있는 아파트 카운트.
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(complex[i][j] == 1 && !checked[i][j]) {
					count++;
					dfs(i,j);
				}
			}
		}

        Arrays.sort(complexNum);
        System.out.println(count);

        for(int i=0; i<complexNum.length; i++){
            if(complexNum[i] != 0){
                System.out.println(complexNum[i]);
            }
        }
	}
	
	public static void dfs(int x, int y) {
		checked[x][y] = true;
		complexNum[count]++;

        for(int i=0; i<4; i++){	// 오,왼,아래,위 순서로 검사 시작.
            int nx = x + dx[i];	// {0,0,1,-1}
            int ny = y + dy[i];	// {1,-1,0,0}

            if(nx >=0 && ny >=0 && nx <= n && ny <= n){
                if(complex[nx][ny] == 1 && !checked[nx][ny]){
                    dfs(nx,ny);
                }
            }
        }
		
	}

}
