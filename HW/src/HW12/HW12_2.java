package HW12;

import java.util.Random;

/*
 * 2. 홍수가 발생해서 이재민이 발생했습니다.
방송국을 통해 성금을 모금합니다.
방송중 콜센터 1-4번까지 전화를 걸어 성금을 해주시기를바랍니다.
방송이 종료되면 모금된 성금 총액을 알려드리겠습니다.

제약조건>
1-4번까지의 콜센터는 각각 10통의 전화를 받을 수 있습니다.
성금은 1000-10000원사이로 1000원단위로 랜덤하게 추출된다고 가정.
각 콜센터에서는 10통의 전화를 받은 후 각 콜센터의 총성금을 출력하고 4개의 콜센터 총액을 출력

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
			System.out.println("1번 콜센터 : " + donation() + "원을 받았습니다.");
			cnt++;
			temp = donation();
			synchronized(this){
				m += temp;
			}
			sum += temp;
			if (cnt == 10) {
				System.out.println("1번 콜센터에서의 총 모금액 : " + sum);
			}
		}
	}

	public void b() {
		int cnt = 0, sum = 0, temp=0;
		for (int i = 0; i < 10; i++) {
			System.out.println("2번 콜센터 : " + donation() + "원을 받았습니다.");
			cnt++;
			temp = donation();
			synchronized(this){
				m += temp;
			}
			sum += temp;
			if (cnt == 10) {
				System.out.println("2번 콜센터에서의 총 모금액 : " + sum);
			}
		}
	}

	public void c() {
		int cnt = 0, sum = 0, temp=0;
		for (int i = 0; i < 10; i++) {
			System.out.println("3번 콜센터 : " + donation() + "원을 받았습니다.");
			cnt++;
			temp = donation();
			synchronized(this){
				m += temp;
			}
			sum += temp;
			if (cnt == 10) {
				System.out.println("3번 콜센터에서의 총 모금액 : " + sum);
			}
		}
	}

	public void d() {
		int cnt = 0, sum = 0, temp=0;
		for (int i = 0; i < 10; i++) {
			System.out.println("4번 콜센터 : " + donation() + "원을 받았습니다.");
			cnt++;
			temp = donation();
			synchronized(this){
				m += temp;
			}
			sum += temp;
			if (cnt == 10) {
				System.out.println("4번 콜센터에서의 총 모금액 : " + sum);
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
		System.out.println("전화번호 1 - 4번까지 1000원 ~ 10000원사이로 금액을 보내주시길 바랍니다.");
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
		
		System.out.println("총 거둔 세금");
		System.out.println(sync.getM());
	}
}
