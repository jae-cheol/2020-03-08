package Lesson_3_TimeComplexity;

/**
 * <시간복잡성(개구리) - 위치 X에서 Y까지 최소 점프 횟수를 계산합니다.>
 * 
 * 개구리의 점프 능력 : D
 * 현재 위치 : X
 * 도달할 위치 : Y
 * 
 */
public class FrogJmp_math100 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int X = 3;	// 현재 위치
		int Y = 3;	// 도달하고자하는 위치
		int D = 7;	// 개구리의 점프 능력

		/**
		 * 1번방안.
		 * ceil() : 올림함수 - 전달된 실수의 소수 부분을 무조건 올림.
		 */
		System.out.println("result : " + (int) Math.ceil((Y - X) / (double) D) );

		/**
		 * 2번방안.
		 * 수학적 계산.
		 */
        int distance = Y - X;
        System.out.println(0%7);	// % : 0%정수 = 0이다.
        System.out.println(0/7);	// % : 0/정수 = 0이다.
		System.out.println("result : " + (distance%D == 0 ? distance/D : distance/D + 1) );
	}

}
