package 동규_12;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public static void main(String[] args){
		System.out.println("클라이언트 요청을 기다립니다....");
		try (
				ServerSocket server = new ServerSocket(10006);
				Socket client = server.accept();
				BufferedInputStream bis = new BufferedInputStream(client.getInputStream());
				BufferedOutputStream bos = new BufferedOutputStream(client.getOutputStream());
//				InputStreamReader isr = new InputStreamReader(client.getInputStream(), "utf-8");
//				BufferedReader br = new BufferedReader(isr);
//				OutputStreamWriter osw = new OutputStreamWriter(client.getOutputStream(), "utf-8");
//				BufferedWriter bw = new BufferedWriter(osw);
			){
			System.out.println("클라이언트가 접속 했습니다!");
			System.out.println("클라이언트 정보 : " + client);
			
			byte[] buffer = new byte[2048];
			while(true){
				int count = bis.read(buffer);
				if(new String(buffer, 0, count).toLowerCase().equals("quit")) break;
				System.out.println("클라이언트가 보내온 메시지 : " + new String(buffer, 0, count));
				bos.write(buffer, 0, count);
				bos.flush();
//				String msg = br.readLine();
//				if(msg.toUpperCase().equals("QUIT")) break;
//				System.out.println("클라이언트가 보내온 메시지 : " + msg);
//				bw.write(msg);
			}
			System.out.println("서버 프로그램을 종료합니다.");
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
