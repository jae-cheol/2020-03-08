import java.util.Scanner;
/*
 * ������(����)����, �� ���� �Ҽ� ����(3-primes problem) �� ������ ���� ������ ���Ѵ�.
 * '5���� ū ������ Ȧ���� ��Ȯ�� �� ���� �Ҽ����� ������ ��Ÿ�� �� �ִ�. ���� �ϳ��� �Ҽ��� ���� �� ���� ���� �ִ�.'
 * 7 = 2 + 2 + 3
 * 11 = 2 + 2 + 7
 * 25 = 7 + 7 + 11
 * 5���� ū ������ Ȧ���� �Է¹޾Ƽ�, �� Ȧ���� ��� �� �Ҽ��� ������ ǥ���� �� �ִ��� (�Ǵ� �Ұ�������) �˾ƺ��� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * �Ҽ��Ǻ� ���α׷� ���� �ۼ� �����ؾ���.
 * �Ҽ��� �����ΰ�? 1�� �ڱ��ڽŸ� ����� ������ ��
 */
public class ����_11502 {
	static int[] intArr = new int[100];
	static int i = 0;
	// �Ҽ����� �Ǻ�
	public static void primary(int num){
		int cnt = 0;
		for(int i=2; i<num; i++) {
			if(num % i == 0) {
				cnt++;
			}
		}
		if (cnt >0) {
			System.out.println("�Ҽ��� �ƴմϴ�.");
		}
		if(cnt==0) {
			System.out.println("�Ҽ��Դϴ�.");
		}
	}
	
	// �Ҽ����� ������ �迭
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
			System.out.println("�Ҽ��Դϴ�.");
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
			System.out.println("�Ҽ��Դϴ�.");
			intArr[i++] = num;
		}
		for(int i=0; i<intArr.length; i++) {
			System.out.println(intArr[i]);
		}
	}
}
