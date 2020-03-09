package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import JDBC.ConnectionFactory;
import UserException.IDNotFoundException;
import UserException.WrongPasswordException;
import VO.MemberVO;

public class LoginDAO {
	public boolean checkID(String _id){
		boolean result = false;
		StringBuffer sql = new StringBuffer();
		sql.append("select id, pass, name ");
		sql.append("     , nick, to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
		sql.append("  from t_client ");
		sql.append(" where id = ? ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, _id);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) result = true;
		} catch (Exception e) { e.printStackTrace();}
		return result;
	}
	
	public MemberVO checkLogin(String _id, String _pass) throws Exception{
		if(!checkID(_id)) throw new IDNotFoundException("등록 되지 않은 ID 입니다.");
		MemberVO result = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select id, pass, name ");
		sql.append("     , nick, to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
		sql.append("  from t_client ");
		sql.append(" where id = ? and pass = ?");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, _id);
			pstmt.setString(2, _pass);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()){
				result = new MemberVO();

				String id = rs.getString("id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				String nick = rs.getString("nick");
				String reg_date = rs.getString("reg_date");

				result.setId(id);
				result.setPass(pass);
				result.setName(name);
				result.setNick(nick);
				result.setRegDate(reg_date);
			}else{
				throw new WrongPasswordException("비밀번호가 틀렸습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	 public MemberVO checkEnroll(String _id, String _pass, String _name, String _email) {
	  MemberVO result = null;
	  StringBuffer sql = new StringBuffer();
	  sql.append("insert into t_client(id, pass, name, nick) ");
	  sql.append("values(?, ?, ?, ?) ");
	  
	  try (Connection conn = new ConnectionFactory().getConnection();
	        PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
	     pstmt.setString(1, _id);
	     pstmt.setString(2, _pass);
	     pstmt.setString(3, _name);
	     pstmt.setString(4, _email);
	     pstmt.executeUpdate();
	     
	  } catch (Exception e) { e.printStackTrace();}
	  
	  return result;
	}
}
