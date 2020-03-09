package �̱�������;

/*
 * �̱��� ����
 * 
 * �ϳ��� Ŭ�������� �ϳ��� ��ü�� �����ϴ� ���.
 */
// singleton pattern
public class Dog {

	private String name;
	private int age;
//	private static Dog obj = null;
	private static final Dog obj = new Dog();
	
	private Dog() {
		
	}
	
	public static Dog getInstance() {
		
//		if(obj == null) {
//			obj = new Dog();
//		}
		
		return obj;
	}
}
