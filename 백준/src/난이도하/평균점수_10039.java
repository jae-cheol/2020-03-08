package ���̵���;

import java.util.Scanner;

public class �������_10039 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		int score = 0;
		
		for(int i=0; i<5; i++) {
			score = sc.nextInt();
			sum += score < 40 ? 40 : score;
		}
		
		System.out.println(sum/5);
	}
}
