package �ζ�_List;

import java.util.Arrays;

public class MC {

	public void startMent() throws Exception {
		
		System.out.println("�� XXȸ ��Ʈ�ζ� ����� �����մϴ�.");
		
		Machine machine = new Machine();
		machine.start();
		
		int[] lottoNums = new int[6];
		for(int i = 0; i < 6; i++) {
			int lottoNum = machine.getBall();
			Thread.sleep(1000);
			System.out.println(i+1 + "��° �ζǹ�ȣ�� " + lottoNum + "�Դϴ�");
			lottoNums[i] = lottoNum;
		}
		
		System.out.println("�� XXȸ �ζ� ��÷��ȣ�� " + Arrays.toString(lottoNums) + "�Դϴ�");
	}
}
