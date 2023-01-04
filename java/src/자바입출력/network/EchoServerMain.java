package 자바입출력.network;

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
			ServerSocket server = new ServerSocket(10001);	// 서버소켓을 만들고 포트를 생성.
			System.out.println("클라이언트의 접속을 기다립니다.");
			
			Socket client = server.accept();	// 
			System.out.println("접속한 클라이언트의 정보 : [" + client.getInetAddress() + "]");
			
			// 클라이언트가 전송해준 메시지를 수신할 객체
			InputStream is = client.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			// 수신한 메시지를 클라이언트에 재전송할 객체
			OutputStream os = client.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
//			BufferedWriter bw = new BufferedWriter(osw);
			PrintWriter pw = new PrintWriter(osw);
			
			while(true) {
				String msg = br.readLine();
				if(msg == null) {
					System.out.println("클라이언트의 정보 : [" + client.getInetAddress() + "]와의 접속해제");
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
