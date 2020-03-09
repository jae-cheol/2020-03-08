package Thread;

class ExtendThread extends Thread {
	@Override
	public void run() {
		for(int i = 1; i <= 100; i++) {
			System.out.println(i + "��° ���� �� ����...");
		}
	}
}

class ImplementThread implements Runnable {
	@Override
	public void run() {
		for(int i = 1; i <= 100; i++) {
			System.out.println(i + "��° ���� �� ����...");
		}
	}
}

public class ThreadMain02 {
	public static void main(String[] args) {
		ExtendThread et = new ExtendThread();
		ImplementThread it = new ImplementThread();

		Thread t = new Thread(it);
		
		System.out.println("���ν����� ������...");
		et.start();
		t.start();
		
		try {
			et.join(); // et Thread�� ������ �۾���.
			t.join();
		} catch(Exception e) { e.printStackTrace(); }

		System.out.println("���ν����� �����Ϸ�...");
		
		for(int i = 1; i <= 100; i++) {
			System.out.println(i + "��° ������...");
		}
	}
}







