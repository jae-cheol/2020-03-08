package exam.code1Z0_808;

class MyString {
	String msg;
	MyString(String msg) {
		this.msg = msg;
	}
}

public class No_91 {
	public static void main(String[] args) {
		System.out.println("Hello " + new StringBuilder("Java SE 8"));
		StringBuilder sb = new StringBuilder("Java SE 8");
		System.out.println(sb);
		System.out.println("Hello " + new MyString("Java SE 8"));
	}
}
