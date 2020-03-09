package network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class RecieverMain {
	public static void main(String[] args) {
		try {
			DatagramSocket socket = new DatagramSocket(10002);
			System.out.println("[수신 시작]");
			
			byte[] bytes = new byte[100];
													// 헤더에 붙일 수신자의 정보가 필요없음.
			DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
			
			while(true) {
				socket.receive(packet);	// 패킷에 넣어준다.
				String msg = new String(packet.getData(), "utf-8");
				System.out.println("[수신된 내용] : " + msg);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
