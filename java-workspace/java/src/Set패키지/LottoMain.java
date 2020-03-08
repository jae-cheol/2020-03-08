package Set패키지;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
/*
 * add()	: set안에 들어갈 내용을 추가.
 */
class LottoView {
	private Scanner sc = new Scanner(System.in);
	
	public void start() {
		System.out.print("게임수를 입력 : ");
		int gameCnt = sc.nextInt();
		for(int i = 1; i <= gameCnt; i++) {
			System.out.println("게임 " + i + " : " + getLottoNums() );
		}
	}
	
	private String getLottoNums() {
		Random r = new Random();
		Set<Integer> set = new HashSet<>();
		while(set.size() != 6) { // set.size()가 6개가 될때까지 
			set.add(r.nextInt(45) + 1); // set.add()로 계속 추가해줌.
		}
		Object[] lottoNums = set.toArray(); // set은 Set<Integer> 타입.
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
		return Arrays.toString(lottoNums); // 배열을 String형태로 바꿔줌.
	}
}

public class LottoMain {
	public static void main(String[] args) {
		LottoView view = new LottoView();
		view.start();
	}
}
