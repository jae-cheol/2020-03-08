package 자바입출력.network;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * java EchoClientMain   192.168.1.2   10001
 * 내 컴퓨터 192.168.1.58
 */
public class EchoClientMain {
	public static void main(String[] args) {
		
		if(args.length != 2) {
			System.out.println("명령어가 잘못되었습니다.");
			System.out.println("사용법 : java EchoClientMain   서버IP   포트");
			System.exit(0);
		}
		
		try {
														// 문자열이니 인티저로 바꿔줌
			Socket socket = new Socket(args[0], Integer.parseInt(args[1]));
			
			// 서버에 전송할 메시지를 키보드로 입력받는 객체
			BufferedReader keyboard 
				= new BufferedReader(new InputStreamReader(System.in));
//			Scanner sc = new Scanner(System.in);
			
			// 키보드로 입력받은 메시지를 서버에 전송할 객체
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw);
			
			// 서버가 보내준 메시지를 수신할 객체
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			while(true) {
				System.out.println("전송할 메시지를 입력(quit입력시 종료) : ");
				String msg = keyboard.readLine();
				if(msg.equalsIgnoreCase("quit")) {
					System.out.println("서버와의 접속 종료");
					socket.close();
					break;
				}
				
				pw.println(msg);
				pw.flush();
				
				String echoMsg = br.readLine();
				System.out.println("서버에서 재전송한 메시지 : [" + echoMsg + "]");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
