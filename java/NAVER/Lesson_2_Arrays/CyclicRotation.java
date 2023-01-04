package Lesson_2_Arrays;

import java.util.Arrays;

/**
 * <배열(순환회전) - 주어진 단계 수만큼 배열을 오른쪽으로 회전합니다.>
 * 
 * 1번회전 : 맨마지막요소가 처음으로 오고, 나머지요소가 밀린다.
 * 
 * ex1) A=[3,8,9,7,6] && K=3 -> [9,7,6,3,8]
 * ex2) A=[0,0,0] && K=1 -> [0,0,0]
 * ex3) A=[1,2,3,4] && K=4 -> [1,2,3,4]
 * ex4) A=[] && K=1 -> []
 */
public class CyclicRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {};
		int K = 1;

		System.out.println("초기 A : " + Arrays.toString(A));
		
		int[] B = null;	// 자를배열1 : 앞에 붙는 배열
		int[] C = null;	// 자를배열2 : 뒤에 붙는 배열
		
		if(A.length > 0) {	// 예외체크 : 배열이 비었을경우 로직을 수행하지 않는다.
			if(K != A.length) {	// K != 배열길이
				if(K > A.length) {	// K > 배열길이
					K = K%A.length;
				}
	
				System.out.println("K : " + K);
				System.out.println("A.length : " + A.length);
				
				/**
				 * param1 : 원본배열
				 * param2 : 시작idx
				 * param3 : 종료idx
				 */
				B = Arrays.copyOfRange(A, A.length-K, A.length);
				C = Arrays.copyOfRange(A, 0, A.length-K);
	
				System.out.println("B : " + Arrays.toString(Arrays.copyOfRange(A, A.length-K, A.length)));
				System.out.println("C : " + Arrays.toString(Arrays.copyOfRange(A, 0, A.length-K)));
	
				/**
				 * param1 : 복사하고자 하는 소스. [원본]
				 * param2 : [원본]에서 어느 부분부터 읽어올지.
				 * param3 : 복사하려는 대상. [복사본]
				 * param4 : [복사본]에서 어느 부분부터 쓸지.
				 * param5 : [원본]을 [복사본]으로 얼만큼 옮길지.
				 */
				System.arraycopy(B, 0, A, 0, B.length);
				System.arraycopy(C, 0, A, B.length, C.length);
			}
		}
		System.out.println("변경 A : " + Arrays.toString(A));
	}
}
