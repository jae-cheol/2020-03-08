package 찌유_09;

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
			int type = scanInt("항목을 선택하세요(1. 특정년도   2. 특정월   3. 종료) : ");
			int year = 0, month = 0;
			switch (type) {
			case 1:
				year = scanInt("년도 입력 : ");
				util.showByYear(year);
				break;
			case 2:
				year = scanInt("년도 입력 : ");
				month = scanInt("월 입력 : ");
				util.showByMonth(year, month);
				break;
			case 3:
				System.out.println("달력 프로그램을 종료합니다.");
				System.exit(0);
				break;
			}
		}
	}
}













