package ����;
/*
 * 42 = 5*6 + 3*4 = 10���� ���
 * 
 * BASE : 5�ǹ���� Best Of Best!!
 * 1. 5���.
 * 2. 5��� + 3��� 1��.
 * 3. 5��� + 3��� 2��.
 * 4. 5��� + 3��� 3��.
 * 5. 5��� + 3��� 4��.
 * 6. -1
 */
import java.util.Scanner;

public class �������_2839 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int cnt = -1;
		
		if(num%5 == 0) {	// 1. 5�� ���.
			cnt = num/5;
		}
		if(num%5 == 3) {	// 2. 5�ǹ�� + 3�ǹ�� 1��.
			cnt = num/5 + 1;
		}
		if(num%5 == 1) {	// 3. 5�ǹ�� + 3�ǹ�� 2��.
			cnt = num/5 + 1;
		}
		if(num%5 == 4 
		&& num>=9
		) {	// 4. 5�ǹ�� + 3�ǹ�� 3��.
			cnt = num/5 + 2;
		}
		if(num%5 == 2 
		&& num>=12
		) {	// 5. 5�ǹ�� + 3�ǹ�� 4��.
			cnt = num/5 + 2;
		}
		System.out.println(cnt);
	}
}
