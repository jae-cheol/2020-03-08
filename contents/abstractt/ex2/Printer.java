package contents.abstractt.ex2;

public abstract class Printer {

	public abstract void print();
}

class SamsungPrinter extends Printer {

	@Override
	public void print() {
		System.out.println("�Ｚ�����Ϳ��� �����...");
	}
	
//	public void samPrint() {
//		System.out.println("�Ｚ�����Ϳ��� �����...");
//	}
}

class LGPrinter extends Printer {

	@Override
	public void print() {
		System.out.println("LG�����Ϳ��� �����...");
	}
	
//	public void lgPrint() {
//		System.out.println("LG�����Ϳ��� �����...");
//	}
}

class HPPrinter extends Printer {

	@Override
	public void print() {
		System.out.println("HP�����Ϳ��� �����...");
	}

}
