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
			System.out.println("게임을 선택하세요.");
			System.out.println("A. 가위바위보  B. 주사위 값 맞추기  C.숫자 맞추기  D. 종료");
			char ch = sc.nextLine().charAt(0);
			switch (ch) {
			case 'A':
				System.out.println("가위바위보 게임입니다.");
				System.out.println("가위바위보 중 하나를 입력하세요.");
				System.out.println("(1:가위, 2:바위, 3:보)");
				you = sc.nextInt();
				sc.nextLine();
				if(g1.startGame(you) == 1) {
					wincnt++;
				} else {
					losecnt++;
				}
				break;
			case 'B':
				System.out.println("주사위 값 맞추기 게임입니다.");
				System.out.println("주사위 값을 입력하세요.(1~6값 중 하나) ");
				you = sc.nextInt();
				sc.nextLine();
				if(g2.startGame(you) == 1) {
					wincnt++;
				} else {
					losecnt++;
				}
				break;
			case 'C':
				System.out.println("숫자 맞추기 게임입니다.");
				System.out.println("1~100 중 하나를 입력하세요.");
				if(g3.startGame(0) == 1) {
					wincnt++;
				} else {
					losecnt++;
				}
				break;
			case 'D':
				System.out.println("게임을 종료합니다.");
				System.out.printf("당신의 전적은 %d승 %d패 입니다.", wincnt, losecnt);
				break;
			default:
				System.out.println("다시 입력하세요.");
			}
		}
	}
}
