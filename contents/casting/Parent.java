package contents.casting;

class Child01 extends Parent {
	String name = "ù��° �ڽ�";
	void study() {
		System.out.println("���� ���θ� �մϴ�.");
	}
	void sleep() {
		System.out.println("���� ���� ��ϴ�.");
	}
	@Override
	void info() {
		System.out.println("ù��° �ڽĿ��� �������̵��� �޼ҵ��Դϴ�...");
	}
}

class Child02 extends Parent {
	String name = "�ι�° �ڽ�";
	void sing() {
		System.out.println("���� �뷡�� �θ��ϴ�.");
	}
	void play() {
		System.out.println("���� ��ϴ�.");
	}
	@Override
	void info() {
		System.out.println("�ι�° �ڽĿ��� �������̵��� �޼ҵ��Դϴ�.");
	}
}

public class Parent {
	String name = "�θ�";
	int age = 40;
	void info() {
		System.out.println("name : " + name + ", age : " + age);
	}
}