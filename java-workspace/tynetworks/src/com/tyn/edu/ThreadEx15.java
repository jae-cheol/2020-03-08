package com.tyn.edu;

public class ThreadEx15 {
	public static void main(String[] args) {
		ThreadEx15_1 th1 = new ThreadEx15_1();
		ThreadEx15_2 th2 = new ThreadEx15_2();
		
		th1.start();
		th2.start();
		
		try {
			th1.sleep(5000);
		} catch(InterruptedException e) {}
		
		System.out.println("\n<<main 종료>>");
	}
}

class ThreadEx15_1 extends Thread {
	public void run() {
		for (int i=0; i<800000; i++) {
			System.out.print("-");
		}
		System.out.println("\n<<th1 종료>>");
	} // run()
}

class ThreadEx15_2 extends Thread {
	public void run() {
		for (int i=0; i<800000; i++) {
			System.out.print("|");
		}
		System.out.println("\n<<th2 종료>>");
	} // run()
}

