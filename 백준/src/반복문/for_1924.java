package 반복문;

import java.util.Calendar;
import java.util.Scanner;

public class for_1924 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Calendar c = Calendar.getInstance();	// static일 수 밖에 없는 getInstance()
		String[] dayArr = {"", "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
						//  0    1   2    3     4    5     6    7
		int months = sc.nextInt();
		int days = sc.nextInt();
		
		c.set(2007, months-1, days);				// 고쳐준값

		System.out.println(dayArr[c.get(Calendar.DAY_OF_WEEK)]);
	}
}