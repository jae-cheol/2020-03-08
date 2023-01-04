package 단계별;
import java.util.Scanner;

/*
 * 예를 들어, A = {5,6,3,9,-1} 이었을 때, B = {6-5, 3-6, 9-3, -1-9} = {1,-3,6,-10}이 된다. 
 * 다른 말로 B[i] = A[i+1]-A[i]가 된다.
 */
public class 보류_1551 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.next());
		int count = Integer.parseInt(sc.next());
		System.out.println(num);
		System.out.println(count);
		
		int[] numA = new int[num];
		for(int i=0; i<numA.length; i++){
			numA[i] = Integer.parseInt(sc.next());
		}
		int cnt = 0;
		int[] numB = null;
		for(int j=0; j<count; j++) { // 2 -> 0, 1
			numB = new int[--num]; // 5 -> 4, 3
			System.out.println(numB.length);
			for(int i=0; i<numB.length; i++){
				if(cnt == 0) { // 4개짜리
					numB[i] = numA[i+1] - numA[i]; // 여기가 문제...
				} else { // 3개이하짜리
					numB[i] = numB[i+1] - numB[i];
				}
				cnt++;
			}
		}
		for(int i=0; i<numB.length; i++){
			System.out.println(numB[i]);
		}
	}
}
