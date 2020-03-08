package member.ui;

import member.vo.MemberVO;

public class ApplicationUI extends BaseUI {
	@Override
	public void execute() throws Exception {

		String id = scanStr("ID�� �Է��ϼ��� : ");
		String pw = scanStr("PW�� �Է��ϼ��� : ");
		String name = scanStr("�̸��� �Է��ϼ��� : ");
		String nick = scanStr("�г����� �Է��ϼ��� : ");
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPw(pw);
		member.setName(name);
		member.setNick(nick);

		service.insertBoard(member);
		
		System.out.println("�Խ��� ����� �Ϸ��Ͽ����ϴ�.");
	}

	
}
