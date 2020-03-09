package network;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * java EchoClientMain   192.168.1.2   10001
 * �� ��ǻ�� 192.168.1.58
 */
public class EchoClientMain {
	public static void main(String[] args) {
		
		if(args.length != 2) {
			System.out.println("��ɾ �߸��Ǿ����ϴ�.");
			System.out.println("���� : java EchoClientMain   ����IP   ��Ʈ");
			System.exit(0);
		}
		
		try {
														// ���ڿ��̴� ��Ƽ���� �ٲ���
			Socket socket = new Socket(args[0], Integer.parseInt(args[1]));
			
			// ������ ������ �޽����� Ű����� �Է¹޴� ��ü
			BufferedReader keyboard 
				= new BufferedReader(new InputStreamReader(System.in));
//			Scanner sc = new Scanner(System.in);
			
			// Ű����� �Է¹��� �޽����� ������ ������ ��ü
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw);
			
			// ������ ������ �޽����� ������ ��ü
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			while(true) {
				System.out.println("������ �޽����� �Է�(quit�Է½� ����) : ");
				String msg = keyboard.readLine();
				if(msg.equalsIgnoreCase("quit")) {
					System.out.println("�������� ���� ����");
					socket.close();
					break;
				}
				
				pw.println(msg);
				pw.flush();
				
				String echoMsg = br.readLine();
				System.out.println("�������� �������� �޽��� : [" + echoMsg + "]");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
