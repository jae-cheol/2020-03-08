package Lesson_3_TimeComplexity;

/**
 * <시간복잡성(파마미싱엘렘) - 주어진 순열에서 누락 된 요소를 찾습니다.>
 * 
 * A배열에는 1~N까지의 숫자가 들어있다.
 * 누락된 값을 찾아라. 
 * 
 */
public class PermMissingElem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2,3,1,5};	// length : 4
		
		int sum = 0;
		int numSum = A.length+1;
		for(int i=0; i<A.length; i++) {
			sum += A[i];
			numSum += (i+1);
		}
		
		System.out.println("sum : " + sum);
		System.out.println("numSum : " + numSum);
		System.out.println("A.length : " + A.length);
		System.out.println("result : " + (numSum - sum));
		
	}

}
