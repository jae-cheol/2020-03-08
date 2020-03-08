package exam.code1Z0_808;

import java.util.ArrayList;
import java.util.List;

public class No_70 {
	public static void main(String[] args) {
		try {
			int num = 10;
			int div = 0;
			int ans = num / div;
		} catch(ArithmeticException ae) {
//			ans = 0;
		} catch(Exception e) {
			System.out.println("Invalid calculation");
		}
//		System.out.println("Answer = " + ans);
	}
}
