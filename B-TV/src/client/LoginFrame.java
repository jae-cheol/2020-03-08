package client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Util.Constant;
import Util.ServiceFactory;
import 서비스.LoginService;

public class LoginFrame extends JFrame{
	private static final long serialVersionUID = -5681822346085160414L;
	private BufferedImage image;
	private JTextField textId;
	private JPasswordField textPass;
	private JButton btnOK;
	private JButton btnHelp;
	private JButton btnEnroll;

	public LoginFrame(){
		this.setTitle("사용자 로그인");
		this.setSize(640, 428);
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			image = ImageIO.read(new File("images/login.png"));
		} catch (IOException e) {
			System.err.println("login image read failed");
		}
		
		BackgroundPanel bPanel = new BackgroundPanel();
		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		bPanel.setBounds(0, 0, frameSize.width, frameSize.height);
		
		textId = new JTextField();
		textId.setOpaque(false);
		textId.setBorder(null);
		textId.setBounds(220, 140, 200, 30);
		textId.setFont(new Font("고딕체", Font.BOLD, 20));
		
		textPass = new JPasswordField();
		textPass.setOpaque(false);
		textPass.setBorder(null);
		textPass.setBounds(220, 187, 200, 30);
		textPass.setFont(new Font("고딕체", Font.BOLD, 20));
		
		btnOK = new JButton("Log-in");
		btnOK.setForeground(Color.GREEN);
		btnOK.setBounds(298, 230, 80, 30);
		btnOK.setContentAreaFilled(false);
		btnOK.setFocusable(false);
		
		btnHelp = new JButton("Help");
		btnHelp.setForeground(Color.GREEN);
		btnHelp.setBounds(388, 230, 60, 30);
		btnHelp.setContentAreaFilled(false);
		btnHelp.setFocusable(false);
		
		btnEnroll = new JButton("Enroll");
		btnEnroll.setForeground(Color.GREEN);
		btnEnroll.setBounds(208, 230, 80, 30);
		btnEnroll.setContentAreaFilled(false);
		btnEnroll.setFocusable(false);
		
		textId.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				textPass.requestFocus();
			}
		});
		
		textPass.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				checkLogin();
			}
		});
		
		btnOK.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				checkLogin();
			}
		});
		
		btnHelp.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, Constant.HELP_STRING, 
						Constant.HELP_TITLE, JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		btnEnroll.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				onEnroll();					
			}
		});
		
		this.add(btnOK);
		this.add(textPass);
		this.add(btnEnroll);
		this.add(textId);
		this.add(btnHelp);
		this.add(bPanel);
		
		this.setLocation((screenSize.width - frameSize.width) / 2
				, (screenSize.height - frameSize.height) / 2);
		this.setVisible(true);
	}
	
	public void onEnroll() {
		EnrollUI join2 = new EnrollUI(this) ;
		join2.setVisible(true);
	}
	
	private void loginOK(){
		ClientUI clientUI = new ClientUI(textId.getText());
		clientUI.setVisible(true);
		this.setVisible(false);
	}
	
	private void checkLogin(){
		if(textId.getText().equals("")){
			JOptionPane.showMessageDialog(null, "ID를 입력 하세요", "error", JOptionPane.ERROR_MESSAGE);
			textId.requestFocus();
			return;
		}
		if(new String(textPass.getPassword()).equals("")){
			JOptionPane.showMessageDialog(null, "Password를 입력 하세요", "error", JOptionPane.ERROR_MESSAGE);
			textPass.requestFocus();
			return;
		}
		
		LoginService loginService = (LoginService) ServiceFactory.getInstance("LoginService");
		try {
			loginService.checkLogin(textId.getText(), new String(textPass.getPassword()));
			loginOK();
		} catch ( Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	class BackgroundPanel extends JPanel{
		private static final long serialVersionUID = 3146310029617092586L;
		public void paint(Graphics g){
			g.drawImage(image, 0, 0, null);
		}
	}
}