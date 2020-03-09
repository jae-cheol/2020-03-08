package HW12;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * ������ Ŭ���̾�Ʈ�� ���� : [/127.0.0.1]
���۵� �޼��� : hello
���۵� �޼��� : ����
���۵� �޼��� : bye
/127.0.0.1 ������ �����մϴ�.
 */
public class HW12_srv {

	public static void main(String[] args) {

		try {
			ServerSocket server = new ServerSocket(10000);
			System.out.println("Ŭ���̾�Ʈ�� ��û�� ��ٸ��ϴ�.");

			Socket client = server.accept();
			System.out.println("���ӵ� Ŭ���̾�Ʈ�� ���� : " + client.getLocalAddress());
			
			String msg = null;
			OutputStream os = client.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			
			InputStream is = client.getInputStream();	// outputstream���� ��������� ��ǲ����.
			DataInputStream dis = new DataInputStream(is);
			while (true) {
				msg = dis.readUTF();
				if(msg.equals("quit")) {
					System.out.println("������ �����մϴ�.");
					server.close();
					break;
				}
				dos.writeUTF(msg);
				System.out.println("���۵� �޽��� : " + msg);
			}
			System.out.println(client.getLocalAddress() + " ������ �����մϴ�.");
			// OutputStreamWriter osw = new OutputStreamWriter(os, "utf-8"); //
			// �ѱ۷� �ٲ��ִ�
			// osw.write(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
