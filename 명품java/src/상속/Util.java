package 상속;

import java.util.Scanner;

public class Util {
	// static으로 지정한 함수들안에서 쓰는 멤버변수라서 static을 써줌.
	public final static Scanner sc = new Scanner(System.in);
	public static String inputStr(String msg){
		String s;
		while(true){
			try {
				System.out.print(msg);
				s = sc.nextLine();
			} catch(Exception e) {
				System.out.println("다시입력하세요.");
				continue;
			}
			break;
		}
		return s;
	}
	public static int inputInt(String msg){
		int num;
		while(true){
			try {
				System.out.print(msg);
				num = Integer.parseInt(sc.nextLine());
			} catch(Exception e) {
				System.out.println("다시입력하세요.");
				continue;
			}
			break;
		}
		return num;
	}
}
