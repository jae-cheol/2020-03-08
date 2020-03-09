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
		
		boolean isSame = obj1.equals(obj2);	// obj1�� obj2�� data�ʵ尪�� �����Ƿ� equals �޼ҵ忡�� true�� ��ȯ
		System.out.println(isSame);
		
		obj1.data = 1;
		obj2.data = 2;
		
		isSame = obj1.equals(obj2);	// obj1�� obj2�� data �ʵ尪�� ���� �����Ƿ� equals �޼ҵ忡�� false�� ��ȯ
		System.out.println(isSame);
	}
}