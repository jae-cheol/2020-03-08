package 단계별;

import java.util.Scanner;

public class char_5598 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine(); // 입력받는 글자.
		char[] alpha = new char[26];	// 알파벳 개수
		char A = 65;
		int i;
		for(i=0; i<alpha.length; i++){
			alpha[i] = A++;
		}
		char[] changeAlpha = new char[26];
		A = 65;
		char D = 68;
		int j;
		for(j=0; j<changeAlpha.length; j++) {
			if(j>22){
				changeAlpha[j] = A++;
			} else {
				changeAlpha[j] = D++;			
			}
		}
		for(int k=0; k<str.length(); k++){
			for(j=0; j<changeAlpha.length; j++){
				if(changeAlpha[j] == str.charAt(k)){
					System.out.print(alpha[j]);
				}
			}
		}
	}
}