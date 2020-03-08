package exam.code1Z0_808;
class MyException extends RuntimeException{}; 
public class No_56 {

	public static void main(String[] args) {
		try {
			method1();
		} catch(MyException e) {
			System.out.println("A");
		}
	}
	public static void method1() {
		try {
			throw Math.random() > 0.5 ? new MyException() : new RuntimeException();
		} catch(RuntimeException re) {
			System.out.println("B");
		}
	}

}
