package server;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
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
import Util.Util;
/*
 * 서버 실행 클래스
 */
public class ServerUI extends JFrame {
	private static final long serialVersionUID = -4504982550735412120L;
	private Server server = null;
	private Thread broadcast = null;
	private Thread borderThread = null;
	private Util util = null;
	private JButton startBtn;
	private JButton onAirBtn;
	private JLabel imageLabel;
	private JScrollPane listScrollPane;
	private JList<ConnectorListData> connectorList;
	private Vector<String> connectorInfoVector;
	private ListModel<ConnectorListData> lm;
	private JTextPane chatWindow;
	private JScrollPane chatScrollPane;
	private JTextField inputText;
	private boolean serverOperationFlag;
	private String rootID;
	private String rootMail;
	private Object lock;

	public static void main(String[] argv) {
		new LoginFrame();
	}

	public ServerUI(String id) {
		this.setTitle(Constant.PROGRAM_TITLE);	// 창의 타이틀 설정
		this.setResizable(false);	// 사이즈를 변경하지 못하게 함. , 크기조절이 되게하면 신경쓸게 많음.
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();	// 스크린 사이즈 얻는법
		
		this.setSize((int) screenSize.width - (int) (screenSize.width * 0.5)
				,(int) screenSize.height - (int) (screenSize.height * 0.5));	// 실행 사이즈 정하는것.
		Dimension frameSize = this.getSize();
		
		this.setLocation((screenSize.width - frameSize.width) / 2
				, (screenSize.width - frameSize.width) / 4);	// 위치 지정.
		
		this.rootID = id;
		this.rootMail = "bit.co.kr";
		
		initComponent();
		addComponent();
		eventConnector();

		connectorInfoVector.add(rootID + "(" + rootMail + ")");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		util = new Util();
		server = new Server();
		serverOperationFlag = false;
		inputText.requestFocus();
		lock = new Object();

	} // end constructor

	private void initComponent(){ // Component 초기화
		startBtn = new JButton(Constant.START_BTN_CONNECT);
		onAirBtn = new JButton(Constant.ONAIR_BTN_STRING);
		imageLabel = new JLabel();
		connectorList = new JList<ConnectorListData>();
		listScrollPane = new JScrollPane(connectorList);
		chatWindow = new JTextPane();
		chatScrollPane = new JScrollPane(chatWindow);
		inputText = new JTextField();
		lm = new DefaultListModel<ConnectorListData>();
		connectorInfoVector = new Vector<String>();

		((DefaultListModel<ConnectorListData>) lm)
				.addElement(new ConnectorListData(rootID + "(" + rootMail + ")",
						new ImageIcon("images/root.png")));

		connectorList.setModel(lm);
		connectorList.setCellRenderer(new ConnectListCellRenderer());
		
		// inputText.setPreferredSize(new Dimension(600, 30));

		chatWindow.setEditable(false);
		chatWindow.setBackground(Color.WHITE);
		
		Border lineBorder = BorderFactory.createLineBorder(Color.BLACK, 1);

		imageLabel.setBorder(lineBorder);
		chatScrollPane.setBorder(lineBorder);
		listScrollPane.setBorder(lineBorder);
	}

	private Point getLocalPos(){
		return this.getLocationOnScreen();
	}

	private void addComponent(){ // Component 부착
		Dimension frameSize = this.getSize();
		JPanel mainPenel = new JPanel(null);
		JLabel connectorListLabel = new JLabel("Connector");
		JLabel chatWindowLabel = new JLabel("Chatting Room");
		JLabel inputTxtLabel = new JLabel(Constant.MESSAGE_LABEL_STRING);
		this.add(mainPenel, BorderLayout.CENTER);

		imageLabel.setSize(frameSize.width - 170, frameSize.height - 70); // 이미지 레이블
		imageLabel.setLocation(0, 0);
		mainPenel.add(imageLabel);

		startBtn.setSize(90, 30); // 시작 버튼
		startBtn.setLocation(5, frameSize.height - 65);
		mainPenel.add(startBtn);

		onAirBtn.setSize(90, 30); // 방송시작 버튼
		onAirBtn.setLocation(100, frameSize.height - 65);
		mainPenel.add(onAirBtn);

		inputText.setSize(265, 30); // 채팅 입력 텍스트
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
		
		// 접속자 리스트 출력 창
		listScrollPane.setSize(165, 200);
		listScrollPane.setLocation(frameSize.width - 171, 20);
		mainPenel.add(listScrollPane);

		// 채팅 창
		chatScrollPane.setSize(165, frameSize.height - 308); 
		chatScrollPane.setLocation(frameSize.width - 171, 238);
		mainPenel.add(chatScrollPane);
		;
	}

	private void eventConnector() {
		// 서버 구동 버튼
		startBtn.addActionListener(new ActionListener() { // 서버 스타트 번튼 이벤트 리스너
			@Override
			public void actionPerformed(ActionEvent e) {
				if (serverOperationFlag == false) { // 서버가 구동중이 아니면
					if (server.startServer() == true) { // 서버를 구동 시킴
						startBtn.setText("Stop");

						borderThread = new Thread(new Runnable() { // 방송중일 때 빨간 가장자리 깜박임 효과 thread
							Border redBorder = BorderFactory.createLineBorder(Color.RED, 5);
							Border blackBorder = BorderFactory.createLineBorder(Color.WHITE, 5);
							boolean borderFlag = true;

							@Override
							public void run() {
								try {
									while (true) {
										if (borderFlag) {
											imageLabel.setBorder(redBorder);
											borderFlag = !borderFlag;
											Thread.sleep(900);
										} else {
											imageLabel.setBorder(blackBorder);
											borderFlag = !borderFlag;
											Thread.sleep(100);
										}
									}
								} catch (InterruptedException e) { }
							}
						});
						borderThread.setDaemon(true); // 방송 전송 구역 가장자리 깜빡이는 효과
						borderThread.start();
						serverOperationFlag = true;
					} else { // 서버 구동 실패
						JOptionPane.showMessageDialog(null,"can't start server!!", "error",JOptionPane.ERROR_MESSAGE);
						serverOperationFlag = false;
					}
				}
				else { // 서버가 동작 중이면
					server.stopServer(); // 서버 종료
					borderThread.interrupt();  // 방솔 thread 종료
					borderThread = null; 
					Border blackBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
					imageLabel.setBorder(blackBorder);
					startBtn.setText("Start");
					serverOperationFlag = false;
				}
				inputText.requestFocus();
			}
		});
		
		// 방송 시작
		onAirBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (broadcast != null && broadcast.isAlive()) { // 방송중이면 방송 중지
					JOptionPane.showMessageDialog(null, "방송을 중지 합니다.", "error", JOptionPane.ERROR_MESSAGE);
					broadcast.interrupt();
					onAirBtn.setText("On Air");
					inputText.requestFocus(); 
					return;
				}
				if (server.getConnectors() == 0) { // 접속자가  0명이면 방송 시작 불가능.
					JOptionPane.showMessageDialog(null, "접속한 사용자가 없습니다.", "error", JOptionPane.ERROR_MESSAGE);
					inputText.requestFocus();
					return;
				}

				broadcast = new Thread(new Runnable() {
					public void run() {
						while (true) {
							Point pos = getLocalPos();
							Rectangle rect = new Rectangle(pos.x + 3,pos.y + 26, imageLabel.getWidth(),imageLabel.getHeight());
							BufferedImage image = util.capture(rect); // 화면 크기에 맞게 캡쳐해서 모든 접속자에게 전송.
							server.allSendImage(image);
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								broadcast = null;
								break;
							}
						}
					}
				});
				broadcast.start();
				onAirBtn.setText("Off Air");
				inputText.requestFocus();
			}
		});

		// 채팅입력
		inputText.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (inputText.getText().trim().equals("")) return;
				chatWindow.setEditable(true);
				appendToPane("[" + Constant.ADMINISTRATOR + "]:", Color.BLUE, 13, true);
				appendToPane(inputText.getText() + "\n", Color.RED, 13, true);
				chatWindow.setEditable(false);
				// 모든 client에게 전송
				server.allSendMessage("[" + Constant.ADMINISTRATOR + "]:" + inputText.getText());
				inputText.setText("");
			}
		});
	}
	
	public void setRootID(String id) {this.rootID = id;}
	public void setRootMail(String mail) {this.rootMail = mail;}
	
	public void renewConnectorList(){
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

	public class Server {
		private ServerSocket chatServer = null;          // 채팅 서버
		private ServerSocket broadcastServer = null;     // 방송 서버
		private ServerSocket connectorInfoServer = null; // 접송 인원 관리 서버

		private Vector<Connector> connectors = new Vector<Connector>();

		public boolean startServer() {
			try {
				chatServer = new ServerSocket(50050);
				broadcastServer = new ServerSocket(50500);
				connectorInfoServer = new ServerSocket(51000);
			} catch (IOException e) {
				System.err.println("서버 구동 실패");
				return false;
			}

			// client의 연결 요청 처리 쓰레드
			Thread connectorThread = new Thread(new Runnable() {
				@Override
				public void run() {
					// client의 연결을 계속 받는다.
					while (true) {
						try {
							Socket clientSock = chatServer.accept();
							Socket clientBSock = broadcastServer.accept();
							Socket clientCSock = connectorInfoServer.accept();
							
							// connectorList에 접속자 추기를 위한 데이터
							InputStream is = clientCSock.getInputStream();
							byte[] buffer = new byte[64];
							int readCount = is.read(buffer);
							String clientInfo = new String(buffer, 0, readCount);
							StringTokenizer token = new StringTokenizer(clientInfo, ":");
							String clientID = token.nextToken();
							String clientMail = token.nextToken();
							
							// Connector 객체 생성시 자동 receive()실행
							Connector connector = new Connector(clientSock, clientBSock, clientCSock, clientID, clientMail);
							
							synchronized (lock){
								connectorInfoVector.addElement(clientID + "(" + clientMail + ")");
								connectors.add(connector);
							}
							
							AllSendConnectorInfo();
							renewConnectorList();
							
						} catch (IOException e) {
							System.err.println("accep 실패");
							break;
						}
					}
				}
			});
			// 채팅 서버 구동
			connectorThread.start();
			return true;
		}// end startServer

		public void stopServer() {
			try {
				for (Connector client : connectors) {
					client.sock.close();
					client.bSock.close();
					client.cSock.close();
				}
				
				chatServer.close();
				broadcastServer.close();
				connectorInfoServer.close();
				
				chatServer = null;
				broadcastServer = null;
				connectorInfoServer = null;
				connectors.clear();
				connectorInfoVector.clear();
			} catch (IOException e) {
				System.out.println("stop server error");
			}
		}

		public void allSendMessage(String message) {
			Thread sendThread = new Thread(new Runnable() {
				@Override
				public void run() {
					for (Connector client : connectors) {
						client.send(message + "\n");
					}
				}
			});
			sendThread.start();
		}

		public void allSendImage(BufferedImage image) {
			Thread sendThread = new Thread(new Runnable() {
				@Override
				public void run() {
					for (Connector client : connectors) {
						client.sendImage(image);
					}
				}
			});
			sendThread.start();
		}
		
		public void AllSendConnectorInfo(){
			Thread sendThread = new Thread(new Runnable() {
				@Override
				public void run() {
					for (Connector client : connectors) {
						client.sendConnectorInfo();
					}
				}
			});
			sendThread.start();
		}

		public synchronized int getConnectors() {
			return connectors.size();
		}

		public class Connector {
			private Socket sock = null;
			private Socket bSock = null;
			private Socket cSock = null;
			private Thread receiveThread = null;
			private String id = null;
			private String mail = null;
			
			private InputStream messageInputStream = null;
			private OutputStream messageOutputStream = null;
			private OutputStream imageOutputStream = null;
			private BufferedOutputStream imageBOutputStream = null;
			

			public Connector(Socket sock, Socket bSock, Socket cSock, String id, String mail) {
				this.sock = sock;
				this.bSock = bSock;
				this.cSock = cSock;
				this.id = id;
				this.mail = mail;
				try {
					this.messageInputStream = sock.getInputStream();
					this.messageOutputStream = sock.getOutputStream();
					this.imageOutputStream = bSock.getOutputStream();
					imageBOutputStream = new BufferedOutputStream(imageOutputStream);
				} catch (IOException e) {
					e.printStackTrace();
				}
				this.receive();
			}
			
			private synchronized void removeConnector(){
				connectors.remove(this);
				connectorInfoVector.remove(id+"("+mail+")");
			}

			public void receive() {
				receiveThread = new Thread(new Runnable(){
					@Override
					public void run() {
						byte[] buffer = new byte[256];
						try {
							while (true) {
								int readCount = messageInputStream.read(buffer);
								if (readCount == -1) throw new IOException();
								String message = new String(buffer, 0, readCount);
								chatWindow.setEditable(true);
								appendToPane(message + "\n", Color.BLACK, 13, false);
								chatWindow.setEditable(false);
								allSendMessage(message);
							}
						} catch (IOException e) {
							System.err.println("client 접속 종료");
						} finally {
							try {
								imageBOutputStream.close();
								sock.close();
								bSock.close();
								cSock.close();
							} catch (IOException e) { e.printStackTrace(); }
							removeConnector();
							AllSendConnectorInfo();
							renewConnectorList();
							if(connectors.isEmpty()){
								if(broadcast != null){
									broadcast.interrupt(); System.err.println("모든 사용자가 접속을 종료하여 방송을 중지 합니다.");
									onAirBtn.setText("On Air");
								}
							}
						}
					}
				});
				receiveThread.start();
			} // end receive()

			public void send(String message) {
				try {
					byte[] buffer = message.getBytes();
					messageOutputStream.write(buffer);
					messageOutputStream.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} // end send()

			public void sendImage(BufferedImage image) {
				try {
					ImageIO.write(image, "gif", imageBOutputStream);
					imageBOutputStream.flush();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} // end sendImage()
			
			public void sendConnectorInfo(){
				OutputStream os = null;
				BufferedOutputStream bos = null;
				ObjectOutputStream oObj = null;
				try {
					os = cSock.getOutputStream();
					bos = new BufferedOutputStream(os);
					oObj = new ObjectOutputStream(bos);
					synchronized (lock){
						oObj.writeObject(connectorInfoVector);
					}
					oObj.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} // end sendConnectorInfo()
			
		} // end class Connector

	} // end class Server

}// end class ServerUI

