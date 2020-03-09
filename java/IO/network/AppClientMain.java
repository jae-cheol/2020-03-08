package network;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class AppClientMain {
	
	public static void main(String[] args) {
		
		try {
			// 127.0.0.1 == localhost
			Socket socket = new Socket("localhost", 10000);
			
			InputStream is = socket.getInputStream();	// outputstream���� ��������� ��ǲ����.
			DataInputStream dis = new DataInputStream(is);
			String msg = dis.readUTF();
			
			System.out.println("�������� ���۵� �޽��� : " + msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
