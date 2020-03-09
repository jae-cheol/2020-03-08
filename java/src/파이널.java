

import java.util.Random;

/*
 * Final
 * 1. ������� : ���(��������)
 * 2. �޼ҵ�    : overriding ����
 * 3. Ŭ����    : ��ӱ���
 */

/*final*/ class Super {
	private /*final*/ int MAX = 100;
	
	Super() {
		MAX = 0;
	}
	
	/*final*/ void info() {
		System.out.println("SuperŬ�������� ���ǵ� info()�޼ҵ�...");
	}
}

class Sub extends Super {
	@Override
	void info() {
		System.out.println("SubŬ�������� �������̵��� info()�޼ҵ�...");
	}
}

class MyRandom extends Random {

	@Override
	public int nextInt(int bound) {
		return super.nextInt(bound) + 1;
	}
	
}

/*class MyString extends String {
	
}*/

public class ���̳� {

	public static void main(String[] args) {
		
		// 1 - 100������ ���� ����
//		Random r = new Random();
//		int random = r.nextInt(100) + 1;
		
		MyRandom r = new MyRandom();
		int random = r.nextInt(100);
		
		System.out.println("����� ���� : " + random);
	}
}