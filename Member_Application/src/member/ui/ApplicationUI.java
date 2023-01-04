package member.ui;

import member.vo.MemberVO;

public class ApplicationUI extends BaseUI {
	@Override
	public void execute() throws Exception {

		String id = scanStr("ID를 입력하세요 : ");
		String pw = scanStr("PW를 입력하세요 : ");
		String name = scanStr("이름을 입력하세요 : ");
		String nick = scanStr("닉네임을 입력하세요 : ");
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPw(pw);
		member.setName(name);
		member.setNick(nick);

		service.insertBoard(member);
		
		System.out.println("게시판 등록을 완료하였습니다.");
	}

	
}
