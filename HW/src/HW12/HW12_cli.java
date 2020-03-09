package HW12;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

/*
 * ������ ������ �޼��� �Է�(����� quit) : hello
�������� �������� �޼��� : hello
������ ������ �޼��� �Է�(����� quit) : ����
�������� �������� �޼��� : ����
������ ������ �޼��� �Է�(����� quit) : bye
�������� �������� �޼��� : bye
������ ������ �޼��� �Է�(����� quit) : quit
�������� ���� ����
 */
public class HW12_cli {

	public static void main(String[] args) {

		try {
			Scanner sc = new Scanner(System.in);
			// 127.0.0.1 == localhost
			Socket socket = new Socket("localhost", 10000);

			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			
			InputStream is = socket.getInputStream();	// outputstream���� ��������� ��ǲ����.
			DataInputStream dis = new DataInputStream(is);
			while(true) {
				System.out.print("������ ������ �޽��� �Է�(����� quit) : ");
				String msg = sc.nextLine();
				dos.writeUTF(msg);
				try{
					msg = dis.readUTF();
				}catch(SocketException e){
					System.out.println("Ŭ���̾�Ʈ ����");
					break;
				}
				System.out.println("�������� �������� �޽��� : " + msg);
			}
			System.out.println("�������� ���� ����");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
