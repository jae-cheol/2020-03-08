package client;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import Util.ServiceFactory;
import ����.LoginService;

public class EnrollUI extends JDialog implements ActionListener {
	private static final long serialVersionUID = 4949920427919901099L;
	private JLabel id;
	private JLabel pw;
	private JLabel name;
	private JLabel email;
	private JTextField txtId;
	private JPasswordField txtPwd;
	private JTextField txtEmail;
	private JTextField txtName;
	private JButton bntJoin;
	private JButton bntCancel;
	public JButton bntIdCheck;
	public JFrame frame;
	public boolean flag;

	public EnrollUI(JFrame f) {

		super(f, "ȸ������", true);
		frame = f;
		this.setLayout(null);
		this.setSize(300, 245);
		this.setLocation(f.getLocation().x, f.getLocation().y);

		id = new JLabel("���̵�     :");
		pw = new JLabel("�н����� :");
		name = new JLabel("�̸� : ");
		email = new JLabel("�̸���     : ");
		txtId = new JTextField();
		txtPwd = new JPasswordField();
		txtEmail = new JTextField();
		txtName = new JTextField();
		bntIdCheck = new JButton("Check");
		bntJoin = new JButton("ȸ������");
		bntCancel = new JButton("���");

		bntIdCheck.setMargin(new Insets(0, 0, 0, 0));
		id.setBounds(20, 20, 80, 25);
		txtId.setBounds(100, 20, 100, 25);
		bntIdCheck.setBounds(210, 20, 53, 25);

		pw.setBounds(20, 50, 80, 25);
		txtPwd.setBounds(100, 50, 100, 25);

		name.setBounds(20, 80, 80, 25);
		txtName.setBounds(100, 80, 100, 25);

		email.setBounds(20, 110, 80, 25);
		txtEmail.setBounds(100, 110, 100, 25);

		bntJoin.setBounds(45, 163, 86, 25);
		bntCancel.setBounds(145, 163, 86, 25);

		txtId.addCaretListener(new CaretListener() // �ʵ忡 ������Ʈ�� �����ÿ� ������ �ٽ� �Ƶ�
													// üũ�� �ϰ� �ϱ� ���ؼ� ���
		{
			public void caretUpdate(CaretEvent e) {
				flag = false;
			}
		});

		flag = false;

		bntIdCheck.addActionListener(this);
		bntJoin.addActionListener(this);
		bntCancel.addActionListener(this);

		this.add(id);
		this.add(txtId);
		this.add(bntIdCheck);
		this.add(pw);
		this.add(txtPwd);
		this.add(name);
		this.add(txtName);
		this.add(email);
		this.add(txtEmail);
		this.add(bntJoin);
		this.add(bntCancel);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bntIdCheck) { // �Ƶ� üũ�� ������ ���� ó��
			if (txtId.getText().equals("")) {
				JOptionPane.showMessageDialog(frame, "���̵� �Է��ϼ���", "���", JOptionPane.ERROR_MESSAGE);
			} else {
				bntIdCheck.setEnabled(false);
				LoginService loginService = (LoginService) ServiceFactory.getInstance("LoginService");
				if (!loginService.checkID(txtId.getText())) {
					JOptionPane.showMessageDialog(frame, "��� ������ ���̵� �Դϴ�.", "���", JOptionPane.ERROR_MESSAGE);
					flag = true;
				}
				bntIdCheck.setEnabled(false);

			}
		} else if (e.getSource() == bntJoin) {
			if (flag) { // �α��� ��û�� ������ ���� ó��
				if (new String(txtPwd.getPassword()).equals("")) {
					JOptionPane.showMessageDialog(frame, "��� ��ȣ�� �Է��ϼ���", "���", JOptionPane.ERROR_MESSAGE);
				} else if (txtName.getText().equals("")) {

					JOptionPane.showMessageDialog(frame, "�̸��� �Է��ϼ���", "���", JOptionPane.ERROR_MESSAGE);
				} else if (txtEmail.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "�̸����� �Է��ϼ���", "���", JOptionPane.ERROR_MESSAGE);
				} else {
					LoginService loginService = (LoginService) ServiceFactory.getInstance("LoginService");
					if (loginService.checkEnroll(txtId.getText(), new String(txtPwd.getPassword()), txtName.getText(),
							txtEmail.getText()) == null) {
						JOptionPane.showMessageDialog(frame, "ȸ�����Լ���", "���Լ���", JOptionPane.INFORMATION_MESSAGE);
					}
					this.dispose();
				}
			} else {
				JOptionPane.showMessageDialog(frame, "���̵� üũ�� �ϼ���", "���", JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getSource() == bntCancel) {
			this.dispose();
		}
	}
}