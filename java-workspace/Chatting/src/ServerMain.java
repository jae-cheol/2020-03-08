

import java.io.IOException;
public class ServerMain {
	public static void main(String[] args){
		try {
			new Server(10002).start();
		} catch (IOException e) {
			System.out.println("���� ������ ���� �߽��ϴ�.");
		}
	}
}
