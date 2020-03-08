package HW12;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

/*
 * 서버에 전송할 메세지 입력(종료시 quit) : hello
서버에서 재전송한 메세지 : hello
서버에 전송할 메세지 입력(종료시 quit) : 하이
서버에서 재전송한 메세지 : 하이
서버에 전송할 메세지 입력(종료시 quit) : bye
서버에서 재전송한 메세지 : bye
서버에 전송할 메세지 입력(종료시 quit) : quit
서버와의 연결 종료
 */
public class HW12_cli {

	public static void main(String[] args) {

		try {
			Scanner sc = new Scanner(System.in);
			// 127.0.0.1 == localhost
			Socket socket = new Socket("localhost", 10000);

			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			
			InputStream is = socket.getInputStream();	// outputstream으로 날라왔으니 인풋으로.
			DataInputStream dis = new DataInputStream(is);
			while(true) {
				System.out.print("서버에 전송할 메시지 입력(종료시 quit) : ");
				String msg = sc.nextLine();
				dos.writeUTF(msg);
				try{
					msg = dis.readUTF();
				}catch(SocketException e){
					System.out.println("클라이언트 종료");
					break;
				}
				System.out.println("서버에서 재전송한 메시지 : " + msg);
			}
			System.out.println("서버와의 연결 종료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
