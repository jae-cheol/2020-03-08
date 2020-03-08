package network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class SenderMain {
	public static void main(String[] args) {
		try {
			DatagramSocket socket = new DatagramSocket();	// �����»���̳� ������� ������ �־���.
			System.out.println("[�۽� ����]");
			for(int i=1; i<=3; i++) {
				String msg = "�޽���-" + i;
				byte[] bytes = msg.getBytes("utf-8");	// �ѱ��� 3����Ʈ�� �ν�.
				
				DatagramPacket packet
					= new DatagramPacket(bytes, 
										 bytes.length, 
										 new InetSocketAddress("localhost", 10002));
				Thread.sleep(1000); 
				socket.send(packet);
				System.out.println("������ �������� ũ�� : " + bytes.length);
			}
			
			System.out.println("[�۽� �Ϸ�]");
			socket.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
}
