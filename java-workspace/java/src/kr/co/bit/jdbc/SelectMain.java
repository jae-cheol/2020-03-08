package kr.co.bit.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.co.bit.util.ConnectionFactory;
import kr.co.bit.util.JDBCClose;
/*
 * (자바)
 * 1. 자바에서 DB로의 접속 통로를 열고
 * 2. 그 통로를 통해 명령을 보내면
 * 
 * (디비)
 * 3. DB에서 명령을 처리하고
 * 4. 그 처리한 값을 돌려보냄.
 */
public class SelectMain {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			ConnectionFactory factory = new ConnectionFactory();
			conn = factory.getConnection();

			System.out.println("conn : " + conn);

			String sql = "select * from t_test ";
			pstmt = conn.prepareStatement(sql);

			// executeQuery로 명령하면 ResultSet이라는 객체를 돌려줌.
			ResultSet rs = pstmt.executeQuery();

			// rs는 1보다 이전의 위치에 있음.(true) rs.next()를 해야 1의 위치로 이동(true)
			// rs.next()가 끝위치에서 그 다음으로 가면(false)
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.println("id : " + id + ", name : " + name);
			}
//			rs.getInt("no"); // rs.getInt(1) 1번째 컬럼
//			rs.getString("title"); // rs.getString(2) 2번째 컬럼
			// 컬럼 1번째,~~~~ n번째
			// rs에서 no가 있는값을 가르쳐줘..
		} catch (Exception e) { e.printStackTrace(); } 
		finally { JDBCClose.close(conn, pstmt); }
	}
}