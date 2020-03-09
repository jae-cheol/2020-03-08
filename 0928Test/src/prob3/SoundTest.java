package prob3;

class Cat implements Soundable {

	@Override
	public String sound() {
		return "\"�߿�\"";
	}
	
}
class Dog implements Soundable {

	@Override
	public String sound() {
		return "\"�۸�\"";
	}
	
}
class Sparrow implements Soundable {

	@Override
	public String sound() {
		return "\"±±\"";
	}
	
}
class Duck implements Soundable {

	@Override
	public String sound() {
		return "\"�в�\"";
	}
	
}
public class SoundTest {

	static void printSound(Soundable s) {
		System.out.println(s.sound());
	}
	public static void main(String[] args) {
		printSound( new Cat() );
		printSound( new Dog() );
		printSound( new Sparrow() );
		printSound( new Duck() );
	}
}