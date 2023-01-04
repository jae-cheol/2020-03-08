package exam.code1Z0_808;
/*
 * int형은 만능이지만, short -> Long 은 형변환 필수.
 * Cannot cast from long to String
 */
public class No_112 {
	public static void main(String[] args) {
		short s1 = 200;
		Integer s2 = 400;
		Long s3 = (long)s1+s2;
//		String s4 = (String)(s3*s2);
//		System.out.println("Sum is " + s4);
	}
}
