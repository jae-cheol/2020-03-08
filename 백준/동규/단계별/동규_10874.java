package �ܰ躰;

import java.util.Scanner;

public class ����_10874 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {	// �л��� ��.
			boolean f = true;
			for (int j = 0; j < 10; j++) {	// ���� 10��.
				int temp = sc.nextInt();
				if (temp != j % 5 + 1)	// �߰��̶� ���̾ƴϸ� if������ ���� false�� ����.
					if (f)	//1.�ʱⰪ true //3.false�� ����.
						f = !f;	//2.������ false
			}
			if (f)	// bool��.
				System.out.println(i + 1);
		}
		sc.close();
	}
}