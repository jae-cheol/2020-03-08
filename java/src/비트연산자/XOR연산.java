package 비트연산자;

import java.util.Random;
public class XOR연산 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] x = {2, 6, 6};
		int[] y = {0, 0, 6};
		
		int xSum = 0;
		for(int i=0; i<x.length; i++) {
			xSum ^= x[i];
			System.out.println("x[i] : " + x[i]);
			System.out.println("xSum : " + xSum);
		}
		System.out.println("---------------");
		System.out.println("xSum : " + xSum);
	}

}
