package WriteDown;
/*
 * String은 못바꿈. (상수라고 생각하면 됨.)
 * 원래 가르키던 값을 버리고 새로 생기는것을 가르킴.
 */
public class Test21 {

	String str = "ABC123";
	public static void change(String str) {
		str += "456";
	}
	public static void main(String[] args) {
		String str = "ABC123";
		System.out.println(str);
		change(str);
		System.out.println("After:"+str);
	}
//	String str = "ABC123";
//	public static void change(StringBuilder sb) {
//		sb.append("456");
//	}
//	public static void main(String[] args) {
//		String str = "ABC123";
//		StringBuilder sb = new StringBuilder(str);
//		System.out.println(sb.toString());
//		change(sb);
//		System.out.println("After:"+sb.toString());
//	}
}
