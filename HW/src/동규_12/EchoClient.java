package ����_12;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
		try (
				Socket sock = new Socket("localhost", 10006);
				BufferedInputStream bis = new BufferedInputStream(sock.getInputStream());
				BufferedOutputStream bos = new BufferedOutputStream(sock.getOutputStream());
//				InputStreamReader isr = new InputStreamReader(sock.getInputStream(), "utf-8");
//				BufferedReader br = new BufferedReader(isr);
//				OutputStreamWriter osw = new OutputStreamWriter(sock.getOutputStream(), "utf-8");
//				BufferedWriter bw = new BufferedWriter(osw);
			){
			
			byte[] buffer = new byte[2048];
			while(true){
				System.out.print("�޼����� �Է��ϼ��� : ");
				String msg = sc.nextLine();
				bos.write(msg.getBytes());
				bos.flush();
				int count = bis.read(buffer);
				if(count == -1) break;
				System.out.println("�������� �� ������ �޽��� :" + new String(buffer, 0, count));
//				System.out.print("�޼����� �Է��ϼ��� : ");
//				bw.write(sc.nextLine());
//				System.out.println("������ �޽����� ���½��ϴ�.");
//				String msg = br.readLine();
//				if(msg == null) break;
//				System.out.println("�������� �� ������ �޽��� :" + msg);
			}
			System.out.println("Ŭ���̾�Ʈ�� �����մϴ�.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		sc.close();
	}
}
