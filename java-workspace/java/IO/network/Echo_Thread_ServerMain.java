package network;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * Ŭ���̾�Ʈ�� �ٲ� �ʿ䰡����.
 */
class EchoThread extends Thread {

	private Socket socket;

	public EchoThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		InetAddress client = socket.getInetAddress();
		System.out.println("Ŭ���̾�Ʈ [" + client + "] �����߽��ϴ�.");

		try {
			// Ŭ���̾�Ʈ�� �������� �޽����� ������ ��ü
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			// ������ �޽����� Ŭ���̾�Ʈ�� �������� ��ü
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			// BufferedWriter bw = new BufferedWriter(osw);
			PrintWriter pw = new PrintWriter(osw);
			
			while(true) {
				String msg = br.readLine();
				if(msg == null) {
					System.out.println("Ŭ���̾�Ʈ [" + client + "]���� ������ �����Ǿ����ϴ�.");
					socket.close();
					break;
				}
				System.out.println("[ " + client + " ]���� ���ŵ� �޽��� : " + msg);
				
				pw.println(msg);
				pw.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

public class Echo_Thread_ServerMain {
	public static void main(String[] args) {

		System.out.println("EchoServer�� �����մϴ�...");

		try {
			ServerSocket server = new ServerSocket(10001);

			while (true) {
				Socket client = server.accept();

				EchoThread et = new EchoThread(client);
				et.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
