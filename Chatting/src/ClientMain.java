

import java.io.IOException;

public class ClientMain {
	public static void main(String[] args){
		try {
			new Client("Lee", "localhost", 10002).connect();
		} catch (IOException e) {
			System.out.println("������ ���� �� �� �����ϴ�.(������ �� ���� ���� �� �ֽ��ϴ�)");
		}
	}
}
