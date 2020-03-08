package ±³È¯;

import java.util.Scanner;

public class temp_1547 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = Integer.parseInt(sc.next());

		int[] g = new int[] { -1, 1, 0, 0 };
		int t;
		int X, Y;

		for (int i = 0; i < M; i++) {
			X = Integer.parseInt(sc.next());
			Y = Integer.parseInt(sc.next());
			
			t = g[X];
			g[X] = g[Y];
			g[Y] = t;
		}
		
		for(int j=0; j<g.length; j++){
			if(g[j] == 1){
				System.out.println(j);
			}
		}
	}
}
