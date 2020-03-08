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
	
	// 오버라이딩하면 범위를 늘이는건 상관없는데 줄이면 안됨.
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
