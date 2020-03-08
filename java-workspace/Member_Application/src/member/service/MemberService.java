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
		// 등록할 게시물 번호, 등록일을 BoardVO객체에 setting
		dao.insertBoard(member);
	}
	
	public List<MemberVO> selectBoard() throws Exception {

		List<MemberVO> list = dao.selectBoard();
		return list;
	}
}