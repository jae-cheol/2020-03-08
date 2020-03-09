package Thread;

class PriorityThread extends Thread {

	public PriorityThread() {
		super();
	}
	public PriorityThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		System.out.println(getName() + "�켱���� : " + getPriority());	
		for(int i=1; i<=100; i++) {
			System.out.println(getName() + " : " + i + "��° �۾���...");
		}
	}	
}

public class PriorityThreadMain {
	public static void main(String[] args) {
		PriorityThread pt = new PriorityThread("�켱����1�� ������");
		PriorityThread pt2 = new PriorityThread("�켱����10�� ������");
		PriorityThread pt3 = new PriorityThread("�켱����5�� ������");
		
		pt.setPriority(Thread.MIN_PRIORITY);
		pt2.setPriority(Thread.MAX_PRIORITY);
		pt3.setPriority(Thread.NORM_PRIORITY);
		
		pt.start();
		pt2.start();
		pt3.start();
	}
}