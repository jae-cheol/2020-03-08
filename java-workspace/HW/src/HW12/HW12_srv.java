package HW12;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 접속한 클라이언트의 정보 : [/127.0.0.1]
전송된 메세지 : hello
전송된 메세지 : 하이
전송된 메세지 : bye
/127.0.0.1 연결을 종료합니다.
 */
public class HW12_srv {

	public static void main(String[] args) {

		try {
			ServerSocket server = new ServerSocket(10000);
			System.out.println("클라이언트의 요청을 기다립니다.");

			Socket client = server.accept();
			System.out.println("접속된 클라이언트의 정보 : " + client.getLocalAddress());
			
			String msg = null;
			OutputStream os = client.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			
			InputStream is = client.getInputStream();	// outputstream으로 날라왔으니 인풋으로.
			DataInputStream dis = new DataInputStream(is);
			while (true) {
				msg = dis.readUTF();
				if(msg.equals("quit")) {
					System.out.println("서버를 종료합니다.");
					server.close();
					break;
				}
				dos.writeUTF(msg);
				System.out.println("전송된 메시지 : " + msg);
			}
			System.out.println(client.getLocalAddress() + " 연결을 종료합니다.");
			// OutputStreamWriter osw = new OutputStreamWriter(os, "utf-8"); //
			// 한글로 바꿔주는
			// osw.write(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
