package 배열;
import java.util.Scanner;

public class arr2_1009 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();	// 테스트 케이스 갯수.
		
		int[][] nNum = {  {1}, {2, 4, 8, 6}, {3, 9, 7, 1}, {4, 6}, {5}		  
						, {6}, {7, 9, 3, 1}, {8, 4, 2, 6}, {9, 1}, {10} };
		
		// 입력받는 a, b
		int[] numA = new int[num];
		int[] numB = new int[num];
		for(int i=0; i<num; i++) {
			numA[i] = sc.nextInt();
			numB[i] = sc.nextInt();
		}
		
		int var = 0;
		int A = 0;
		for(int i=0; i<num; i++) {	// 10.
			A = numA[i] % 10;
			if(A == 1 || A == 5 || A == 6 || A == 0) {
				if(A == 0)	System.out.println(nNum[9][0]);
				else 		System.out.println(nNum[A-1][0]);
			} else if(A == 4 || A == 9) {
				var = numB[i] % 2;
				if(var == 0) 	System.out.println(nNum[A-1][var+1]);
				else 			System.out.println(nNum[A-1][var-1]);
			} else if(A == 2 || A == 3 || A == 7 || A == 8) {
				var = numB[i] % 4;
				if(var == 0) 	System.out.println(nNum[A-1][var+3]);
				else			System.out.println(nNum[A-1][var-1]);
			}
		}
	}
}
