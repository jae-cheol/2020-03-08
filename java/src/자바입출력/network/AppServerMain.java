package 자바입출력.network;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class AppServerMain {
	
	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(10000);
			System.out.println("어플리케이션 서버 구동...");
			
			Socket client = server.accept();
			System.out.println("접속된 클라이언트의 정보 : " + client);
			
			String msg = "접속을 환영합니다.";

			OutputStream os = client.getOutputStream();
			
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeUTF(msg);
			dos.flush();
			
//			OutputStreamWriter osw = new OutputStreamWriter(os, "utf-8");	// 한글로 바꿔주는
//			osw.write(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
