package kr.co.jar;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String today() {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(new Date());
	}
}
