package �ܰ躰;

import java.util.Scanner;

public class char_10808 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();	// ������� ���ڸ� �Է�.
		
		int searchIdx;
		// 'a'-'a' = 0
		// 'b'-'a' = 1
		// 'c'-'a' =2
		int[] intArr = new int[26];	// ���ĺ� 26��
		int cnt=0;
		for(int i=0; i<str.length(); i++){
			int num = str.charAt(i) - 'a';
			for(int j=0; j<intArr.length; j++){
				if(j==num){
					intArr[j]++;
				}
			}
		}
		for(int i=0; i<intArr.length; i++)
			System.out.print(intArr[i] + " ");
	}
}