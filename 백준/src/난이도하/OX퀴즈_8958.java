package 난이도하;

import java.util.Scanner;

public class OX퀴즈_8958 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCnt = sc.nextInt();
		String[] OX = new String[testCnt];
		int[] result = new int[testCnt];
		
		int partialSum = 0;
		
		for(int i=0; i<testCnt; i++) {
			partialSum = 0;
			OX[i] = sc.next();
			for(int j=0; j<OX[i].length(); j++) {
				if(OX[i].charAt(j) == 'O') {
					result[i] += ++partialSum;
				} else {
					partialSum = 0;
				}
			}
		}
		
		for(int i=0; i<testCnt; i++) {
			System.out.println(result[i]);
		}
	}
}
