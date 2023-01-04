package 단계별;

import java.util.Scanner;
/*
 * -2_147_483_648 < int < 2_147_483_647
 * 
 * -9_223_372_036_854_775_808 < long < 9_223_372_036_854_775_807
 */
public class long_2420 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = Integer.parseInt(sc.next());
		long M = Integer.parseInt(sc.next());
		
		long difference=0;
		if(N>M){
			difference = N-M;
		} else {
			difference = M-N;
		}
		System.out.print(difference);
	}
}
