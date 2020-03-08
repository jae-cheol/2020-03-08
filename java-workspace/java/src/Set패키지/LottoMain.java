package Set��Ű��;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
/*
 * add()	: set�ȿ� �� ������ �߰�.
 */
class LottoView {
	private Scanner sc = new Scanner(System.in);
	
	public void start() {
		System.out.print("���Ӽ��� �Է� : ");
		int gameCnt = sc.nextInt();
		for(int i = 1; i <= gameCnt; i++) {
			System.out.println("���� " + i + " : " + getLottoNums() );
		}
	}
	
	private String getLottoNums() {
		Random r = new Random();
		Set<Integer> set = new HashSet<>();
		while(set.size() != 6) { // set.size()�� 6���� �ɶ����� 
			set.add(r.nextInt(45) + 1); // set.add()�� ��� �߰�����.
		}
		Object[] lottoNums = set.toArray(); // set�� Set<Integer> Ÿ��.
//		List<Integer> lottoNums = new ArrayList<Integer>();
//		while(lottoNums.size() != 6) {
//			int lottoNum = r.nextInt(45) + 1;
//			if(!lottoNums.contains(lottoNum)) {
//				lottoNums.add(lottoNum);
//			}
//		}
//
//		int[] lottoNums = new int[6];
//		for(int i = 0; i < lottoNums.length; i++) {
//			lottoNums[i] = r.nextInt(45) + 1;
//			for(int j = 0; j < i; j++) {
//				if(lottoNums[i] == lottoNums[j]) {
//					i--;
//					break;
//				}
//			}
//		}
		return Arrays.toString(lottoNums); // �迭�� String���·� �ٲ���.
	}
}

public class LottoMain {
	public static void main(String[] args) {
		LottoView view = new LottoView();
		view.start();
	}
}
