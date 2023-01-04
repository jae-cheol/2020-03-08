package 난이도하;

import java.util.Scanner;

public class 숫자의합_11720 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N1 = sc.nextInt();
		String N2 = sc.next();
		int cnt = 0;
		
		char ch;
		for(int i=0; i<N1; i++) {
			ch = N2.charAt(i);
			cnt += Integer.parseInt(String.valueOf(ch));
		}
		
		System.out.println(cnt);
	}
}
