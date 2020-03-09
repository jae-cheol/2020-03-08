package kr.co.day08.homework;

import java.util.Random;
import java.util.Scanner;

public class GameMain {
	public static void main(String[] args) {
		Game g1 = new ScissorsRockPaper();
		Game g2 = new Dice();
		Game g3 = new Number();
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int you;
		int wincnt = 0;
		int losecnt = 0;
		while (true) {
			System.out.println("������ �����ϼ���.");
			System.out.println("A. ����������  B. �ֻ��� �� ���߱�  C.���� ���߱�  D. ����");
			char ch = sc.nextLine().charAt(0);
			switch (ch) {
			case 'A':
				System.out.println("���������� �����Դϴ�.");
				System.out.println("���������� �� �ϳ��� �Է��ϼ���.");
				System.out.println("(1:����, 2:����, 3:��)");
				you = sc.nextInt();
				sc.nextLine();
				if(g1.startGame(you) == 1) {
					wincnt++;
				} else {
					losecnt++;
				}
				break;
			case 'B':
				System.out.println("�ֻ��� �� ���߱� �����Դϴ�.");
				System.out.println("�ֻ��� ���� �Է��ϼ���.(1~6�� �� �ϳ�) ");
				you = sc.nextInt();
				sc.nextLine();
				if(g2.startGame(you) == 1) {
					wincnt++;
				} else {
					losecnt++;
				}
				break;
			case 'C':
				System.out.println("���� ���߱� �����Դϴ�.");
				System.out.println("1~100 �� �ϳ��� �Է��ϼ���.");
				if(g3.startGame(0) == 1) {
					wincnt++;
				} else {
					losecnt++;
				}
				break;
			case 'D':
				System.out.println("������ �����մϴ�.");
				System.out.printf("����� ������ %d�� %d�� �Դϴ�.", wincnt, losecnt);
				break;
			default:
				System.out.println("�ٽ� �Է��ϼ���.");
			}
		}
	}
}
