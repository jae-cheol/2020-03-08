package exam.code1Z0_808;

class Base {
	public void test() {
		System.out.println("Base ");
	}
}

class DerivedA extends Base {
	public void test() {
		System.out.println("DerivedA ");
	}
}

public class No_15 extends DerivedA {
	public void test() {
		System.out.println("DerivedB ");
	}
	public static void main(String[] args) {
		// 업캐스팅 : 서브클래스 객체가 슈퍼클래스 타입으로 변환되는 것
		Base b1 = (Base)new No_15();
		Base b2 = (Base)new DerivedA();
		Base b3 = (Base)new No_15();
		b1 = (Base)b3;
		if(b1 instanceof Base) {
			System.out.println("b1:Super");
		}
		if(b1 instanceof DerivedA) {
			System.out.println("b1:Sub1");
		}
		if(b1 instanceof No_15) {	// b1
			System.out.println("b1:Sub2");
		}
		if(b2 instanceof Base) {
			System.out.println("b2:Super");
		}
		if(b2 instanceof DerivedA) {	// b2
			System.out.println("b2:Sub1");
		}
		if(b2 instanceof No_15) {
			System.out.println("b2:Sub2");
		}
		if(b3 instanceof Base) {
			System.out.println("b3:Super");
		}
		if(b3 instanceof DerivedA) {
			System.out.println("b3:Sub1");
		}
		if(b3 instanceof No_15) {	// b3
			System.out.println("b3:Sub2");
		}
		System.out.println("--------------------------------");
		Base b4 = (DerivedA)b3;

		if(b3 instanceof Base) {
			System.out.println("b3:Super");
		}
		if(b3 instanceof DerivedA) {
			System.out.println("b3:Sub1");
		}
		if(b3 instanceof No_15) {	// b3
			System.out.println("b3:Sub2");
		}
		if(b4 instanceof Base) {
			System.out.println("b4:Super");
		} 
		if(b4 instanceof DerivedA) {
			System.out.println("b4:Sub1");
		} 
		if(b4 instanceof No_15) {	// b4
			System.out.println("b4:Sub2");
		}
		b1.test();
		b4.test();
	}

}
