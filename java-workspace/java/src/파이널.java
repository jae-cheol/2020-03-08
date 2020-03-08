

import java.util.Random;

/*
 * Final
 * 1. 멤버변수 : 상수(수정금지)
 * 2. 메소드    : overriding 금지
 * 3. 클래스    : 상속금지
 */

/*final*/ class Super {
	private /*final*/ int MAX = 100;
	
	Super() {
		MAX = 0;
	}
	
	/*final*/ void info() {
		System.out.println("Super클래스에서 정의된 info()메소드...");
	}
}

class Sub extends Super {
	@Override
	void info() {
		System.out.println("Sub클래스에서 오버라이딩된 info()메소드...");
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

public class 파이널 {

	public static void main(String[] args) {
		
		// 1 - 100사이의 난수 추출
//		Random r = new Random();
//		int random = r.nextInt(100) + 1;
		
		MyRandom r = new MyRandom();
		int random = r.nextInt(100);
		
		System.out.println("추출된 정수 : " + random);
	}
}