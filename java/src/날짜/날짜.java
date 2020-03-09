package ��¥;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ��¥ {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();	// static�� �� �ۿ� ���� getInstance()
		
		// ��¥���� : 2016�� 9�� 22��(��)
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;	// 0~11
		int date = c.get(Calendar.DAY_OF_MONTH);
		int day = c.get(Calendar.DAY_OF_WEEK);	// 1~7
		
		String[] dayArr = {"", "��", "��", "ȭ", "��", "��", "��", "��"};
						//  0    1   2    3     4    5     6    7
		
		System.out.println("��¥���� : " + year + "�� " + month + "�� " + date + "��(" + dayArr[day] + ")");
		
		// 2015�� 11�� 21�� ��������???
		c.set(2015, 11-1, 21);				// �����ذ�

		day = c.get(Calendar.DAY_OF_WEEK);	// �����ִ°�
		System.out.println("2015�� 11�� 21���� " + dayArr[day] + "�����Դϴ�");
		
		int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("11���� ���������� " + lastDay + "���Դϴ�.");
		
		Date d = c.getTime();
		System.out.println("d : " + d);
		
		d = new Date(900000000000L);
		System.out.println("d : " + d);
		
		c.setTime(d);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� hh:mm:ss(E)");
		System.out.println("��¥���� : " + sdf.format(new Date()));
		
		
//		Date d = new Date();
//		
//		System.out.println("d : " + d);
//		
//		// ��¥���� : 2016�� 9�� 22��  
//		int year = d.getYear() + 1900;
//		int month = d.getMonth() + 1;
//		int date = d.getDate();
//		
//		System.out.println("��¥���� : " + year + "�� " + month + "�� " + date + "��");
	}
}

//abstract class Calendar {
//	public /*java.util.*/Calendar getInstance() {
//		return new /*java.util.*/GregorianCalendar();
//	}
//}







