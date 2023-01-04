package kr.co.day08.homework;

import java.util.Random;
import java.util.Scanner;

public class Number implements Game {

	public int startGame(int you) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int me = r.nextInt(100) + 1;
		int i;
		int cnt = 5;
		int max = 100;
		int min = 1;
		while(true) {
			you = sc.nextInt();
			sc.nextLine();
			if (me < you) {
				max = you-1;
				System.out.println(you + "보다 작은 수 입니다."+me);
				System.out.println("기회는 " + cnt-- + "번 남았습니다.");
				System.out.println(min + " ~ " + max + " 사이의 수를 입력하시오.");
			} else if (me > you) {
				min = you+1;
				System.out.println(you + "보다 큰 수 입니다.");
				System.out.println("기회는 " + cnt-- + "번 남았습니다."+me);
				System.out.println(min + " ~ " + max + " 사이의 수를 입력하시오.");
			} else {
				System.out.println("You win");
				return 1;
			}
			
			if(cnt == 0 && me == you){
				System.out.println("You win");
				return 1;
			}

			if (cnt == 0)
				break;
		}
		System.out.println("졌습니다. 숫자는 " + me + "입니다.");
		return 0;
	}
}
