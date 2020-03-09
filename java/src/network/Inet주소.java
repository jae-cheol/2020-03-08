package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Inet�ּ� {
	public static void main(String[] args) {
		
		try {
			InetAddress localhost = InetAddress.getLocalHost();
			System.out.println("�� ��ǻ���� ��Ʈ��ũ �̸� : " + localhost.getHostName());
			System.out.println("�� ��ǻ���� IP �ּ� : " + localhost.getHostAddress());
			
			InetAddress addr = InetAddress.getByName("www.bitacademy.com");
			System.out.println("��Ʈ���������� IP�ּ� : " + addr);
			
			InetAddress[] addr2 = InetAddress.getAllByName("www.naver.com");
			System.out.println("���̹� IP ���� ���");
			for(InetAddress address : addr2) {
				System.out.println(address);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}