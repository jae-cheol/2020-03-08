package 싱글톤패턴;

public class DogMain {

	public static void main(String[] args) {
		Dog d = Dog.getInstance();
		
		System.out.println(d);
		System.out.println(Dog.getInstance());
	}
}

