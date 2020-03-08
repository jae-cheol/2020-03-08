package prob3;

class Cat implements Soundable {

	@Override
	public String sound() {
		return "\"具克\"";
	}
	
}
class Dog implements Soundable {

	@Override
	public String sound() {
		return "\"港港\"";
	}
	
}
class Sparrow implements Soundable {

	@Override
	public String sound() {
		return "\"卤卤\"";
	}
	
}
class Duck implements Soundable {

	@Override
	public String sound() {
		return "\"残残\"";
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