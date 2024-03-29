package 배열;
import java.util.Arrays;
import java.util.Scanner;
/*
 * 18.05.27
 * 이분 탐색 - 배열안에 존재하는 값 찾을때.
 */
public class binarySearch_1920 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num1 = sc.nextInt();
		
		int[] num1Inner = new int[num1];
		for(int i=0; i<num1; i++) {
			num1Inner[i] = sc.nextInt();
		}
		Arrays.sort(num1Inner);
		
		int num2 = sc.nextInt();
		
		int[] num2Inner = new int[num2];
		for(int i=0; i<num2; i++) {
			num2Inner[i] = sc.nextInt();
		}
		
		int n = 0;
		for(int i=0; i<num2; i++) {
			n = Arrays.binarySearch(num1Inner, num2Inner[i]);
			if(n < 0) {
				System.out.println("0");
			} else {
				System.out.println("1");
			}
		}
	}
}
