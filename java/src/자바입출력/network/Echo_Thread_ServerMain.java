package 자바입출력.network;

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
 * 클라이언트는 바뀔 필요가없음.
 */
class EchoThread extends Thread {

	private Socket socket;

	public EchoThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		InetAddress client = socket.getInetAddress();
		System.out.println("클라이언트 [" + client + "] 접속했습니다.");

		try {
			// 클라이언트가 전송해준 메시지를 수신할 객체
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			// 수신한 메시지를 클라이언트에 재전송할 객체
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			// BufferedWriter bw = new BufferedWriter(osw);
			PrintWriter pw = new PrintWriter(osw);
			
			while(true) {
				String msg = br.readLine();
				if(msg == null) {
					System.out.println("클라이언트 [" + client + "]와의 접속이 해제되었습니다.");
					socket.close();
					break;
				}
				System.out.println("[ " + client + " ]에서 수신된 메시지 : " + msg);
				
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

		System.out.println("EchoServer를 구동합니다...");

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
