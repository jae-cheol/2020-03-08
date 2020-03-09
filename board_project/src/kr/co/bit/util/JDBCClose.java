package kr.co.bit.util;

import java.sql.Connection;
import java.sql.Statement;

public class JDBCClose {
	// 객체생성 안하고 만들수있는 static	// prepareStatement 를 상속해주니깐.
	public static void close(Connection conn, Statement stmt) {
		// 5단계 : DB접속 해제 - 연결해제 - finally에 있어야함.
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
