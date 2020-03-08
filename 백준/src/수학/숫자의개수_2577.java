package 수학;

import java.util.Scanner;

public class 숫자의개수_2577 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] n = new int[3];
		int mulSum = 1;
		for(int i=0; i<n.length; i++) {
			n[i] = sc.nextInt();
			mulSum *= n[i];
		}
		String s = String.valueOf(mulSum);
		int[] res = new int[10];
		for(int i=0; i<s.length(); i++) {
			for(int j=0; j<10; j++) {
				if(Integer.parseInt(s.substring(i, i+1)) == j) {
					res[j]++;
				}
			}
		}
		for(int i=0; i<res.length; i++) {
			System.out.println(res[i]);
		}
	}
}
