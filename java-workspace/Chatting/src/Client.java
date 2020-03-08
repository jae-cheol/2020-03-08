
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

interface Constants{
	public static final String secret = "rn1l7tt8r90kf0376";
	public static int getSecretLength(){
		return secret.length();
	}
}

class ReciveThread extends Thread{
	private InputStream is;
	private InputStreamReader isr;
	private BufferedReader br;
	public ReciveThread(InputStream is){
		this.is = is;
		this.isr = new InputStreamReader(is);
		this.br = new BufferedReader(isr);
	}
	@Override
	public void run(){
		while(true){
			try {
				String msg = br.readLine();
				if(msg == null) break;
				System.out.println(msg);
			} catch (IOException e) {
				System.out.println("�������� ������ ���� �����ϴ�. ������ ���� �մϴ�.");
				break;
			}
		}
		FileCloser.close(br);
		FileCloser.close(isr);
		FileCloser.close(is);
	}
}

class SendThread extends Thread{
	private Scanner sc = new Scanner(System.in);
	private OutputStream os;
	private OutputStreamWriter osw;
	private PrintWriter pw;
	private String userName;
	public SendThread(OutputStream os, String userName){
		this.os = os;
		this.osw = new OutputStreamWriter(os);
		this.pw = new PrintWriter(osw);
		this.userName = userName;
	}
	@Override
	public void run(){
		while(true){
			System.out.print("������ �Է� (�ӼӸ��� @���̰� ������ �Է� ): ");
			StringBuilder sb = new StringBuilder(sc.nextLine());
			if(sb.toString().equalsIgnoreCase("quit")) break;
			if(sb.toString().length() > 0 && sb.toString().charAt(0) == '@'){ // �ӼӸ��� ���..
				sb.deleteCharAt(0);
				sb.append(Constants.secret);
				pw.println("[" + userName +"](�ӼӸ�) : " + sb.toString());
			}
			else pw.println("[" + userName +"] : " + sb.toString());
			pw.flush();
		}
		FileCloser.close(pw);
		FileCloser.close(osw);
		FileCloser.close(os);
	}
}

public class Client {
	private Socket socket;
	private String userID;
	private int portNumber;
	private String ipAddress;
	public Client(String userID, String ipAddress,  int portNumber){
		this.userID = userID;
		this.ipAddress = ipAddress;
		this.portNumber = portNumber;
	}
	public void connect() throws IOException{
		socket = new Socket(ipAddress, portNumber);
		System.out.println("[����(" + socket.getInetAddress().getHostAddress() + ")�� ���� �Ǿ����ϴ�]");
		new SendThread(socket.getOutputStream(), userID).start();
		new ReciveThread(socket.getInputStream()).start();
	}
	public String getUserID(){return this.userID;}
}


