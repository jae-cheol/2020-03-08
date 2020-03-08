package WriteDown;

class A {
	int data;
	
	public boolean equals(Object o) {
		return ((A)o).data == this.data;
	}
}
public class Test29 {
	public static void main(String[] args) {
		A obj1 = new A();
		obj1.data = 1;
		
		A obj2 = new A();
		obj2.data = 1;
		
		boolean isSame = obj1.equals(obj2);	// obj1과 obj2의 data필드값이 같으므로 equals 메소드에서 true를 반환
		System.out.println(isSame);
		
		obj1.data = 1;
		obj2.data = 2;
		
		isSame = obj1.equals(obj2);	// obj1과 obj2의 data 필드값이 같지 않으므로 equals 메소드에서 false를 반환
		System.out.println(isSame);
	}
}