package Thread;
/*
 * 얄코
 * https://www.youtube.com/watch?v=iks_Xb9DtTM
 * 
 * 라면 끓이는 섹션에 버너가 4개 있다면 스레드도 4개를 만들어서 라면이 최대 4개까지 동시에 끓여지도록 프로그래밍.
 */
public class RamenProgram {
	public static void main(String[] args) {
		try {
			RamenCook ramenCook = new RamenCook(Integer.parseInt("50"));
			new Thread(ramenCook, "A").start();
			new Thread(ramenCook, "B").start();
			new Thread(ramenCook, "C").start();
			new Thread(ramenCook, "D").start();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
/*
 * Runnable인터페이스를 구현하면 필수적으로 run() 함수를 오버라이딩해줘야함.
 * run() : 스레드에서 진행할 작업을 작성함.
 */
class RamenCook implements Runnable {
	private int ramenCount;	// 끓일 라면의 수.
	private String[] burners = {"_", "_", "_", "_"};	// 버너의 상태.
	
	public RamenCook(int count) {
		ramenCount = count;
	}
	
	@Override
	public void run() {
		/*
		 * 더 끓일 라면의 수가 0이 될 때까지 반복함.
		 */
		while(ramenCount > 0) {
			/*
			 * 한 번에 한 스레드만 손을 댈 수 있음.
			 */
			synchronized (this) {
				ramenCount--;
				System.out.print(
					Thread.currentThread().getName() + ": " + ramenCount + "개 남음"
				);
			}
			/*
			 * 버너들 4개 중 빈 것을 찾음.
			 */
			for(int i=0; i<burners.length; i++) {
				if(!burners[i].equals("_")) continue;
				
				synchronized (this) {
					/*
					 * 해당 스레드의 이름으로 버너를 차지하고 불을켜서 라면을 얹는다.
					 * 둘 이상의 스레드가 한 버너를 켜지 못하게 함.
					 */
					burners[i] = Thread.currentThread().getName();
					System.out.print(
						"     " + Thread.currentThread().getName() + ": [" + (i+1) + "]번 버너 ON"
					);
					showBurners();
				}
				
				try {
					/*
					 * 라면이 끓는 시간 
					 */
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				/*
				 * 라면이 다 끓으면 해당 버너를 끄고 비워야 함.
				 */
				synchronized (this) {
					burners[i] = "_";
					System.out.print(
						"                              " + Thread.currentThread().getName() + ": [" + (i+1) + "]번 버너 OFF"
					);
					showBurners();
				}
				break;
			}
			
			try {
				/*
				 * 스레드마다 다음 라면을 끓이기까지 걸리는 시간.
				 */
				Thread.sleep(Math.round(1000* Math.random()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * 실행되는 시점마다 버너들의 상태를 출력해줌.
	 */
	private void showBurners() {
		String stringToPrint = "                                  ";
		for(int i=0; i<burners.length; i++) {
			stringToPrint += (" " + burners[i]);
		}
		System.out.println(stringToPrint);
	}
}
