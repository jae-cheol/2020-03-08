package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import JDBC.ConnectionFactory;
import JDBC.JDBCClose;
import VO.MemberVO;

public class MemberDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	/**
	 * 게시글을 등록하는 메소드
	 * 
	 * @param 게시글VO
	 */
	public void insertBoard(MemberVO login) {

		try {
			conn = new ConnectionFactory().getConnection();
			
			// reg_date는 default 사용.
			StringBuilder sql = new StringBuilder();
			sql.append("insert into t_client(id, pass, name, nick) ");
			sql.append(" values(?, ?, ?, ?) ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, login.getId());
			pstmt.setString(2, login.getPass());
			pstmt.setString(3, login.getName());
			pstmt.setString(4, login.getNick());

			pstmt.executeUpdate();

		} catch (Exception e) { e.printStackTrace();} 
		finally { JDBCClose.close(conn, pstmt); }
	}
	/**
	 * 전체게시물을 조회하는 메소드
	 */
	public List<MemberVO> selectBoard() throws Exception {

		List<MemberVO> memberList = new ArrayList<>();
		conn = new ConnectionFactory().getConnection();

		String sql = "select no, title, writer, view_cnt ";
		sql += "    , to_char(reg_date, 'yyyy-mm-dd') as reg_date ";
		sql += " from t_client ";
		pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			String id = rs.getString("id");
			String pass = rs.getString("pass");
			String name = rs.getString("name");
			String nick = rs.getString("nick");
			String regDate = rs.getString("reg_date");

			MemberVO member = new MemberVO(id, pass, name, nick, regDate);
			memberList.add(member);
		}
		JDBCClose.close(conn, pstmt);
		return memberList;
	}

	/**
	 * 글번호에 해당하는 게시물 조회
	 */
	public MemberVO selectOneBoard(MemberVO member) {

		MemberVO result = null;

		StringBuffer sql = new StringBuffer();
		sql.append("select id, pass, name ");
		sql.append("     , nick, to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
		sql.append("  from t_client ");
		sql.append(" where id = ? ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, member.getId());
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
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
			}
		} catch (Exception e) { e.printStackTrace();}
		
		return result;
	}
	
	public String getEmail(String _id){
		String eMail = null;

		StringBuffer sql = new StringBuffer();
		sql.append("select id, pass, name ");
		sql.append("     , nick, to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
		sql.append("  from t_client ");
		sql.append(" where id = ? ");

		try (
			  Connection conn = new ConnectionFactory().getConnection();
			  PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){
			pstmt.setString(1, _id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			eMail = rs.getString("nick");
		} catch (Exception e) { e.printStackTrace();}
		return eMail;
	}
}
