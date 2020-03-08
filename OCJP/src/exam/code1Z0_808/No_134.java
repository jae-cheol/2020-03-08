package exam.code1Z0_808;

interface Downloadable {
	public void download();
}
interface Readable1 extends Downloadable {
	public void readBook();
}
abstract class Book1 implements Readable1 {
	public void readBook() {
		System.out.println("Read Book");
	}
}
//class EBook extends Book1 {
//	public void readBook() {
//		System.out.println("Read E-Book");
//	}
//}
//
//public class No_134 {
//	public static void main(String[] args) {
//		Book1 book1 = new EBook();
//		book1.readBook();
//	}
//}