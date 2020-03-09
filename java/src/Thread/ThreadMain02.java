package Thread;

class ExtendThread extends Thread {
	@Override
	public void run() {
		for(int i = 1; i <= 100; i++) {
			System.out.println(i + "번째 인형 눈 붙임...");
		}
	}
}

class ImplementThread implements Runnable {
	@Override
	public void run() {
		for(int i = 1; i <= 100; i++) {
			System.out.println(i + "번째 인형 코 만듬...");
		}
	}
}

public class ThreadMain02 {
	public static void main(String[] args) {
		ExtendThread et = new ExtendThread();
		ImplementThread it = new ImplementThread();

		Thread t = new Thread(it);
		
		System.out.println("메인스레드 감독중...");
		et.start();
		t.start();
		
		try {
			et.join(); // et Thread가 끝나고 작업함.
			t.join();
		} catch(Exception e) { e.printStackTrace(); }

		System.out.println("메인스레드 감독완료...");
		
		for(int i = 1; i <= 100; i++) {
			System.out.println(i + "번째 감독중...");
		}
	}
}







