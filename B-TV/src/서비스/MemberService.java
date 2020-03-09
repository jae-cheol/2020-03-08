package ¼­ºñ½º;

import java.util.List;

import DAO.MemberDAO;
import Interface.IService;
import VO.MemberVO;

public class MemberService implements IService<MemberVO>{
	private MemberDAO dao;
	public MemberService() { dao = new MemberDAO(); }
	
	public void insertBoard(MemberVO login) { dao.insertBoard(login); }
	
	public List<MemberVO> selectBoard() throws Exception {
		List<MemberVO> list = dao.selectBoard();
		return list;
	}
	
	public MemberVO selectOneBoard(MemberVO login) {
		MemberVO result = dao.selectOneBoard(login);
		return result;
	}
	
	public String getEmail(String id){
		return dao.getEmail(id);
	}
}






