package ����_12;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public static void main(String[] args){
		System.out.println("Ŭ���̾�Ʈ ��û�� ��ٸ��ϴ�....");
		try (
				ServerSocket server = new ServerSocket(10006);
				Socket client = server.accept();
				BufferedInputStream bis = new BufferedInputStream(client.getInputStream());
				BufferedOutputStream bos = new BufferedOutputStream(client.getOutputStream());
//				InputStreamReader isr = new InputStreamReader(client.getInputStream(), "utf-8");
//				BufferedReader br = new BufferedReader(isr);
//				OutputStreamWriter osw = new OutputStreamWriter(client.getOutputStream(), "utf-8");
//				BufferedWriter bw = new BufferedWriter(osw);
			){
			System.out.println("Ŭ���̾�Ʈ�� ���� �߽��ϴ�!");
			System.out.println("Ŭ���̾�Ʈ ���� : " + client);
			
			byte[] buffer = new byte[2048];
			while(true){
				int count = bis.read(buffer);
				if(new String(buffer, 0, count).toLowerCase().equals("quit")) break;
				System.out.println("Ŭ���̾�Ʈ�� ������ �޽��� : " + new String(buffer, 0, count));
				bos.write(buffer, 0, count);
				bos.flush();
//				String msg = br.readLine();
//				if(msg.toUpperCase().equals("QUIT")) break;
//				System.out.println("Ŭ���̾�Ʈ�� ������ �޽��� : " + msg);
//				bw.write(msg);
			}
			System.out.println("���� ���α׷��� �����մϴ�.");
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
