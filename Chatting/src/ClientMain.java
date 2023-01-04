

import java.io.IOException;

public class ClientMain {
	public static void main(String[] args){
		try {
			new Client("Lee", "localhost", 10002).connect();
		} catch (IOException e) {
			System.out.println("서버에 접속 할 수 없습니다.(서버가 비 구동 중일 수 있습니다)");
		}
	}
}
