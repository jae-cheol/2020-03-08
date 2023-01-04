package exam.code1Z0_808;
/*
 * 
 */
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class No_107_LocalDate extends A{
	public static void main(String[] args) {
		String date1 = LocalDateTime
				.parse("2011-12-03T10:15:30")	// 날짜와 시간 문자열로 인스턴스를 만드는법
				.format(DateTimeFormatter.ISO_DATE_TIME);
		String date2 = LocalDate
				.parse("2014-05-04")	// 날짜와 시간 문자열로 인스턴스를 만드는법
				.format(DateTimeFormatter.ISO_DATE);
		System.out.println(date1);
		System.out.println(date2);
	}
}
