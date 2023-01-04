package 배열;
import java.util.Arrays;
import java.util.Scanner;
/*
 * 18.05.27
 */
public class 약수_1037 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();	// 약수의 개수.
		
		int[] aliquot = new int[num];	// 약수들.
		int nMax = 0;
		for(int i=0; i<num; i++) {
			aliquot[i] = sc.nextInt();
		}
		
		Arrays.sort(aliquot);	// 정렬
				
		if(num == 1) {
			System.out.println(aliquot[0] * aliquot[0]);
		} else {
			System.out.println(aliquot[0] * aliquot[num-1]);
		}
	}
}
