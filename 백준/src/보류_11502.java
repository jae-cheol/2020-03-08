import java.util.Scanner;
/*
 * 정수론(수학)에서, 세 개의 소수 문제(3-primes problem) 는 다음과 같은 추측을 말한다.
 * '5보다 큰 임의의 홀수는 정확히 세 개의 소수들의 합으로 나타낼 수 있다. 물론 하나의 소수를 여러 번 더할 수도 있다.'
 * 7 = 2 + 2 + 3
 * 11 = 2 + 2 + 7
 * 25 = 7 + 7 + 11
 * 5보다 큰 임의의 홀수를 입력받아서, 그 홀수가 어떻게 세 소수의 합으로 표현될 수 있는지 (또는 불가능한지) 알아보는 프로그램을 작성하시오.
 * 
 * 소수판별 프로그램 먼저 작성 가능해야함.
 * 소수란 무엇인가? 1과 자기자신만 약수로 가지는 수
 */
public class 보류_11502 {
	static int[] intArr = new int[100];
	static int i = 0;
	// 소수인지 판별
	public static void primary(int num){
		int cnt = 0;
		for(int i=2; i<num; i++) {
			if(num % i == 0) {
				cnt++;
			}
		}
		if (cnt >0) {
			System.out.println("소수가 아닙니다.");
		}
		if(cnt==0) {
			System.out.println("소수입니다.");
		}
	}
	
	// 소수들을 저장할 배열
	public static void pArr(int num){
		int cnt = 0;
		for(int i=2; i<num; i++) {
			for(int j=1; j<i; j++) {
				if(num % i == 0) {
					cnt++;
				}
			}
		}
		if(cnt==0) {
			System.out.println("소수입니다.");
			intArr[i++] = num;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
//		primary(num);
		int cnt = 0;
		for(int i=2; i<num; i++) {
			for(int j=1; j<i; j++) {
				if(num % i == 0) {
					cnt++;
				}
			}
		}
		if(cnt==0) {
			System.out.println("소수입니다.");
			intArr[i++] = num;
		}
		for(int i=0; i<intArr.length; i++) {
			System.out.println(intArr[i]);
		}
	}
}
