package 배열;

import java.util.Arrays;
import java.util.Scanner;

public class 배열뒤집기_1026 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.next());
		int[] X = new int[N];
		int[] Y = new int[N];
		int S = 0;
		for (int i = 0; i < N; i++) {
			X[i] = Integer.parseInt(sc.next());
		}
		for (int i = 0; i < N; i++) {
			Y[i] = Integer.parseInt(sc.next());
		}
		Arrays.sort(X);
		Arrays.sort(Y);

		Arrays.toString(reverseArrayInt(Y));
		
		for(int i=0; i<N; i++){
			S += X[i]*Y[i];
		}
		
		System.out.println(S);
	}

	public static int[] reverseArrayInt(int[] n) {
		int left = 0; // 맨 좌측 요소의 첨자
		int right = n.length - 1; // 맨 우측 요소의 첨자

		while (left < right) {
			int temp = n[left];
			n[left] = n[right]; // 좌우 요소 교환
			n[right] = temp;

			left++;
			right--; // 배열의 중간 부분으로 한칸씩 이동
		}
		return n;
	}
}
