package ¼­ºñ½º;

import java.util.List;

import DAO.LoginDAO;
import VO.MemberVO;
import Interface.IService;

public class LoginService implements IService<MemberVO>{
	private LoginDAO dao;
	public LoginService() { dao = new LoginDAO();}
	
	@Override
	public MemberVO checkLogin(String id, String pass) throws Exception {
		MemberVO result = null;
		result = dao.checkLogin(id, pass);
		return result;
	}
	
	public MemberVO checkEnroll(String id, String pass,String name,String email){
	      MemberVO result = null;
	      result = dao.checkEnroll(id, pass, name,email);
	      return result;
	   }
	
	@Override
	public boolean checkID(String id){
		return dao.checkID(id);
	}
	
	@Override
	public void insertBoard(MemberVO login) {
		// empty
	}
	@Override
	public List<MemberVO> selectBoard() throws Exception {
		// empty
		return null;
	}
	@Override
	public MemberVO selectOneBoard(MemberVO login) {
		//empty
		return null;
	}
}
