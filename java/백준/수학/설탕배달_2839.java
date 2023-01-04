package 수학;
/*
 * 42 = 5*6 + 3*4 = 10개로 배달
 * 
 * BASE : 5의배수가 Best Of Best!!
 * 1. 5배수.
 * 2. 5배수 + 3배수 1개.
 * 3. 5배수 + 3배수 2개.
 * 4. 5배수 + 3배수 3개.
 * 5. 5배수 + 3배수 4개.
 * 6. -1
 */
import java.util.Scanner;

public class 설탕배달_2839 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int cnt = -1;
		
		if(num%5 == 0) {	// 1. 5의 배수.
			cnt = num/5;
		}
		if(num%5 == 3) {	// 2. 5의배수 + 3의배수 1개.
			cnt = num/5 + 1;
		}
		if(num%5 == 1) {	// 3. 5의배수 + 3의배수 2개.
			cnt = num/5 + 1;
		}
		if(num%5 == 4 
		&& num>=9
		) {	// 4. 5의배수 + 3의배수 3개.
			cnt = num/5 + 2;
		}
		if(num%5 == 2 
		&& num>=12
		) {	// 5. 5의배수 + 3의배수 4개.
			cnt = num/5 + 2;
		}
		System.out.println(cnt);
	}
}
