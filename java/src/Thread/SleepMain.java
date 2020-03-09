package Thread;

import java.util.Date;

class SleepThread extends Thread {
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
											// �������������缭 �ð������� String���� �̾Ƴ�.
				System.out.println("����ð� : " + new Date().toLocaleString());
			} catch (InterruptedException e) {e.printStackTrace();}
		}
	}
}

public class SleepMain {
	public static void main(String[] args) {
		SleepThread st = new SleepThread();
		st.start();
		while(true) {
			try {
				Thread.sleep(100);
				System.out.println("go!!!!!!!");
			} catch (InterruptedException e) {e.printStackTrace();}
		}
	}
}
