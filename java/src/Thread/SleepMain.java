package Thread;

import java.util.Date;

class SleepThread extends Thread {
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
											// 현재지역에맞춰서 시간정보를 String으로 뽑아냄.
				System.out.println("현재시간 : " + new Date().toLocaleString());
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
