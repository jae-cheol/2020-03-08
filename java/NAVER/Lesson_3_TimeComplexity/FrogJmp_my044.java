package Lesson_3_TimeComplexity;

/**
 * <시간복잡성(개구리) - 위치 X에서 Y까지 최소 점프 횟수를 계산합니다.>
 * 
 * 개구리의 점프 능력 : D
 * 현재 위치 : X
 * 도달할 위치 : Y
 * 
 */
public class FrogJmp_my044 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int X = 3;	// 현재 위치
		int Y = 999111321;	// 도달하고자하는 위치
		int D = 7;	// 개구리의 점프 능력

		int cnt = 1;
		if(X >= Y) {
			cnt = 0;
		} else {
			while(true) {
				X = D + X;
//				System.out.println("X : " + X);
				if(X >= Y) {
					break;
				}
				cnt++;
			}
		}
		System.out.println("cnt : " + cnt);
	}

}
