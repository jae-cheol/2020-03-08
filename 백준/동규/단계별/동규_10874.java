package 단계별;

import java.util.Scanner;

public class 동규_10874 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {	// 학생의 수.
			boolean f = true;
			for (int j = 0; j < 10; j++) {	// 문제 10개.
				int temp = sc.nextInt();
				if (temp != j % 5 + 1)	// 중간이라도 답이아니면 if문으로 들어가서 false로 나옴.
					if (f)	//1.초기값 true //3.false라서 못들어감.
						f = !f;	//2.들어오면 false
			}
			if (f)	// bool값.
				System.out.println(i + 1);
		}
		sc.close();
	}
}