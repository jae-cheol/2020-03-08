package exam.code1Z0_808;
/*
 * String - immutable - 변경불가 - 새로운 문자열이 생성됨ex.substring()
 * 
 * StringBuilder, StringBuffer - mutable - 변경자유로움 
 */
public class No_131 {
	public static String maskCC(String creditCard) {
		String x = "XXXX-XXXX-XXXX-";
//		StringBuilder sb = new StringBuilder(creditCard);
//		sb.substring(15, 19);
//		return x+sb;
//		return x + creditCard.substring(15, 19);
//		StringBuilder sb = new StringBuilder(x);
//		sb.append(creditCard, 15, 19);
//		return sb.toString();
		StringBuilder sb = new StringBuilder(creditCard);
		StringBuilder s = sb.insert(0, x);
		return s.toString();
	}
	public static void main(String[] args) {
		// 함수명으로 호출하기 위해선 static함수여야 한다.
//		No_131 n = new No_131();
//		System.out.println(n.maskCC("1234-5678-9101-1121"));
		System.out.println(maskCC("1234-5678-9101-1121"));
	}
}
