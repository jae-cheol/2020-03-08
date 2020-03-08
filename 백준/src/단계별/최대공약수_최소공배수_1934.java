package 단계별;

import java.util.Scanner;

public class 최대공약수_최소공배수_1934 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.next());
		int[] A = new int[T];
		int[] B = new int[T];

		for(int i=0; i<T; i++){
			A[i] = Integer.parseInt(sc.next());
			B[i] = Integer.parseInt(sc.next());
		}

		for(int i=0; i<T; i++){
			System.out.println(lcm(A[i], B[i]));
		}
	}

	// 최소 공배수 계산 메서드
	// 최소공배수는 엄청나게 큰 숫자가 나올 수도 있기에
	// long형으로 다루어야 합니다.
	public static long lcm(long a, long b) {
		int gcd_value = gcd((int) a, (int) b);

		if (gcd_value == 0)
			return 0; // 인수가 둘다 0일 때의 에러 처리

		return Math.abs((a * b) / gcd_value);
	}

	// 최대 공약수 계산 함수; 최소 공배수 계산에 필요함
	// 최대 공약수는 그리 큰 숫자가 나오지 않기에 int형으로
	public static int gcd(int a, int b) {
		while (b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		return Math.abs(a);
	}
}