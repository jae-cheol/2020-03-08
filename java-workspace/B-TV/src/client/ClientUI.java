package client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListModel;
import javax.swing.border.Border;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

import Util.ConnectListCellRenderer;
import Util.ConnectorListData;
import Util.Constant;
import Util.ServiceFactory;
import VO.MemberVO;
import 서비스.MemberService;
/*
 * 클라이언트 실행 클래스
 */
public class ClientUI extends JFrame {
	private static final long serialVersionUID = -5184127956315066256L;
	private Client client;
	private JButton connectBtn;
	private JLabel imageLabel;
	private JList<ConnectorListData> connectorList;
	private ListModel<ConnectorListData> lm;
	private Vector<String> connectorInfoVector;
	private JTextPane chatWindow;
	private JTextField inputText;
	private JScrollPane chatScrollPane;
	private JScrollPane connectorScrollpane;
	private String iD;
	private String eMail;

	
	public static void main(String[] argv){
		new LoginFrame();
	}
	
	public ClientUI(String id){
		this.setTitle(Constant.PROGRAM_TITLE);
		this.setResizable(false);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize((int)screenSize.width-(int)(screenSize.width*0.5)
				, (int)screenSize.height-(int)(screenSize.height*0.5)); 
		Dimension frameSize = this.getSize();
		this.setLocation((screenSize.width - frameSize.width)/2, 0);
		
		MemberService  mService = (MemberService) ServiceFactory.getInstance("MemberService");
		
		this.iD = id;
		this.eMail = mService.getEmail(id);
		
		initComponent();  // component 초기화
		addComponent();   // component를  main penel에 부착
		eventConnector(); // 이벤트 연결
		
		inputText.requestFocus();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(Constant.MAIN_IMAGE_PATH));
		client = new Client();
		
		connectorInfoVector = new Vector<String>();
		connectorInfoVector.add(iD + "(" + eMail + ")");
		client.displayConnectorList();
	}
	
	private void initComponent(){
		connectBtn = new JButton(Constant.START_BTN_CONNECT);
		imageLabel = new JLabel(new ImageIcon(Constant.PREPARING_IMAGE_PATH));
		connectorList = new JList<ConnectorListData>();
		connectorScrollpane = new JScrollPane(connectorList);
		chatWindow = new JTextPane();
		inputText = new JTextField();
		chatScrollPane = new JScrollPane(chatWindow);
		lm = new DefaultListModel<ConnectorListData>();

		connectorList.addMouseListener(new MouseAdapter(){
		    public void mouseClicked(MouseEvent evt) {
		        @SuppressWarnings("unchecked")
				JList<ConnectorListData> list = (JList<ConnectorListData>)evt.getSource();
		        if (evt.getClickCount() == 2) {
		        		String data = list.getSelectedValue().getClientName();
		            	String id = data.substring(0, data.indexOf('('));
		            	
		            	MemberService memberService = (MemberService) ServiceFactory.getInstance("MemberService");
		            	MemberVO result = memberService.selectOneBoard(new MemberVO(id, "", "", "", ""));
		            	
		            	JOptionPane.showMessageDialog(null, "ID : " + result.getId() 
		            			+ "\n" + "이름 : " + result.getName() + 
		            			"\n" + "E-mail : " + result.getNick() + 
		            			"\n" + "가입일 : " + result.getRegDate()
		            			 + "\n", "접속자 정보", JOptionPane.INFORMATION_MESSAGE);
		        	} 
		    	}
			});
		
		connectorList.setModel(lm);
		connectorList.setCellRenderer(new ConnectListCellRenderer());
		
		// inputText.setPreferredSize(new Dimension(600, 30));
		
		chatWindow.setEditable(false);
		Border lineBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
		
		imageLabel.setBorder(lineBorder);
		chatScrollPane.setBorder(lineBorder);
		connectorScrollpane.setBorder(lineBorder);
	}
	
	private void addComponent(){
		Dimension frameSize = this.getSize();
		JPanel mainPenel = new JPanel(null);
		JLabel connectorListLabel = new JLabel("Connector");
		JLabel chatWindowLabel = new JLabel("Chatting Room");
		JLabel inputTxtLabel = new JLabel(Constant.MESSAGE_LABEL_STRING);
		this.add(mainPenel, BorderLayout.CENTER);
		
		imageLabel.setSize(frameSize.width - 170, frameSize.height - 70);
		imageLabel.setLocation(0, 0);
		mainPenel.add(imageLabel);
		
		connectBtn.setSize(90, 30);
		connectBtn.setLocation(5, frameSize.height - 65);
		mainPenel.add(connectBtn);
		
		inputText.setSize(265, 30);
		inputText.setLocation(frameSize.width - 272, frameSize.height - 65);
		mainPenel.add(inputText);
		
		connectorListLabel.setSize(80, 10);
		connectorListLabel.setLocation(frameSize.width - 168, 6);
		mainPenel.add(connectorListLabel);
		
		chatWindowLabel.setSize(110, 11);
		chatWindowLabel.setLocation(frameSize.width - 168, 225);
		mainPenel.add(chatWindowLabel);
		
		inputTxtLabel.setSize(80, 11);
		inputTxtLabel.setLocation(frameSize.width - 337, frameSize.height - 56);
		mainPenel.add(inputTxtLabel);
	
		connectorScrollpane.setSize(165, 200);
		connectorScrollpane.setLocation(frameSize.width - 171, 20);
		mainPenel.add(connectorScrollpane);
		
		chatScrollPane.setSize(165, frameSize.height - 308);
		chatScrollPane.setLocation(frameSize.width - 171, 238);
		mainPenel.add(chatScrollPane);;
	}
	
	private void eventConnector(){
		connectBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// 서버 연결
				if(connectBtn.getText().equals(Constant.START_BTN_CONNECTED)){
					connectBtn.setText(Constant.START_BTN_CONNECT);
					client.disConnectClient();
				}
				else {
					if(!client.connectServer()){
						JOptionPane.showMessageDialog(null, "서버에 연결할 수 없습니다", "오류", JOptionPane.ERROR_MESSAGE);
						return;
					}
					connectBtn.setText(Constant.START_BTN_CONNECTED);
				}
			}
		});
		
		// 채팅창에서 입력 시 
		inputText.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(inputText.getText().trim().equals("")) return;
				client.send("[" + iD + "]:" + inputText.getText());
				inputText.setText("");
			}
		});
	}
	
	private void appendToPane(String message, Color color, int fontSize, boolean bold){
	       StyleContext sc = StyleContext.getDefaultStyleContext();
	       AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, color);
	       aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
	       aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);
	       aset = sc.addAttribute(aset, StyleConstants.FontSize, fontSize);
	       aset = sc.addAttribute(aset, StyleConstants.Bold, bold);
	        
	       int len = chatWindow.getDocument().getLength();
	       chatWindow.setCaretPosition(len);
	       chatWindow.setCharacterAttributes(aset, true);
	       chatWindow.replaceSelection(message);
	 }
	 
	 public String getID() {return this.iD;}
	 public String getMail() {return this.eMail;}
	
	public class Client {
		private Socket sock = null;
		private Socket bSock = null;
		private Socket cSock = null;
		
		private InputStream messageInputStream = null;
		private InputStream imageInputStream = null;
		private InputStream connectorInfoInputStream = null;
		
		private OutputStream connectorOutputStream = null;
		private OutputStream messageOutputStream = null;
		
		// 서버 연결 및 채팅 쓰래드 연결
		public boolean connectServer(){
			try {
				sock = new Socket();
				bSock = new Socket();
				cSock = new Socket();
				sock.connect(new InetSocketAddress("localhost", 50050));  // 접속자 관리 소켓
				bSock.connect(new InetSocketAddress("localhost", 50500)); // 방송 소켓
				cSock.connect(new InetSocketAddress("localhost", 51000)); // 채팅 소켓
				
				messageInputStream = sock.getInputStream();
				imageInputStream = bSock.getInputStream();
				connectorInfoInputStream = cSock.getInputStream();
				
				messageOutputStream = sock.getOutputStream();
				connectorOutputStream = cSock.getOutputStream();
				
				String connectorString = iD + ":" + eMail;
				connectorOutputStream.write(connectorString.getBytes());
				connectorOutputStream.flush();
				
				// 채팅 쓰래드
				Thread receiveThread  = new Thread(new Runnable(){
					@Override
					public void run() {
						byte[] buffer = new byte[1024];
						try {
							while(true){
								int readCount = messageInputStream.read(buffer);
								String message = new String(buffer, 0, readCount);
								if(message.startsWith("[" + Constant.ADMINISTRATOR + "]")){ // 방장이 보낸 메시지면 빨간색으로 출력
									chatWindow.setEditable(true);
									appendToPane(message, Color.RED, 13, true);
									chatWindow.setEditable(false);
								}
								else if(message.startsWith("[" + iD + "]")){ // 일반 유저는 검은색으로 출력
									chatWindow.setEditable(true);
									appendToPane(message, Color.BLACK, 13, true);
									chatWindow.setEditable(false);
								}
								else{
									chatWindow.setEditable(true);
									appendToPane(message, Color.BLACK, 13, false);
									chatWindow.setEditable(false);
								}
							}
						} catch (IOException e) {
							System.err.println("chatting receive error");
						}
					}
				});
				receiveThread.start();
				
				// 화면 수신 쓰래드
				Thread broadcastThread = new Thread(new Runnable(){
					@Override
					public void run(){ 
						try {
				            while(true){
				            	BufferedInputStream bin = new BufferedInputStream(imageInputStream);
				            	BufferedImage image = ImageIO.read(bin);
				            	imageLabel.getGraphics().drawImage(image, 0, 0, imageLabel.getWidth()
				            			, imageLabel.getHeight(), imageLabel);
				            }
						} catch (IOException e) {
							System.err.println("image receive error");
						}
					}
				});
				broadcastThread.start();
				
				// 접속자 데이터 수신 쓰래드
				Thread connectorInfoThread = new Thread(new Runnable(){
					@SuppressWarnings("unchecked")
					@Override
					public void run(){ 
						try {
							//ObjectInputStream iObj = new ObjectInputStream(connectorInfoInputStream); 
				            while(true){
				            	ObjectInputStream iObj = new ObjectInputStream(connectorInfoInputStream); 
								connectorInfoVector = (Vector<String>)iObj.readObject();
				            	displayConnectorList();
				            }
						} catch (IOException | ClassNotFoundException e) {
							System.err.println("connectorInfoVector receive error");
							e.printStackTrace();
						}
					}
				});
				connectorInfoThread.start();
				
			} catch (IOException e1) {
				if(sock != null && !sock.isClosed())
					try { sock.close(); } catch (IOException e2) { e2.printStackTrace();}
				if(bSock != null && !bSock.isClosed())
					try { bSock.close(); } catch (IOException e2) { e2.printStackTrace();}
				if(cSock != null && !cSock.isClosed())
					try { cSock.close(); } catch (IOException e2) { e2.printStackTrace();}
				return false; // 서버 연결 실패
			}
			return true; // 서버 연결 성공
		}
		
		public void displayConnectorList(){
			((DefaultListModel<ConnectorListData>) lm).clear();
			for(String value : connectorInfoVector){
				if(value.startsWith(Constant.ADMINISTRATOR))
					((DefaultListModel<ConnectorListData>) lm).addElement(new ConnectorListData(value, new ImageIcon("images/root.png")));
				else
					((DefaultListModel<ConnectorListData>) lm).addElement(new ConnectorListData(value, new ImageIcon("images/icon.png")));
			}
			try{
				connectorList.updateUI();
			}catch(NullPointerException e){}
		}
		
		
		public void send(String message){
			try {
				messageOutputStream.write(message.getBytes());
				messageOutputStream.flush();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "서버와 연결되지 않았습니다.", "error", JOptionPane.ERROR_MESSAGE);
				System.err.println("send() error");
			}
		}
		
		public void disConnectClient(){
			((DefaultListModel<ConnectorListData>) lm).clear();
			if(sock != null && !sock.isClosed())
				try { sock.close(); } catch (IOException e2) { e2.printStackTrace();}
			if(bSock != null && !bSock.isClosed())
				try { bSock.close(); } catch (IOException e2) { e2.printStackTrace();}
			if(cSock != null && !cSock.isClosed())
				try { cSock.close(); } catch (IOException e2) { e2.printStackTrace();}
		}
		
	}// end Client
}// end ClientUI





