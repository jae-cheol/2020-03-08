package exam.code1Z0_808;

class A {
	public void test() {
		System.out.println("A");
	}
}
class B extends A {
	public void test() {
		System.out.println("B");
	}
}

public class No_104 extends A{
	public void test() {
		System.out.println("C");
	}
	public static void main(String[] args) {
		A b1 = new A();
//		System.out.println(b1 instanceof A);
//		System.out.println(b1 instanceof B);
//		System.out.println(b1 instanceof No_104);
		A b2 = new No_104();
		System.out.println(b2.getClass());
//		System.out.println(b2 instanceof A);
//		System.out.println(b2 instanceof B);
//		System.out.println(b2 instanceof No_104);
		b1 = (A)b2;
//		System.out.println(b1 instanceof A);
//		System.out.println(b1 instanceof B);
//		System.out.println(b1 instanceof No_104);
		A b3 = (B)b2;
//		A b3 = (B)b2;
		b1.test();
		b3.test();
	}
}
