package ���ǹ�;

import java.util.Scanner;

/*
 * ���� N���� �̷���� ���� A�� ���� X�� �־�����. 
 * �� ��, A���� X���� ���� ���� ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
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
