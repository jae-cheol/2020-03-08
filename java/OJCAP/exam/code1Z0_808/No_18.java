package exam.code1Z0_808;
/*
 * == : Call By Reference
 * 		같은 주소값인지를 비교함.
 */
public class No_18 {

	public static void main(String[] args) {
		StringBuilder sb1 = new StringBuilder("Duke");
		String str1 = sb1.toString();
		//String str2 = str1;
		String str2 = new String(str1);
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str1==str2);
	}

}
