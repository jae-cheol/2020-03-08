package WriteDown;

abstract class Printer {
	String productName;
	abstract void print();
}

interface Scanable {
	void scan();
}

interface Faxable extends Scanable {
	void fax();
}

class LGPrinter extends Printer implements Faxable {
	
	// �������̵��ϸ� ������ ���̴°� ������µ� ���̸� �ȵ�.
	public void fax() {
	}
	public void scan(){
	}
	void print(){
		
	}
}
public class Test26 {
	public static void main(String[] args) {
		new LGPrinter();
	}
}
