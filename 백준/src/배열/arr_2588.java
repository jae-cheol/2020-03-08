package �迭;

import java.util.Scanner;
/*
 * ���ڸ����� ��
 */
public class arr_2588 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int i = Integer.parseInt(sc.nextLine());
		int j = Integer.parseInt(sc.nextLine());
		
		int[] intArr = new int[3];
		
		intArr[0] = j%10;		// 1���ڸ�
		intArr[1] = j%100/10; 	// 10���ڸ�
		intArr[2] = j/100;		// 100���ڸ�
		
		for(int k=0; k<intArr.length; k++)
			System.out.println(i*intArr[k]);
		
		int sum=0;
		sum += i*intArr[0];
		sum += i*intArr[1]*10;
		sum += i*intArr[2]*100;
		
		System.out.println(sum);
	}
}
