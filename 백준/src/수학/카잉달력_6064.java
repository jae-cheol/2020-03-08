package 수학;

import java.util.Scanner;

public class 카잉달력_6064 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tot = sc.nextInt();
		int[] M = new int[tot];
		int[] N = new int[tot];
		int[] x = new int[tot];
		int[] y = new int[tot];
		for(int i=0; i<tot; i++) {
			M[i] = sc.nextInt();
			N[i] = sc.nextInt();
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}

		int cntM = 0;
		int cntN = 0;
		int cnt = 0;
		int[] res = new int[tot];
		for(int i=0; i<tot; i++) {
			cntM = 0;
			cntN = 0;
			cnt = 0;
			while(true) {
				if(cntM < M[i]) {
					cntM++;
				} else {
					cntM = 1;
				}
				if(cntN < N[i]) {
					cntN++;
				} else {
					cntN = 1;
				}
				cnt++;
				if(cntM == x[i]
				&& cntN == y[i]) {
					res[i] = cnt;
					break;
				}
				if(M[i]*N[i] == cnt) {
					res[i] = -1;
					break;
				}
			}
		}
		for(int i=0; i<tot; i++) {
			System.out.println(res[i]);
		}
	}
}
