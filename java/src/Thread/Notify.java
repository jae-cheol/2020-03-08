package Thread;

class Data {
	public synchronized void a() {
		try {
			notify();	// wait 위쪽에만 있으면 됨.	wait()되었던것이 다시 실행상태가됨. 기다리던 쓰레드가 깨어남.
			System.out.println("a() 메소드 호출...a");
			wait();	// 다른 Thread에게 제어권을 넘겨주고 다시 대기상태로 진입.
		} catch (InterruptedException e) {e.printStackTrace();}
	}
	public synchronized void b() {
		try {
			System.out.println("b() 메소드 호출...");
			notify();	// wait 위쪽에만 있으면 됨.	wait()되었던것이 다시 실행상태가됨. 기다리던 쓰레드가 깨어남.
			wait();	// 다른 Thread에게 제어권을 넘겨주고 다시 대기상태로 진입.
		} catch (InterruptedException e) {e.printStackTrace();}
	}
}

class NotifyThread01 extends Thread {
	private Data data;

	public NotifyThread01(Data data) {
		super();
		this.data = data;
	}

	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			data.a();
			Thread.yield();
		}
	}
}

class NotifyThread02 extends Thread {
	private Data data;

	public NotifyThread02(Data data) {
		super();
		this.data = data;
	}

	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			data.b();
			Thread.yield();
		}
	}
}

public class Notify {
	public static void main(String[] args) {
		Data data = new Data();
		
		NotifyThread01 nt01 = new NotifyThread01(data); 
		NotifyThread02 nt02 = new NotifyThread02(data); 
		
		nt01.start();
		nt02.start();
	}
}
