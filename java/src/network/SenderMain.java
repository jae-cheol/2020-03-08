package network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class SenderMain {
	public static void main(String[] args) {
		try {
			DatagramSocket socket = new DatagramSocket();	// 보내는사람이나 받을사람 정보를 넣어줌.
			System.out.println("[송신 시작]");
			for(int i=1; i<=3; i++) {
				String msg = "메시지-" + i;
				byte[] bytes = msg.getBytes("utf-8");	// 한글을 3바이트로 인식.
				
				DatagramPacket packet
					= new DatagramPacket(bytes, 
										 bytes.length, 
										 new InetSocketAddress("localhost", 10002));
				Thread.sleep(1000); 
				socket.send(packet);
				System.out.println("전송한 데이터의 크기 : " + bytes.length);
			}
			
			System.out.println("[송신 완료]");
			socket.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
}
