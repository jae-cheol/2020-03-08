package 스트링;

import java.util.ArrayList;
import java.util.Scanner;

public class 알파벳찾기_10809 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		sb.append(sc.next());
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i=0; i<sb.length(); i++) {
			al.add( (int)sb.charAt(i) );
		}
		for(int i=97; i<123; i++) {
			if(al.contains(i)) {
				System.out.print( sb.indexOf(String.valueOf((char)i)) );
				if(i != 122) {
					System.out.print(" ");
				}
			} else {
				System.out.print("-1");
				if(i != 122) {
					System.out.print(" ");
				}
			}
		}

	}

}
