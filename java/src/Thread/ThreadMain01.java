package Thread;

class AAA extends Thread { // Thread 를 상속받으면 Thread 객체가 됨.
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
		
		// Thread Queue 에 Thread만 집어넣으면 됨. run은 알아서 함.
		ta.start();
		tb.start();
	}
}