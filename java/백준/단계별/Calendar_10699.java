package 단계별;

import java.util.Calendar;

public class Calendar_10699 {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();	// static일 수 밖에 없는 getInstance()
		
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;	// 0~11
		int date = c.get(Calendar.DAY_OF_MONTH);
		
		System.out.println(year + "-" + month + "-" + date);
	}
}
