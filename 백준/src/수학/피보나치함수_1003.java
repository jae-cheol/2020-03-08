package 수학;

import java.util.Scanner;

public class 피보나치함수_1003 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] T = new int[sc.nextInt()];
		int[][] result = new int[T.length][2];
		int N = 0;
		
		for(int i=0; i<T.length; i++) {
			N = sc.nextInt();
			switch(fibonacci(N)) {
				case 0 :
					result[i][0] += 1;
					break;
				case 1 : 
					result[i][1] += 1;
					if(N == 2) {
						result[i][0] = fibonacci(N-1);
						result[i][1] = fibonacci(N);
					}
					break;
				default :
					result[i][0] = fibonacci(N-1);
					result[i][1] = fibonacci(N);
					break;
			}
		}
		for(int i=0; i<T.length; i++) {
			System.out.println(result[i][0] + " " + result[i][1]);
		}
	}

	private static int fibonacci(int n) {
		if(n==0) {
			return 0;
		} else if(n==1) {
			return 1;
		} else {
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}
}
