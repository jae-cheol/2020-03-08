package �迭;

import java.util.Arrays;
import java.util.Scanner;

public class �迭������_1026 {
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
		int left = 0; // �� ���� ����� ÷��
		int right = n.length - 1; // �� ���� ����� ÷��

		while (left < right) {
			int temp = n[left];
			n[left] = n[right]; // �¿� ��� ��ȯ
			n[right] = temp;

			left++;
			right--; // �迭�� �߰� �κ����� ��ĭ�� �̵�
		}
		return n;
	}
}