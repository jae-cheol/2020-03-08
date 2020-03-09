package HW12;

import java.util.Random;

/*
 * 2. ȫ���� �߻��ؼ� ������� �߻��߽��ϴ�.
��۱��� ���� ������ ����մϴ�.
����� �ݼ��� 1-4������ ��ȭ�� �ɾ� ������ ���ֽñ⸦�ٶ��ϴ�.
����� ����Ǹ� ��ݵ� ���� �Ѿ��� �˷��帮�ڽ��ϴ�.

��������>
1-4�������� �ݼ��ʹ� ���� 10���� ��ȭ�� ���� �� �ֽ��ϴ�.
������ 1000-10000�����̷� 1000�������� �����ϰ� ����ȴٰ� ����.
�� �ݼ��Ϳ����� 10���� ��ȭ�� ���� �� �� �ݼ����� �Ѽ����� ����ϰ� 4���� �ݼ��� �Ѿ��� ���

 */
class Sync {
	private int m = 0;
	public int donation() {
		Random r = new Random();
		int num = (r.nextInt(10) + 1) * 1000;
		return num;
	}

	public int getM() {
		return m;
	}

	public void a() {
		int cnt = 0, sum = 0, temp=0;
		for (int i = 0; i < 10; i++) {
			System.out.println("1�� �ݼ��� : " + donation() + "���� �޾ҽ��ϴ�.");
			cnt++;
			temp = donation();
			synchronized(this){
				m += temp;
			}
			sum += temp;
			if (cnt == 10) {
				System.out.println("1�� �ݼ��Ϳ����� �� ��ݾ� : " + sum);
			}
		}
	}

	public void b() {
		int cnt = 0, sum = 0, temp=0;
		for (int i = 0; i < 10; i++) {
			System.out.println("2�� �ݼ��� : " + donation() + "���� �޾ҽ��ϴ�.");
			cnt++;
			temp = donation();
			synchronized(this){
				m += temp;
			}
			sum += temp;
			if (cnt == 10) {
				System.out.println("2�� �ݼ��Ϳ����� �� ��ݾ� : " + sum);
			}
		}
	}

	public void c() {
		int cnt = 0, sum = 0, temp=0;
		for (int i = 0; i < 10; i++) {
			System.out.println("3�� �ݼ��� : " + donation() + "���� �޾ҽ��ϴ�.");
			cnt++;
			temp = donation();
			synchronized(this){
				m += temp;
			}
			sum += temp;
			if (cnt == 10) {
				System.out.println("3�� �ݼ��Ϳ����� �� ��ݾ� : " + sum);
			}
		}
	}

	public void d() {
		int cnt = 0, sum = 0, temp=0;
		for (int i = 0; i < 10; i++) {
			System.out.println("4�� �ݼ��� : " + donation() + "���� �޾ҽ��ϴ�.");
			cnt++;
			temp = donation();
			synchronized(this){
				m += temp;
			}
			sum += temp;
			if (cnt == 10) {
				System.out.println("4�� �ݼ��Ϳ����� �� ��ݾ� : " + sum);
			}
		}
	}
}

class SyncThread extends Thread {
	private Sync sync;
	private int type;

	public SyncThread(Sync sync, int type) {
		super();
		this.sync = sync;
		this.type = type;
	}

	@Override
	public void run() {
		switch (type) {
		case 1:
			sync.a();
			break;
		case 2:
			sync.b();
			break;
		case 3:
			sync.c();
			break;
		case 4:
			sync.d();
			break;
		}
	}
}

public class HW12_2 {

	public static void main(String[] args) {
		System.out.println("��ȭ��ȣ 1 - 4������ 1000�� ~ 10000�����̷� �ݾ��� �����ֽñ� �ٶ��ϴ�.");
		Sync sync = new Sync();

		SyncThread st = new SyncThread(sync, 1);
		SyncThread st2 = new SyncThread(sync, 2);
		SyncThread st3 = new SyncThread(sync, 3);
		SyncThread st4 = new SyncThread(sync, 4);

		st.start();
		st2.start();
		st3.start();
		st4.start();

		try {
			st.join();
			st2.join();
			st3.join();
			st4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("�� �ŵ� ����");
		System.out.println(sync.getM());
	}
}
