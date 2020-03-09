package network;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class AppServerMain {
	
	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(10000);
			System.out.println("���ø����̼� ���� ����...");
			
			Socket client = server.accept();
			System.out.println("���ӵ� Ŭ���̾�Ʈ�� ���� : " + client);
			
			String msg = "������ ȯ���մϴ�.";

			OutputStream os = client.getOutputStream();
			
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeUTF(msg);
			dos.flush();
			
//			OutputStreamWriter osw = new OutputStreamWriter(os, "utf-8");	// �ѱ۷� �ٲ��ִ�
//			osw.write(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
