package 스태틱;

//꼭 공유 해야 하는것만 static을 써야함.
public class StaticMain {
	static void print() {
		System.out.println("PRINT...");
	}
	public static void main(String[] args) {
//		StaticMain sm = new StaticMain();
//		sm.print();
		StaticMain.print();
	}
}