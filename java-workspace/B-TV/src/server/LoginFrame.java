package server;

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

public class LoginFrame extends JFrame{
	private static final long serialVersionUID = -5681822346085160414L;
	private BufferedImage image;
	private JTextField textId;
	private JPasswordField textPass;
	private JButton btnOK;
	private JButton btnHelp;

	public LoginFrame(){
		this.setTitle("���� �α���");	// â�� Ÿ��Ʋ ����.
		this.setSize(640, 428);
		this.setResizable(false);	// ����� �������� ���ϰ� ��. , ũ�������� �ǰ��ϸ� �Ű澵�� ����.
		this.setLayout(null);	// �ؽ�Ʈ �ʵ带 ���ϴ� ���� �ֱ�����.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// x������ ������ �ϴ°�.
		
		try {
			image = ImageIO.read(new File("images/login.png"));	// 
		} catch (IOException e) {
			System.err.println("login image read failed");
		}
		
		BackgroundPanel bPanel = new BackgroundPanel();
		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		bPanel.setBounds(0, 0, frameSize.width, frameSize.height);
		
		textId = new JTextField(Constant.ADMINISTRATOR);
		textId.setOpaque(false);
		textId.setBorder(null);
		textId.setFocusable(false);
		textId.setEditable(false);
		textId.setBounds(220, 140, 200, 30);
		textId.setFont(new Font("���ü", Font.BOLD, 20));
		
		textPass = new JPasswordField();
		textPass.setOpaque(false);
		textPass.setBorder(null);
		textPass.setBounds(220, 187, 200, 30);
		textPass.setFont(new Font("���ü", Font.BOLD, 20));
		
		btnOK = new JButton("Log-in");
		btnOK.setForeground(Color.GREEN);
		btnOK.setBounds(248, 230, 80, 30);
		btnOK.setContentAreaFilled(false);
		btnOK.setFocusable(false);
		
		btnHelp = new JButton("Help");
		btnHelp.setForeground(Color.GREEN);
		btnHelp.setBounds(338, 230, 60, 30);
		btnHelp.setContentAreaFilled(false);
		btnHelp.setFocusable(false);
		
		textPass.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(new String(textPass.getPassword()).equals("")){
					JOptionPane.showMessageDialog(null,"Password�� �Է� �ϼ���", "error",JOptionPane.ERROR_MESSAGE);
					textPass.requestFocus();
					return;
				}
				loginOK();
			}
		});
		
		btnOK.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(new String(textPass.getPassword()).equals("")){
					JOptionPane.showMessageDialog(null,"Password�� �Է� �ϼ���", "error",JOptionPane.ERROR_MESSAGE);
					textPass.requestFocus();
					return;
				}
				loginOK();
			}
		});
		
		btnHelp.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "��� ��ȣ �ƹ��ų�"
				, "Help",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		this.add(btnOK);
		this.add(textPass);
		this.add(textId);
		this.add(btnHelp);
		this.add(bPanel);
		
		this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		this.setVisible(true);
		textPass.requestFocus();
	}
	
	private void loginOK(){
		ServerUI serverUI = new ServerUI(textId.getText());
		serverUI.setVisible(true);
		this.setVisible(false);
	}
	
	class BackgroundPanel extends JPanel{
		private static final long serialVersionUID = 3146310029617092586L;
		public void paint(Graphics g){
			g.drawImage(image, 0, 0, null);
		}
	}
}


