package �迭;

import java.util.Scanner;

public class arr2_10874 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.next()); // �л����
		int[][] intArr = new int[num][10];	// �л� ���� ����.
		for(int i=0; i<num; i++){	// i = 0~num
			for(int j=0; j<intArr[i].length; j++){	// j = 0~10
				intArr[i][j] = Integer.parseInt(sc.next());
			}
		}
		int[] intArrr = new int[100];	// �л���ȣ�� ������ �迭.
		int cnt = 0;
		int cntt = 0;
		for(int i=0; i<num; i++){
			for(int j=0; j<10; j++){
				if(intArr[i][j] == ((j%5)+1)){
					cnt++;
					if(cnt==10){
						intArrr[cntt++] = i+1;
					}
				}
			}
			cnt=0;
		}
		for(int i=0; i<cntt; i++){
			System.out.println(intArrr[i]);
		}
	}
}