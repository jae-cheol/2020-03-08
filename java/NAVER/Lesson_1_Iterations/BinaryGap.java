package Lesson_1_Iterations;
/**
 * <반복(BinaryGap) - 정수의 이진 표현에서 가장 긴 0 시퀀스를 찾습니다.>
 * 
 * [2진간격]
 * 10진수 -> 2진수 변환했을때
 * 양끝에 1로 둘러싸인 0의 갯수중에 최대값.
 * 
 * ex1) 9 -> 1001 , 2
 * ex2) 529 -> 1000010001 , 4
 * ex3) 20 -> 10100 , 1
 * ex4) 15 -> 1111 , 0
 * ex5) 32 -> 100000 , 0
 * ex6) 1041 -> 10000010001 , 5
 */
public class BinaryGap {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 32;
		StringBuilder sb = new StringBuilder(); // 2진법 변환된 값을 저장할 StringBuilder
		int cnt = 0;    // 최종 리턴값
		int tmpCnt = 0; // 리턴 임시값.
		while(true) {
//			System.out.println("N = " + N);
//			System.out.println("N/2 = " + N/2);
			System.out.println("-N%2 = " + N%2);
			// N%2 가 0인것중에 젤 긴것을 찾아야되는 미션.(0이 하나도없으면 0이 출력)
			// [2진간격 존재] 해당 조건이 만족하면 2진간격이 존재한다.
			if(sb.indexOf("1") != -1	// 문자열에서 1이 있거나,
			&& N%2 == 0) {				// 나머지가 0일때, 
				tmpCnt += 1;
				if(tmpCnt > cnt) {	// 2진간격에서 가장 큰 값이 cnt
					cnt = tmpCnt;
				}
			} else {
				tmpCnt = 0;
			}
			if(N/2 > 1) {	// 2로 나눴을때 몫 > 1
				sb.append(N%2); // start append
				N = N/2;
			} else {	// 2로 나눴을때 몫 == 0 
				sb.append(N%2); // (end-1) append
				if(N/2 > 0) {
					sb.append(N/2); // end append
				}
				break;	// 반복문 빠져나감.
			}
		}
		System.out.println(sb.reverse().toString());	// 10진 -> 2진 거꾸로 붙임.
		System.out.println("cnt : " + cnt);
	}
}
