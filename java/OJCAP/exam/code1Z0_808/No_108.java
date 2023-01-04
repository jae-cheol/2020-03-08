package exam.code1Z0_808;
/*
 * isEmpty() : lenth() 가 0이어야한다.
 */
public class No_108 extends A{
	public static void main(String[] args) {
		String str = " ";
		str.trim();
		System.out.println(str.length());
		System.out.println(str.equals("") + " " + str.isEmpty());
	}
}
