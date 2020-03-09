package WriteDown;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

class LottoVw {
	private Scanner sc = new Scanner(System.in);
	public void start() {
		System.out.print("게임수를 입력하세요(1 - 10) : ");
		int gameCount = Integer.parseInt(sc.nextLine());	// 입력받는 다른방법.
		for(int i=1; i<=gameCount; i++) {
			System.out.println("게임 " + i + " : " + lottoNumber());
		}
	}
	private String lottoNumber(){
		StringBuilder sb = new StringBuilder();	// append()함수를 써주기 위해서.
		Random ran = new Random();
		HashSet<Integer> set = new HashSet<>();
		int cnt = 0;
		while(set.size() != 6) {				// set의 크기가 6이아니면 반복하라.
			set.add(ran.nextInt(45) + 1);		// add함수로 set에 추가해주는거.
		}
		for(int n : set) {						// set이 Integer형으로 되있음.
			cnt++;
			if(cnt == 6){
				sb.append(n);					// <스트링빌더>에 원하는 스트링을 붙여줌.
			} else
				sb.append(n + ", ");
		}
		return sb.toString();					// sb에 저장된것을 리턴
	}
}

public class Test28 {
	public static void main(String[] args) {
		new LottoVw().start();
	}
}