package com.tyn.edu;

public class ThreadEx13 {
	static long startTime = 0;
	public static void main(String[] args) {
		ThreadEx13_1 th1 = new ThreadEx13_1();
		ThreadEx13_2 th2 = new ThreadEx13_2();
		
		th1.start();
		th2.start();
		startTime = System.currentTimeMillis();
		
		try {
			th1.join(); // th1의 작업이 끝날 때까지 기다린다.
			th2.join(); // th2의 작업이 끝날 때까지 기다린다.
		} catch(InterruptedException e) {}
		
		System.out.println("\n소요시간 : " + (System.currentTimeMillis() - startTime));
	}
}

class ThreadEx13_1 extends Thread {
	public void run() {
		for (int i=0; i<3000; i++) {
			System.out.print("-");
		}
	} // run()
}

class ThreadEx13_2 extends Thread {
	public void run() {
		for (int i=0; i<3000; i++) {
			System.out.print("|");
		}
	} // run()
}

