package ����ó��;

import java.io.FileReader;

abstract class Parent {
	abstract void print();
	abstract void input() throws Exception;
}

class Chlid extends Parent {

	@Override
	void print() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void input() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}

public class ExceptionMain06 {

	static void a() {
		System.out.println("a() �޼ҵ� ȣ��...");

		try {
			FileReader fr = new FileReader("a.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	static void b() throws Exception {
		System.out.println("b() �޼ҵ� ȣ��...");
	
		System.out.println(1 / 0);
		
		String str = null;
		System.out.println(str.length());
	
		
	}
	
	public static void main(String[] args) /*throws Exception */{
		a();
//		b();
		try {
			b();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("main end...");
	}
}
