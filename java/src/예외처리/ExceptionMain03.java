package ����ó��;

public class ExceptionMain03 {

	public static void main(String[] args) {
		
		System.out.println("main start...");
		
		for(int i = -2; i < 4; i++) {
			System.out.println("i = " + i);
			try {
				System.out.println(10 / i);
			} catch(ArithmeticException ae) {
				System.out.println("���ܹ߻�...");
//				break;
				continue;
			} finally {
				System.out.println("�ݺ��� ������...");
			}
		}
		
		System.out.println("main end...");
		
	}
}
