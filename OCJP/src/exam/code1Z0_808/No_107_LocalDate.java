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
				.parse("2011-12-03T10:15:30")	// ��¥�� �ð� ���ڿ��� �ν��Ͻ��� ����¹�
				.format(DateTimeFormatter.ISO_DATE_TIME);
		String date2 = LocalDate
				.parse("2014-05-04")	// ��¥�� �ð� ���ڿ��� �ν��Ͻ��� ����¹�
				.format(DateTimeFormatter.ISO_DATE);
		System.out.println(date1);
		System.out.println(date2);
	}
}