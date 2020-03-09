/*
 * ���ʸ��� ���������� ����� ����ȯ�� ������ ����.
 * 
 * Ư�� Ÿ���� ������ ������ �ɾ���.
 */
import java.util.Random;

// AŬ������ Generic������� ��ȯ
// Type�� �������ִ� BŬ������ ����.
class B<T> {	// ó�� Ÿ���� �������ٶ� ������ ����.
	private T obj;
	
	public B() { }
	public B(T obj) { this.obj = obj; }
	
	public void setObj(T obj) { this.obj = obj; }
	public T getObj() { return this.obj; }
	
	public void info() { System.out.println("B<T> obj : " + obj); }
}

class A {
	private Object obj; // String�̸� string��, Cat�̸� cat��..... --> ������ �ɾ���ߵǼ� ���ʸ�!
	
	public A() { }
	public A(Object obj) { this.obj = obj; }
	
	public void setObj(Object obj) { this.obj = obj; }
	public Object getObj() { return obj; }
	
	public void info() { System.out.println("A obj : " + obj); }
}

public class ���ʸ� {
	public static void main(String[] args) {

		// 2�� Ÿ���� ���� ������ִ°��� ����.
		B<String> ob = new B<String>(new String("hello"));
		B<Random> ob2 = new B<Random>(new Random());
		ob.info();	// ���

		String s = ob.getObj();	// ����� ����ȯ
		// s�� "Hello" �� ��.

		System.out.println("-----------------------------------");

		A data = new A(new String("hello"));
		A data2 = new A(new Random());

		data.info();
		data2.info();

		A[] arr = new A[2];
		arr[0] = data;
		arr[1] = data2;

		for(A obj : arr) { obj.info(); }

		String str = (String)arr[0].getObj();
		System.out.println(str);

		Random r = (Random)arr[1].getObj();
		System.out.println("random : " + r.nextInt(10));
	}
}