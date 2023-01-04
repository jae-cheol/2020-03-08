import java.util.Arrays;
import java.util.Scanner;
/*
 * 배열관련 함수의 지식이 부족
 * 
 * 
 * 
 * 
 * 1. 보폭이 일정해야 한다.
 * 	(1,1) -> (1,2) -> (1,3) -> (1,4) :	행은 같고, 열이 일정한 방향으로 이동
 * 	(1,1) -> (2,2) -> (3,3) -> (4,4) :	행과 열이 일정하게 이동
 *  (1,1) -> (2,1) -> (3,1) -> (4,1) :	행이 일정한 방향으로 이동, 열은 같음
 *  
 * 2. 입력받는 행과 열으로 2차원 배열을 생성한다.
 * 	2차원 배열의 초기값은 0이니깐, 1 2 가 입력으로 들어오면 그 공간을 1로 채운다.
 */
public class 배열함수지식부족_1752 {
	public static void main(String[] args) {
		try {
			int R = 0; // row 행			1~5000
			int C = 0; // column 열, 세로	1~5000
			int N = 0; // 학생들의 발자국 수	3~5000
			Scanner sc = new Scanner(System.in);
			R = sc.nextInt();
			C = sc.nextInt();
			int RC[][] = new int[R][C];
			N = sc.nextInt();
			int n1 = 0;
			int n2 = 0;
			for(int i=0; i<N; i++) {
				n1 = sc.nextInt();
				n2 = sc.nextInt();
				RC[n1-1][n2-1] = 1;
			}
//			for(int i=0; i<R; i++) {
//				for(int j=0; j<C; j++) {
//					System.out.print(RC[i][j] + " ");
//				}
//				System.out.println();
//			}
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(RC[n1-1][j] == 1) { // 행이 같을 경우
						
					} else if(RC[i][n2-1] == 1) { // 열이 같을 경우
						
					} else {
						
					}
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}
}
