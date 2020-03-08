

import java.io.IOException;
public class ServerMain {
	public static void main(String[] args){
		try {
			new Server(10002).start();
		} catch (IOException e) {
			System.out.println("서버 구동에 실패 했습니다.");
		}
	}
}
