package 로또_List;

import java.util.Arrays;

public class MC {

	public void startMent() throws Exception {
		
		System.out.println("제 XX회 비트로또 방송을 시작합니다.");
		
		Machine machine = new Machine();
		machine.start();
		
		int[] lottoNums = new int[6];
		for(int i = 0; i < 6; i++) {
			int lottoNum = machine.getBall();
			Thread.sleep(1000);
			System.out.println(i+1 + "번째 로또번호는 " + lottoNum + "입니다");
			lottoNums[i] = lottoNum;
		}
		
		System.out.println("제 XX회 로또 당첨번호는 " + Arrays.toString(lottoNums) + "입니다");
	}
}
