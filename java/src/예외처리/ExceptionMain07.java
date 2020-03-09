package ����ó��;

import java.util.Scanner;

public class ExceptionMain07 {
	
	static void register() throws Exception {
			Scanner sc = new Scanner(System.in);
			
			System.out.print("����� ID�� �Է��ϼ��� : ");
			String id = sc.nextLine();

			if(id.length() >= 8) {
				throw new CheckIDException("ID�� �ִ� 8���ڸ� �����մϴ�.");
//				throw new Exception("ID�� �ִ� 8���ڸ� �����մϴ�.");
			}
			System.out.println("ID�� ����Ͽ����ϴ�.");
	}
	
	public static void main(String[] args) {
		try {
			register();
		} catch (Exception e) {
			System.out.println("���ܻ��� : " + e.getMessage());
			e.printStackTrace();
		}
/*		try {
			Scanner sc = new Scanner(System.in);
			
			System.out.print("����� ID�� �Է��ϼ��� : ");
			String id = sc.nextLine();

			if(id.length() >= 8) {
				throw new Exception("ID�� �ִ� 8���ڸ� �����մϴ�.");
			}
			System.out.println("ID�� ����Ͽ����ϴ�.");
			
			} catch(Exception e) {
				e.printStackTrace();
			}
//			if(id.length() < 8) {
//				System.out.println("ID�� ����Ͽ����ϴ�.");
//			} else {
//				System.out.println("ID�� �ִ� 8���ڸ� �����մϴ�.");
//			}
*/	}
}
