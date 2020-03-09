package member.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import member.vo.MemberVO;
import kr.co.bit.util.ConnectionFactory;
import kr.co.bit.util.JDBCClose;

/*
 * DB에 게시물관리
 */
public class MemberDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;

	/**
	 * 회원 등록하는 메소드
	 * @param 회원VO
	 */
	public void insertBoard(MemberVO member)  {
	
		try {
			conn = new ConnectionFactory().getConnection();
			
			/*
			 * insert into t_client(id, pw, name, nick, reg_date)
				values('jcdoom', '0000', '김재철', '재철', sysdate);
			 */
			StringBuilder sql = new StringBuilder();
			sql.append("insert into t_client(id, pw, name, nick) ");
			sql.append(" values(?, ?, ?, ?) ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getNick());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
	}
	
	/**
	 * 전체회원을 조회하는 메소드
	 */
	public List<MemberVO> selectBoard() throws Exception {
		
		List<MemberVO> memberList = new ArrayList<>();
		
		conn = new ConnectionFactory().getConnection();
		
		String sql = "select id, pw, name, nick ";
		       sql += "    , to_char(reg_date, 'yyyy-mm-dd') as reg_date ";
		       sql += " from t_client ";
		pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String id = rs.getString("id");
			String pw = rs.getString("pw");
			String name = rs.getString("name");
			String nick = rs.getString("nick");
			String regDate = rs.getString("reg_date");

			// BoardVO board = new BoardVO();
			// board.setNo(no);
			// board.setTitle(title);
			// board.setWriter(writer);
			// board.setViewCnt(viewCnt);
			// board.setRegDate(regDate);

			MemberVO member = new MemberVO(id, pw, name, nick, regDate);
			memberList.add(member);
		}
		JDBCClose.close(conn, pstmt);
		
		return memberList;
	}	
}