package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class �������ϱ�2_2751 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] N = new int[sc.nextInt()];
		
		for(int i=0;  i<N.length; i++) {
			N[i] = sc.nextInt();
		}
		
		Arrays.sort(N);
		
		for(int i=0; i<N.length; i++) {
			System.out.println(N[i]);
		}
	}
}
