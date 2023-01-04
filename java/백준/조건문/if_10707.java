package 조건문;

import java.util.Scanner;

public class if_10707 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = Integer.parseInt(sc.next());
		int B = Integer.parseInt(sc.next());
		int C = Integer.parseInt(sc.next());
		int D = Integer.parseInt(sc.next());
		int P = Integer.parseInt(sc.next());

		int X = A*P;
		int Y = B + D*(P-C);
		
		if(C>P){
			Y = B;
			if(X>Y){
				System.out.println(Y);
			} else {
				System.out.println(X);
			}
		} else {
			Y = B + D*(P-C);
			if(X>Y){
				System.out.println(Y);
			} else {
				System.out.println(X);
			}
		}
	}
}
