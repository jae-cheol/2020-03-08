package 조건문;

import java.util.Scanner;

/*
 * 정수 N개로 이루어진 수열 A와 정수 X가 주어진다. 
 * 이 때, A에서 X보다 작은 수를 모두 출력하는 프로그램을 작성하시오.
 * 
 */
public class if_10871 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int X = sc.nextInt();
		sc.nextLine();
		int[] A = new int[N];
		int[] B = new int[N];
		
		for(int i=0; i<A.length; i++) {
			A[i] = sc.nextInt();
			if(A[i] < X) {
				B[i] = A[i];
			}
		}
		
		for(int i : B) {
			if(i != 0) {
				System.out.println(i);
			}
		}
		
		
	}
}
