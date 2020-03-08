package Thread;

class NameThread extends Thread {
	public NameThread() { 
		super();
	}
	public NameThread(String name) { 
		super(name);
	}

	@Override
	public void run() {
		// NameThread-0  -->  changeNameThread-0
		System.out.println("������ �̸� : " + getName());
		String no = getName().substring(getName().lastIndexOf("-"));
		setName("changeThread" + no);
		System.out.println("����� ������ �̸� : " + getName());
	}
}

public class NameThreadM {
	public static void main(String[] args) {
		
		NameThread nt = new NameThread("NameThread-0");
		NameThread nt2 = new NameThread("NameThread-1");
		
		System.out.println("nt : " + nt.getName());
		System.out.println("nt2 : " + nt2.getName());

		// Thread�� ��ӹ��� ������ run()�� nt , nt2�� �������� ��.
		nt.start();
		nt2.start();
	}
}