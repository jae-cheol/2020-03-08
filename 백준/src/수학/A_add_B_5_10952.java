package ¼öÇÐ;

import java.util.ArrayList;
import java.util.Scanner;

public class A_add_B_5_10952 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> al = new ArrayList<Integer>();
		int cnt = 0;
		while(true) {
			al.add(sc.nextInt());
			if(cnt != 0) {
				if(al.get(cnt) + al.get(cnt-1) == 0) {
					break;
				}
			}
			cnt++;
		}
		for(int i=0; i<al.size()-2; i=i+2) {
			System.out.println( al.get(i) + al.get(i+1) );
		}
	}
}
