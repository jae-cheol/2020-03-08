package 비트교육센터;

public class SounTest {
	public static void main(String[] args) {
		printSound( new Cat() ); 
		printSound( new Dog() ); 
		printSound( new Sparrow() ); 
		printSound( new Duck() ); 
	}
	
	public static void printSound(Soundable s) {
		System.out.println(s.sound());
	}
}
class Cat implements Soundable {
	public String sound() {
		return "야옹";
	}
}
class Dog implements Soundable  {
	public String sound() {
		return "멍멍";
	}
}
class Sparrow implements Soundable  {
	public String sound() {
		return "짹짹";
	}
}
class Duck implements Soundable  {
	public String sound() {
		return "꽥꽥";
	}
}
interface Soundable { 
   public String sound();
}