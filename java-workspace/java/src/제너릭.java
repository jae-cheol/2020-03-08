/*
 * 제너릭은 내부적으로 명시적 형변환을 가지고 있음.
 * 
 * 특정 타입이 들어가도록 제약을 걸어줌.
 */
import java.util.Random;

// A클래스를 Generic방식으로 변환
// Type을 가지고있는 B클래스를 만듬.
class B<T> {	// 처음 타입을 지정해줄때 설정을 해줌.
	private T obj;
	
	public B() { }
	public B(T obj) { this.obj = obj; }
	
	public void setObj(T obj) { this.obj = obj; }
	public T getObj() { return this.obj; }
	
	public void info() { System.out.println("B<T> obj : " + obj); }
}

class A {
	private Object obj; // String이면 string만, Cat이면 cat만..... --> 제약을 걸어줘야되서 제너릭!
	
	public A() { }
	public A(Object obj) { this.obj = obj; }
	
	public void setObj(Object obj) { this.obj = obj; }
	public Object getObj() { return obj; }
	
	public void info() { System.out.println("A obj : " + obj); }
}

public class 제너릭 {
	public static void main(String[] args) {

		// 2개 타입을 따로 만들어주는것이 가능.
		B<String> ob = new B<String>(new String("hello"));
		B<Random> ob2 = new B<Random>(new Random());
		ob.info();	// 출력

		String s = ob.getObj();	// 명시적 형변환
		// s에 "Hello" 가 들어감.

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