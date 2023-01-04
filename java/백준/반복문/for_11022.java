package 반복문;

import java.util.Scanner;

public class for_11022 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.next());
		
		int[] intArr = new int[T*2];
		int[] sum = new int[T];
		int cnt = 0;
		for(int i=0; i<intArr.length; i=i+2) {
			intArr[i] = Integer.parseInt(sc.next());
			intArr[i+1] = Integer.parseInt(sc.next());
			sum[cnt] = intArr[i] + intArr[i+1];
			cnt++;
		}
		
		for(int i=0; i<T; i++){
			System.out.println("Case #" + (i+1) + ": " + intArr[i*2] + " + " + intArr[i*2+1] + " = " + sum[i]);
		}
	}
}
