package �ܰ躰;
import java.util.Scanner;

/*
 * ���� ���, A = {5,6,3,9,-1} �̾��� ��, B = {6-5, 3-6, 9-3, -1-9} = {1,-3,6,-10}�� �ȴ�. 
 * �ٸ� ���� B[i] = A[i+1]-A[i]�� �ȴ�.
 */
public class ����_1551 {
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
				if(cnt == 0) { // 4��¥��
					numB[i] = numA[i+1] - numA[i]; // ���Ⱑ ����...
				} else { // 3������¥��
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
