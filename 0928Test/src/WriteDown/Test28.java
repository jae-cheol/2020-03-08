package WriteDown;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

class LottoVw {
	private Scanner sc = new Scanner(System.in);
	public void start() {
		System.out.print("���Ӽ��� �Է��ϼ���(1 - 10) : ");
		int gameCount = Integer.parseInt(sc.nextLine());	// �Է¹޴� �ٸ����.
		for(int i=1; i<=gameCount; i++) {
			System.out.println("���� " + i + " : " + lottoNumber());
		}
	}
	private String lottoNumber(){
		StringBuilder sb = new StringBuilder();	// append()�Լ��� ���ֱ� ���ؼ�.
		Random ran = new Random();
		HashSet<Integer> set = new HashSet<>();
		int cnt = 0;
		while(set.size() != 6) {				// set�� ũ�Ⱑ 6�̾ƴϸ� �ݺ��϶�.
			set.add(ran.nextInt(45) + 1);		// add�Լ��� set�� �߰����ִ°�.
		}
		for(int n : set) {						// set�� Integer������ ������.
			cnt++;
			if(cnt == 6){
				sb.append(n);					// <��Ʈ������>�� ���ϴ� ��Ʈ���� �ٿ���.
			} else
				sb.append(n + ", ");
		}
		return sb.toString();					// sb�� ����Ȱ��� ����
	}
}

public class Test28 {
	public static void main(String[] args) {
		new LottoVw().start();
	}
}