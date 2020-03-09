package Thread;

class Data {
	public synchronized void a() {
		try {
			notify();	// wait ���ʿ��� ������ ��.	wait()�Ǿ������� �ٽ� ������°���. ��ٸ��� �����尡 ���.
			System.out.println("a() �޼ҵ� ȣ��...a");
			wait();	// �ٸ� Thread���� ������� �Ѱ��ְ� �ٽ� �����·� ����.
		} catch (InterruptedException e) {e.printStackTrace();}
	}
	public synchronized void b() {
		try {
			System.out.println("b() �޼ҵ� ȣ��...");
			notify();	// wait ���ʿ��� ������ ��.	wait()�Ǿ������� �ٽ� ������°���. ��ٸ��� �����尡 ���.
			wait();	// �ٸ� Thread���� ������� �Ѱ��ְ� �ٽ� �����·� ����.
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
