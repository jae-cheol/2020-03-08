package WriteDown;
/*
 * String�� ���ٲ�. (������ �����ϸ� ��.)
 * ���� ����Ű�� ���� ������ ���� ����°��� ����Ŵ.
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
