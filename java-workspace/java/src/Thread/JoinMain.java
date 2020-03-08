package Thread;

class BoyfriendThread extends Thread {
	@Override
	public void run() {
		GirlfriendThread gt = new GirlfriendThread();
		gt.start();

		System.out.println("(����ģ��) : ���� ����ģ�� �������Դϴ�.");
		System.out.println("(����ģ��) : ���� ����ģ�� ������� ��ȭ�� ����� �߽��ϴ�.");
		System.out.println("(����ģ��) : ������ ��ȭ�ð��� �󸶳��� �ʾҽ��ϴ�.");
//		System.out.println("(����ģ��) : ����ģ���� �ö����� ��ٸ��ϴ�.");
		System.out.println("(����ģ��) : ���� �γ����� 5�ʱ�����....");
		try {
			// ����ȭ join
			gt.join(1000);	// gt�������� �۾��� 5�ʾȿ� �����ų�, 5�ʰ���� block���� ����
//			gt.join();	// gt�������� �۾��� �����Ҷ����� bt�� blocking���� ����.
		} catch (InterruptedException e) {e.printStackTrace();}	
		
		System.out.println("(����ģ��) : 5�ʰ� ������... ���� ����...");
//		System.out.println("(����ģ��) : ����ģ���� ���� �Խ��ϴ�.");
//		System.out.println("(����ģ��) : ��ȭ�� �������ϴ�.");
	}
}

class GirlfriendThread extends Thread {
	@Override
	public void run() {
		System.out.println("(����ģ��) : ���� ����ģ�� �������Դϴ�.");
		System.out.println("(����ģ��) : ���� ����ģ���� �������� �׽�Ʈ�մϴ�.");
		System.out.println("(����ģ��) : 10�ʵ� ����ٸ��� ����ģ���� ���� �����ϴ°� �ƴմϴ�.");
		for(int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(200);
				System.out.println("(����ģ��) : " + i + "�ʰ� �������ϴ�. ����ģ���� ��� ��ٸ��� �������???");
			} catch (Exception e) {e.printStackTrace();}
		}
		System.out.println("(����ģ��) : ����ģ���� ����� �Ф�. �����!!!!");
	}	
}

public class JoinMain {
	public static void main(String[] args) {
		BoyfriendThread bt = new BoyfriendThread();
		bt.start();
	}
}