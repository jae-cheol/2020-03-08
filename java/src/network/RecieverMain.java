package network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class RecieverMain {
	public static void main(String[] args) {
		try {
			DatagramSocket socket = new DatagramSocket(10002);
			System.out.println("[���� ����]");
			
			byte[] bytes = new byte[100];
													// ����� ���� �������� ������ �ʿ����.
			DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
			
			while(true) {
				socket.receive(packet);	// ��Ŷ�� �־��ش�.
				String msg = new String(packet.getData(), "utf-8");
				System.out.println("[���ŵ� ����] : " + msg);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
