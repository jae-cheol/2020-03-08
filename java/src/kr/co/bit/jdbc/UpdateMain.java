package kr.co.bit.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import kr.co.bit.util.ConnectionFactory;
import kr.co.bit.util.JDBCClose;

///////////// PreparedStatement pstmt /////////////
public class UpdateMain {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try { conn = new ConnectionFactory().getConnection();	StringBuffer sql = new StringBuffer();	Scanner sc = new Scanner(System.in);
			System.out.println("conn : " + conn);
			sql.append("update t_test ");
			sql.append(" set name = ? ");
			sql.append(" where id = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			System.out.println("아이디를 입력 : ");
			String id = sc.nextLine();
			System.out.println("변경할 이름을 입력 : ");
			String name = sc.nextLine();
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			
			// (insert , delete , update)메소드는 삽입된 행의 수 뽑아냄.
			int cnt = pstmt.executeUpdate(); 
			System.out.println(cnt + "행이 수정되었습니다.");
		} catch(Exception e) { e.printStackTrace(); }
		finally { JDBCClose.close(conn, pstmt); }
	}
}
