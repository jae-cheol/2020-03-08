package exam.code1Z0_808;
 
public class No_57 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder(5);
		String s  = "";
		System.out.println(sb.capacity());
		System.out.println(s);
		System.out.println(sb);
		System.out.println(sb.toString());
		System.out.println(s.toString());
		if(sb.equals(s)) {
			System.out.println("Match 1");
		} else if(sb.toString().equals(s.toString())) {
			System.out.println("Match 2");
		} else {
			System.out.println("No Match");
		}
	}
}
