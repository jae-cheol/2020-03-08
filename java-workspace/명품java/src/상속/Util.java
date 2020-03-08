package ���;

import java.util.Scanner;

public class Util {
	// static���� ������ �Լ���ȿ��� ���� ��������� static�� ����.
	public final static Scanner sc = new Scanner(System.in);
	public static String inputStr(String msg){
		String s;
		while(true){
			try {
				System.out.print(msg);
				s = sc.nextLine();
			} catch(Exception e) {
				System.out.println("�ٽ��Է��ϼ���.");
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
				System.out.println("�ٽ��Է��ϼ���.");
				continue;
			}
			break;
		}
		return num;
	}
}
