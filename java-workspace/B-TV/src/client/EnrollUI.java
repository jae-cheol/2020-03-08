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
import 서비스.LoginService;

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

		super(f, "회원가입", true);
		frame = f;
		this.setLayout(null);
		this.setSize(300, 245);
		this.setLocation(f.getLocation().x, f.getLocation().y);

		id = new JLabel("아이디     :");
		pw = new JLabel("패스워드 :");
		name = new JLabel("이름 : ");
		email = new JLabel("이메일     : ");
		txtId = new JTextField();
		txtPwd = new JPasswordField();
		txtEmail = new JTextField();
		txtName = new JTextField();
		bntIdCheck = new JButton("Check");
		bntJoin = new JButton("회원가입");
		bntCancel = new JButton("취소");

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

		txtId.addCaretListener(new CaretListener() // 필드에 업데이트가 있을시엔 무조건 다시 아뒤
													// 체크를 하게 하기 위해서 사용
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
		if (e.getSource() == bntIdCheck) { // 아뒤 체크시 간단한 예외 처리
			if (txtId.getText().equals("")) {
				JOptionPane.showMessageDialog(frame, "아이디를 입력하세요", "경고", JOptionPane.ERROR_MESSAGE);
			} else {
				bntIdCheck.setEnabled(false);
				LoginService loginService = (LoginService) ServiceFactory.getInstance("LoginService");
				if (!loginService.checkID(txtId.getText())) {
					JOptionPane.showMessageDialog(frame, "사용 가능한 아이디 입니다.", "경고", JOptionPane.ERROR_MESSAGE);
					flag = true;
				}
				bntIdCheck.setEnabled(false);

			}
		} else if (e.getSource() == bntJoin) {
			if (flag) { // 로그인 요청시 간단한 예외 처리
				if (new String(txtPwd.getPassword()).equals("")) {
					JOptionPane.showMessageDialog(frame, "비밀 번호를 입력하세요", "경고", JOptionPane.ERROR_MESSAGE);
				} else if (txtName.getText().equals("")) {

					JOptionPane.showMessageDialog(frame, "이름을 입력하세요", "경고", JOptionPane.ERROR_MESSAGE);
				} else if (txtEmail.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "이메일을 입력하세요", "경고", JOptionPane.ERROR_MESSAGE);
				} else {
					LoginService loginService = (LoginService) ServiceFactory.getInstance("LoginService");
					if (loginService.checkEnroll(txtId.getText(), new String(txtPwd.getPassword()), txtName.getText(),
							txtEmail.getText()) == null) {
						JOptionPane.showMessageDialog(frame, "회원가입성공", "가입성공", JOptionPane.INFORMATION_MESSAGE);
					}
					this.dispose();
				}
			} else {
				JOptionPane.showMessageDialog(frame, "아이디 체크를 하세요", "경고", JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getSource() == bntCancel) {
			this.dispose();
		}
	}
}