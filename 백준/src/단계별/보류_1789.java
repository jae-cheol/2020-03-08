package 단계별;

import java.util.Scanner;

public class 보류_1789 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int S = Integer.parseInt(sc.next());
		
		int[] s = new int[100];
		s[0] = 1;
		for(int i=0; i<s.length; i++){
			s[i+1] = s[i] + (i+2);	// 배열에 값 대입.
			System.out.println(s[i+1]);
		}
	}
}
