package Thread;

class AAA extends Thread { // Thread �� ��ӹ����� Thread ��ü�� ��.
	public void run() {
		while (true) {
			System.out.println("go!!!");
		}
	}
}

class BBB extends Thread {
	public void run() {
		while (true) {
			System.out.println("stop...");
		}
	}
}

public class ThreadMain01 {

	public static void main(String[] args) {
		AAA ta = new AAA();
		BBB tb = new BBB();
		
		// Thread Queue �� Thread�� ��������� ��. run�� �˾Ƽ� ��.
		ta.start();
		tb.start();
	}
}