import java.util.Scanner;
/*
 * 10보다 작은 수 앞에 입력으로 0 을 넣어준다는 의미는 아님.! 
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int result = 0;
		int a = 0;
		int b = 0;
		int sum = 0;
		
		if(num >= 0 && num <= 99) {
//			while(true) {
//				sum += (numInit%10 + numInit/10);
//				System.out.println("sum : " + sum);
//				if(sum == numInit) break;
//			}
			for(int i=0; i<10; i++) {
				// 입력한값이 10보다 작으면.
				if(num < 10) {
					num *= 11;
				}
				
				if(i == 0) {
					a = num/10;	// 10의 자리.
					b = num%10;	//  1의 자리. -> 새로운 10의 자리.
					sum = a + b;// 합의 1의 자리. -> 새로운 1의 자리.
					num = sum;
				} else {
					a = b/10;	// 10의 자리.
					b = sum%10;	//  1의 자리. -> 새로운 10의 자리.
					sum = a+b;
					num = sum;
				}
				
				System.out.println("result : " + result);
				if(result == num) break;
			}
			System.out.println(result);
		}
	}
}