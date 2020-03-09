package kr.co.bit.util;

import java.sql.Connection;
import java.sql.Statement;

public class JDBCClose {
	// ��ü���� ���ϰ� ������ִ� static	// prepareStatement �� ������ִϱ�.
	public static void close(Connection conn, Statement stmt) {
		// 5�ܰ� : DB���� ���� - �������� - finally�� �־����.
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
