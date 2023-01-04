package Lesson_3_TimeComplexity;

import java.util.Arrays;

/**
 * <시간복잡성(테이프평형) - 값 | (A [0] + ... + A [P-1])-(A [P] + ... + A [N-1]) |을 최소화하십시오.>
 * 
 * 
 */
public class TapeEquilibrium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {3,1,2,4,3};	// length : 5
		
		int sum1 = 0;
		int sum2 = 0;
		int[] B = null;	// 자를배열1 : 앞에 붙는 배열
		int[] C = null;	// 자를배열2 : 뒤에 붙는 배열
		for(int i=0; i<A.length; i++) {
			if(i != 0) {
				B = Arrays.copyOfRange(A, A.length-i, A.length);
				C = Arrays.copyOfRange(A, 0, A.length-i);
				System.out.println("B.length : " + B.length);
				System.out.println("C.length : " + C.length);
//				sum1 += B[i];
//				sum2 += C[i];
			}
		}
		
	}

}
