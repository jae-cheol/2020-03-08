package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Inet주소 {
	public static void main(String[] args) {
		
		try {
			InetAddress localhost = InetAddress.getLocalHost();
			System.out.println("내 컴퓨터의 네트워크 이름 : " + localhost.getHostName());
			System.out.println("내 컴퓨터의 IP 주소 : " + localhost.getHostAddress());
			
			InetAddress addr = InetAddress.getByName("www.bitacademy.com");
			System.out.println("비트교육센터의 IP주소 : " + addr);
			
			InetAddress[] addr2 = InetAddress.getAllByName("www.naver.com");
			System.out.println("네이버 IP 정보 출력");
			for(InetAddress address : addr2) {
				System.out.println(address);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
