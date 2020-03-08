package 단계별;

import java.util.Scanner;

public class 보류_1193 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		int[] n1 = new int[100]; // 분자
		int[] n2 = new int[100]; // 분모
		int one = 1;
		int cnt = 0;
		n1[0] = 1;
		for(int i=1; i<100; i++) {
			for(int j=1; j<++cnt; j++) { // 1,2,3,4,5
				n1[i] = ++j;
				if(n1[i] == 1) {
					
				}
				
				System.out.println(n1[i]);
				break;
			}
			break;
		}
	}
}
