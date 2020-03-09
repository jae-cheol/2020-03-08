
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

class FileCloser{
	public static void close(InputStream is){
		if(is != null){
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(OutputStream os){
		if(os != null){
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Reader rd){
		if(rd != null){
			try {
				rd.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Writer wt){
		if(wt != null){
			try {
				wt.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

class ServerThread extends Thread{
	private Vector<Socket> users;
	private Socket client;
	private boolean isWhisper = false;
	public ServerThread(Vector<Socket> users, Socket client){
		this.users = users;
		this.client = client;
	}
	@Override
	public void run(){
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			is = client.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			while(true){
				String msg = br.readLine();
				if(msg == null) break; // ���� ����
				if(msg.length() >= Constants.getSecretLength()){ // �ӼӸ����� �˻�
					if(msg.substring(msg.length() - Constants.getSecretLength()).equals(Constants.secret)){
						msg = msg.substring(0, msg.length() - Constants.getSecretLength());
						isWhisper = true;
					}
				}
				System.out.println(msg);
				if(isWhisper){ // �ӼӸ�
					OutputStreamWriter osw = new OutputStreamWriter(client.getOutputStream());
					PrintWriter pr = new PrintWriter(osw);
					pr.println(msg);
					pr.flush();
					isWhisper = !isWhisper;
				}else{ // �Ϲ� �޽���
					for(int i=0;i<users.size();i++){
						OutputStreamWriter osw = new OutputStreamWriter(users.get(i).getOutputStream());
						PrintWriter pr = new PrintWriter(osw);
						pr.println(msg);
						pr.flush();
	 				}
				}
			}
		} catch (IOException e) {
			System.out.println("[" + client.getInetAddress().getHostAddress() + "] �� ������ ���� �Ͽ����ϴ�.");
		} finally{
			FileCloser.close(br);
			FileCloser.close(isr);
			FileCloser.close(is);
			users.remove(client);
			System.out.println("���� ���� �ο� : " + users.size());
		}
	}
}

public class Server {
	private Vector<Socket> users = new Vector<Socket>();
	private int portNumber;
	private ServerSocket server;
	public Server(int portNumber){
		this.portNumber = portNumber;
	}
	public void start() throws IOException{
		server = new ServerSocket(portNumber);
		while(true){
			System.out.println("[Ŭ���̾�Ʈ ���� �����....");
			Socket client = server.accept();
			System.out.println("[" + client.getInetAddress().getHostAddress() + "] �� ���� �Ǿ����ϴ�.");
			users.add(client);
			System.out.println("���� ���� �ο� : " + users.size() + "��");
			new ServerThread(users, client).start();
		}
	}
	public int Count() {return users.size();}
}
