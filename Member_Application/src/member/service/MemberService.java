package member.service;

import java.util.List;

import member.dao.MemberDAO;
import member.vo.MemberVO;

public class MemberService {

	private MemberDAO dao;
	private static int no = 1;
	
	public MemberService() {
		dao = new MemberDAO();
	}

	public void insertBoard(MemberVO member) {
		// ����� �Խù� ��ȣ, ������� BoardVO��ü�� setting
		dao.insertBoard(member);
	}
	
	public List<MemberVO> selectBoard() throws Exception {

		List<MemberVO> list = dao.selectBoard();
		return list;
	}
}