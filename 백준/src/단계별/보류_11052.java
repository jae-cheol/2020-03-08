package �ܰ躰;

import java.util.Scanner;

public class ����_11052 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.next());
		int[] intArr = new int[N];
		for(int i=0; i<intArr.length; i++){
			intArr[i] = Integer.parseInt(sc.next());
		}
		int[] num = new int[1000];
		num[0] = intArr[0];	// 1���� �ִ밪.
		num[1] = intArr[1] > intArr[0]*2 ? intArr[1] : intArr[0]*2;	// 2���� �ִ밪.
		num[2] = intArr[2] > num[1]+num[0] ? intArr[2] : num[1]+num[0]; // 3���� �ִ밪.
		if(intArr[3] > (num[2]+num[0] | num[1]*2)){ // 4���� �ִ밪
			num[3] = intArr[3];
		} else {
			if(num[2]+num[0] > num[1]*2){
				num[3] = num[2]+num[0];
			} else {
				num[3] = num[1]*2;
			}
		}
//		if(intArr[4] > (num[3]+num[0] | num[1]+num[2])){ // 5���� �ִ밪
//			num[4] = intArr[4];
//		} else
		
		
	}
}
