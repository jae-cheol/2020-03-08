package kr.co.bit.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.bit.board.vo.BoardVO;
import kr.co.bit.util.ConnectionFactory;
import kr.co.bit.util.JDBCClose;

/*
 * DB�� �Խù�����
 */
public class BoardDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;

	/**
	 * �Խñ��� ����ϴ� �޼ҵ�
	 * @param �Խñ�VO
	 */
	public void insertBoard(BoardVO board)  {
	
		try {
			conn = new ConnectionFactory().getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("insert into t_board(no, title, writer) ");
			sql.append(" values(seq_t_board_no.nextval, ?, ?) ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
	}
	
	/**
	 * ��ü�Խù��� ��ȸ�ϴ� �޼ҵ�
	 */
	public List<BoardVO> selectBoard() throws Exception {
		
		List<BoardVO> boardList = new ArrayList<>();
		
		conn = new ConnectionFactory().getConnection();
		
		String sql = "select no, title, writer, view_cnt ";
		       sql += "    , to_char(reg_date, 'yyyy-mm-dd') as reg_date ";
		       sql += " from t_board ";
		pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			int no = rs.getInt("no");
			String title = rs.getString("title");
			String writer = rs.getString("writer");
			int viewCnt = rs.getInt("view_cnt");
			String regDate = rs.getString("reg_date");

			// BoardVO board = new BoardVO();
			// board.setNo(no);
			// board.setTitle(title);
			// board.setWriter(writer);
			// board.setViewCnt(viewCnt);
			// board.setRegDate(regDate);

			BoardVO board = new BoardVO(no, title, writer, viewCnt, regDate);
			boardList.add(board);
		}
		JDBCClose.close(conn, pstmt);
		
		return boardList;
	}
	
	/**
	 * �۹�ȣ�� �ش��ϴ� �Խù� ��ȸ
	 */
	public BoardVO selectOneBoard(BoardVO board) {
		
		BoardVO result = null;
		
		StringBuffer sql = new StringBuffer();
		sql.append("select no, title, writer ");
		sql.append("     , to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
		sql.append("  from t_board ");
		sql.append(" where no = ? ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setInt(1, board.getNo());
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new BoardVO();
				
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String regDate = rs.getString("reg_date");
				
				result.setNo(no);
				result.setTitle(title);
				result.setWriter(writer);
				result.setRegDate(regDate);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}












