package 스트링;
import java.util.Scanner;
import java.util.StringTokenizer;

public class token_1152 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String in = sc.nextLine();
		StringTokenizer st = new StringTokenizer(in, " ");
		int n = st.countTokens();
		System.out.println(n);
	}
}
