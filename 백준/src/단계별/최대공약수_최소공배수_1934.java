package �ܰ躰;

import java.util.Scanner;

public class �ִ�����_�ּҰ����_1934 {
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

	// �ּ� ����� ��� �޼���
	// �ּҰ������ ��û���� ū ���ڰ� ���� ���� �ֱ⿡
	// long������ �ٷ��� �մϴ�.
	public static long lcm(long a, long b) {
		int gcd_value = gcd((int) a, (int) b);

		if (gcd_value == 0)
			return 0; // �μ��� �Ѵ� 0�� ���� ���� ó��

		return Math.abs((a * b) / gcd_value);
	}

	// �ִ� ����� ��� �Լ�; �ּ� ����� ��꿡 �ʿ���
	// �ִ� ������� �׸� ū ���ڰ� ������ �ʱ⿡ int������
	public static int gcd(int a, int b) {
		while (b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		return Math.abs(a);
	}
}