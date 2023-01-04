package 동규_12;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
		try (
				Socket sock = new Socket("localhost", 10006);
				BufferedInputStream bis = new BufferedInputStream(sock.getInputStream());
				BufferedOutputStream bos = new BufferedOutputStream(sock.getOutputStream());
//				InputStreamReader isr = new InputStreamReader(sock.getInputStream(), "utf-8");
//				BufferedReader br = new BufferedReader(isr);
//				OutputStreamWriter osw = new OutputStreamWriter(sock.getOutputStream(), "utf-8");
//				BufferedWriter bw = new BufferedWriter(osw);
			){
			
			byte[] buffer = new byte[2048];
			while(true){
				System.out.print("메세지를 입력하세요 : ");
				String msg = sc.nextLine();
				bos.write(msg.getBytes());
				bos.flush();
				int count = bis.read(buffer);
				if(count == -1) break;
				System.out.println("서버에서 재 전송한 메시지 :" + new String(buffer, 0, count));
//				System.out.print("메세지를 입력하세요 : ");
//				bw.write(sc.nextLine());
//				System.out.println("서버로 메시지를 보냈습니다.");
//				String msg = br.readLine();
//				if(msg == null) break;
//				System.out.println("서버에서 재 전송한 메시지 :" + msg);
			}
			System.out.println("클라이언트를 종료합니다.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		sc.close();
	}
}
