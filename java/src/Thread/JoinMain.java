package Thread;

class BoyfriendThread extends Thread {
	@Override
	public void run() {
		GirlfriendThread gt = new GirlfriendThread();
		gt.start();

		System.out.println("(남자친구) : 나는 남자친구 스레드입니다.");
		System.out.println("(남자친구) : 오늘 여차친구 스레드와 영화를 보기로 했습니다.");
		System.out.println("(남자친구) : 예매한 영화시간이 얼마남지 않았습니다.");
//		System.out.println("(남자친구) : 여자친구가 올때까지 기다립니다.");
		System.out.println("(남자친구) : 나의 인내심은 5초까지야....");
		try {
			// 동기화 join
			gt.join(1000);	// gt스레드의 작업이 5초안에 끝나거나, 5초경과시 block상태 해제
//			gt.join();	// gt스레드의 작업이 종료할때까지 bt는 blocking상태 유지.
		} catch (InterruptedException e) {e.printStackTrace();}	
		
		System.out.println("(남자친구) : 5초가 지났어... 집에 간다...");
//		System.out.println("(남자친구) : 여자친구가 드디어 왔습니다.");
//		System.out.println("(남자친구) : 영화를 보러갑니다.");
	}
}

class GirlfriendThread extends Thread {
	@Override
	public void run() {
		System.out.println("(여자친구) : 나는 여자친구 스레드입니다.");
		System.out.println("(여자친구) : 오늘 남자친구의 애정도를 테스트합니다.");
		System.out.println("(여자친구) : 10초도 못기다리는 남자친구는 나를 좋아하는게 아닙니다.");
		for(int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(200);
				System.out.println("(여자친구) : " + i + "초가 지났습니다. 남자친구가 계속 기다리고 있을까요???");
			} catch (Exception e) {e.printStackTrace();}
		}
		System.out.println("(여자친구) : 남자친구가 없어요 ㅠㅠ. 헤어져!!!!");
	}	
}

public class JoinMain {
	public static void main(String[] args) {
		BoyfriendThread bt = new BoyfriendThread();
		bt.start();
	}
}