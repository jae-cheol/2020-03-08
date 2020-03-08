package Á¶°Ç¹®;

import java.util.Scanner;

public class if_2292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		
		int[] n = new int[100000];
		n[0] = 1;
		for(int i=1; i<n.length; i++) {
			n[i] = n[i-1] + 6*i; // 1, 7, 19, 37
			if(num == 1) {
				System.out.println(n[0]);
				break;
			}else if(n[i-1] < num && num <= n[i]){
				System.out.println(i+1);
				break;
			}
		}
	}
}
