import java.util.Scanner;
/*
 * 10���� ���� �� �տ� �Է����� 0 �� �־��شٴ� �ǹ̴� �ƴ�.! 
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
				// �Է��Ѱ��� 10���� ������.
				if(num < 10) {
					num *= 11;
				}
				
				if(i == 0) {
					a = num/10;	// 10�� �ڸ�.
					b = num%10;	//  1�� �ڸ�. -> ���ο� 10�� �ڸ�.
					sum = a + b;// ���� 1�� �ڸ�. -> ���ο� 1�� �ڸ�.
					num = sum;
				} else {
					a = b/10;	// 10�� �ڸ�.
					b = sum%10;	//  1�� �ڸ�. -> ���ο� 10�� �ڸ�.
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