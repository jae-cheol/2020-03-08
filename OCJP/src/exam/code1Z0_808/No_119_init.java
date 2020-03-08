package exam.code1Z0_808;
/*
 * 초기화
 * 메소드 내부의 변수는 초기화를 해줘야 한다.
 * 클래스 내부의 변수는 타입에 맞게 알아서 초기화가 된다.
 */
public class No_119_init {
	char c;
	boolean b;
	float f;
	void printAll() {
		System.out.println("c = " + c);
		System.out.println("b = " + b);
		System.out.println("f = " + f);
	}
	public static void main(String[] args) {
		No_119_init f = new No_119_init();
		f.printAll();
	}
}
