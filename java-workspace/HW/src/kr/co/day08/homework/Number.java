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
				System.out.println(you + "���� ���� �� �Դϴ�."+me);
				System.out.println("��ȸ�� " + cnt-- + "�� ���ҽ��ϴ�.");
				System.out.println(min + " ~ " + max + " ������ ���� �Է��Ͻÿ�.");
			} else if (me > you) {
				min = you+1;
				System.out.println(you + "���� ū �� �Դϴ�.");
				System.out.println("��ȸ�� " + cnt-- + "�� ���ҽ��ϴ�."+me);
				System.out.println(min + " ~ " + max + " ������ ���� �Է��Ͻÿ�.");
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
		System.out.println("�����ϴ�. ���ڴ� " + me + "�Դϴ�.");
		return 0;
	}
}
