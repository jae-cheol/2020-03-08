import java.util.Arrays;
import java.util.Scanner;
/*
 * �迭���� �Լ��� ������ ����
 * 
 * 
 * 
 * 
 * 1. ������ �����ؾ� �Ѵ�.
 * 	(1,1) -> (1,2) -> (1,3) -> (1,4) :	���� ����, ���� ������ �������� �̵�
 * 	(1,1) -> (2,2) -> (3,3) -> (4,4) :	��� ���� �����ϰ� �̵�
 *  (1,1) -> (2,1) -> (3,1) -> (4,1) :	���� ������ �������� �̵�, ���� ����
 *  
 * 2. �Է¹޴� ��� ������ 2���� �迭�� �����Ѵ�.
 * 	2���� �迭�� �ʱⰪ�� 0�̴ϱ�, 1 2 �� �Է����� ������ �� ������ 1�� ä���.
 */
public class �迭�Լ����ĺ���_1752 {
	public static void main(String[] args) {
		try {
			int R = 0; // row ��			1~5000
			int C = 0; // column ��, ����	1~5000
			int N = 0; // �л����� ���ڱ� ��	3~5000
			Scanner sc = new Scanner(System.in);
			R = sc.nextInt();
			C = sc.nextInt();
			int RC[][] = new int[R][C];
			N = sc.nextInt();
			int n1 = 0;
			int n2 = 0;
			for(int i=0; i<N; i++) {
				n1 = sc.nextInt();
				n2 = sc.nextInt();
				RC[n1-1][n2-1] = 1;
			}
//			for(int i=0; i<R; i++) {
//				for(int j=0; j<C; j++) {
//					System.out.print(RC[i][j] + " ");
//				}
//				System.out.println();
//			}
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(RC[n1-1][j] == 1) { // ���� ���� ���
						
					} else if(RC[i][n2-1] == 1) { // ���� ���� ���
						
					} else {
						
					}
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}
}
