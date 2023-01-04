package 반복문;

import java.util.Scanner;

public class for_8393 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();
		int tot=0;
		for(int i=1; i<=num; i++) {
			tot += i;
		}
		System.out.println(tot);
	}
}
