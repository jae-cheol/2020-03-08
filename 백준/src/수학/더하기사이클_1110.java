package 수학;

import java.util.Scanner;

public class 더하기사이클_1110 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int temp = 0;
		int temp1 = 0;
		int temp2 = 0;
		int cnt = 0;
		int result = 0;
		
		while(true) {
			if(cnt == 0) {
				if(N > 0) {
					temp = N/10 + N%10;
				} else {
					temp = N%10;
				}
				temp1 = N%10;
				temp2 = temp%10;
			} else {
				temp = temp1 + temp2;
				result = temp1*10 + temp2;
				temp1 = temp2;
				temp2 = temp%10;
			}
			
			if(N == result) {
				if(N==0) {
					cnt = 1;
				}
				break;
			}
			cnt++;
		}
		System.out.println(cnt);
	}
}
