package exam.code1Z0_808;
/*
 * 추상메소드는 반드시 오버라이딩해서 구현해야 한다.
 * 그렇지 않으면, 다시 추상클래스로 만들어야 한다.
 * 1) 추상 클래스의 일부.
 * 2) 인터페이스의 모든 메소드.
 */
interface Readable {
	public void readBook();
	public void setBookMark();
}
abstract class Book implements Readable {
	public void readBook() {}
}
//class EBook extends Book {
//	public void readBook() {}
//}
public class No_130 {
	public static void main(String[] args) {
	}
}
