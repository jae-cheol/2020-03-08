package network;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerMain {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(10001);	// ���������� ����� ��Ʈ�� ����.
			System.out.println("Ŭ���̾�Ʈ�� ������ ��ٸ��ϴ�.");
			
			Socket client = server.accept();	// 
			System.out.println("������ Ŭ���̾�Ʈ�� ���� : [" + client.getInetAddress() + "]");
			
			// Ŭ���̾�Ʈ�� �������� �޽����� ������ ��ü
			InputStream is = client.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			// ������ �޽����� Ŭ���̾�Ʈ�� �������� ��ü
			OutputStream os = client.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
//			BufferedWriter bw = new BufferedWriter(osw);
			PrintWriter pw = new PrintWriter(osw);
			
			while(true) {
				String msg = br.readLine();
				if(msg == null) {
					System.out.println("Ŭ���̾�Ʈ�� ���� : [" + client.getInetAddress() + "]���� ��������");
					client.close();
					break;
				}

				System.out.println("[" + client.getInetAddress() + "]" + msg);
				
				pw.println(msg);
				pw.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
