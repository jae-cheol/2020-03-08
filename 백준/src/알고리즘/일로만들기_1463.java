package 알고리즘;

import java.util.Scanner;

public class 일로만들기_1463 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int cnt = 0;
		
		while(num != 1) {
			if((num-1)%3 == 0) {
				num -= 1;
			} else if(num%3 == 0) {
				num /= 3;
			} else {
				if(num%2 == 0) {
					num /= 2;
				} else {
					num -= 1;
				}
			}
			cnt++;
		}
		System.out.println(cnt);
	}
}
