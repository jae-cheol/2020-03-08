package 수학;

import java.util.Scanner;

public class A_add_B_3_10950 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] n = new int[T];
		for(int i=0; i<T; i++) {
			n[i] = sc.nextInt() + sc.nextInt();
		}
		for(int i=0; i<T; i++) {
			System.out.println(n[i]);
		}

	}

}
