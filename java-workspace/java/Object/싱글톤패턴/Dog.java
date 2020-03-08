package 싱글톤패턴;

/*
 * 싱글톤 패턴
 * 
 * 하나의 클래스에서 하나의 객체를 생성하는 방법.
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
