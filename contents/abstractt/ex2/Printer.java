package contents.abstractt.ex2;

public abstract class Printer {

	public abstract void print();
}

class SamsungPrinter extends Printer {

	@Override
	public void print() {
		System.out.println("삼성프린터에서 출력중...");
	}
	
//	public void samPrint() {
//		System.out.println("삼성프린터에서 출력중...");
//	}
}

class LGPrinter extends Printer {

	@Override
	public void print() {
		System.out.println("LG프린터에서 출력중...");
	}
	
//	public void lgPrint() {
//		System.out.println("LG프린터에서 출력중...");
//	}
}

class HPPrinter extends Printer {

	@Override
	public void print() {
		System.out.println("HP프린터에서 출력중...");
	}

}
