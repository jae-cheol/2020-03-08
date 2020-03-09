package 날짜;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class 날짜 {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();	// static일 수 밖에 없는 getInstance()
		
		// 날짜정보 : 2016년 9월 22일(목)
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;	// 0~11
		int date = c.get(Calendar.DAY_OF_MONTH);
		int day = c.get(Calendar.DAY_OF_WEEK);	// 1~7
		
		String[] dayArr = {"", "일", "월", "화", "수", "목", "금", "토"};
						//  0    1   2    3     4    5     6    7
		
		System.out.println("날짜정보 : " + year + "년 " + month + "월 " + date + "일(" + dayArr[day] + ")");
		
		// 2015년 11월 21일 무슨요일???
		c.set(2015, 11-1, 21);				// 고쳐준값

		day = c.get(Calendar.DAY_OF_WEEK);	// 보여주는값
		System.out.println("2015년 11월 21일은 " + dayArr[day] + "요일입니다");
		
		int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("11월의 마지막날은 " + lastDay + "일입니다.");
		
		Date d = c.getTime();
		System.out.println("d : " + d);
		
		d = new Date(900000000000L);
		System.out.println("d : " + d);
		
		c.setTime(d);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh:mm:ss(E)");
		System.out.println("날짜정보 : " + sdf.format(new Date()));
		
		
//		Date d = new Date();
//		
//		System.out.println("d : " + d);
//		
//		// 날짜정보 : 2016년 9월 22일  
//		int year = d.getYear() + 1900;
//		int month = d.getMonth() + 1;
//		int date = d.getDate();
//		
//		System.out.println("날짜정보 : " + year + "년 " + month + "월 " + date + "일");
	}
}

//abstract class Calendar {
//	public /*java.util.*/Calendar getInstance() {
//		return new /*java.util.*/GregorianCalendar();
//	}
//}







