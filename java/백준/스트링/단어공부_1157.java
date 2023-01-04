package 스트링;

import java.util.Scanner;

public class 단어공부_1157 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String word = sc.next().toUpperCase();
		int[] alphabet = new int[26];
		int max = 0;
		char result = ' ';
		
		for(int i=0; i<word.length(); i++) {
			alphabet[(int)word.charAt(i) - 65] += 1;
		}
		for(int i=0; i<alphabet.length; i++) {
			if(alphabet[i] != 0) {
				if(alphabet[i] > max) {
					result = (char)('A'+i);
					max = alphabet[i];
				} else if(alphabet[i] == max) {
					result = '?';
					max = alphabet[i];
				}
			}
		}
		System.out.println(result);
	}
}
