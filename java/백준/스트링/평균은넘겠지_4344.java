package 스트링;

import java.util.Scanner;

public class 평균은넘겠지_4344 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N1 = sc.nextInt();
		int[] sum = new int[N1];
		int[] N2 = new int[N1];
		double[] avg = new double[N1];
		int[] N3;
		double[] result = new double[N1];
		int cnt;
		
		for(int i=0; i<N1; i++) {
			cnt = 0;
			N2[i] = sc.nextInt();
			N3 = new int[N2[i]];
			for(int j=0; j<N2[i]; j++) {
				N3[j] = sc.nextInt();
				sum[i] += N3[j];
			}
			avg[i] = sum[i]/N2[i];
			for(int j=0; j<N3.length; j++) {
				if(avg[i] < N3[j]) {
					cnt++;
				}
			}
			result[i] = (double)cnt/N2[i]*100.0;
		}
		
		for(int i=0; i<N1; i++) {
			System.out.println(String.format("%.3f", result[i]) + "%");
		}
	}
}
