package ����_09;

import java.util.Scanner;

public class CalendarView {

	private Scanner sc;
	private CalendarUtil util;
	
	public CalendarView() {
		sc = new Scanner(System.in);
		util = new CalendarUtil();
	}
	
	private int scanInt(String msg) {
		System.out.print(msg);
//		return sc.nextInt();
		return Integer.parseInt(sc.nextLine());
	}
	
	public void process() {

		while (true) {
			int type = scanInt("�׸��� �����ϼ���(1. Ư���⵵   2. Ư����   3. ����) : ");
			int year = 0, month = 0;
			switch (type) {
			case 1:
				year = scanInt("�⵵ �Է� : ");
				util.showByYear(year);
				break;
			case 2:
				year = scanInt("�⵵ �Է� : ");
				month = scanInt("�� �Է� : ");
				util.showByMonth(year, month);
				break;
			case 3:
				System.out.println("�޷� ���α׷��� �����մϴ�.");
				System.exit(0);
				break;
			}
		}
	}
}













