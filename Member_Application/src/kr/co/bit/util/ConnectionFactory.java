package kr.co.bit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*
 * Factory - ���ϴ� ��ü�� �ϳ��� ������ִ� ����.
 */
public class ConnectionFactory {

	public Connection getConnection() {

		Connection conn = null;
		try {
			// 1�ܰ� : ����̹� �ε� - �������� Ŭ���� �ν��ϰ� ��.
			Class.forName("oracle.jdbc.driver.OracleDriver"); // üũ�� �ͼ���
			System.out.println("����̹� �ε� ����...");

			// 2�ܰ� : ����̹� ����, DB���� �� ���ᰴü ��� - �����ϱ� ���� ip,port���.. �˾ƾߵ�.
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			// JDBC_URL ���� = jdbc:oracle:thin:@IP�ּ�:��Ʈ:SID
							// ������ ��.--------// SID = XE�� ������.
			String user = "hr";
			String password = "hr";
			
			conn = DriverManager.getConnection(url, user , password);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void close(Connection conn, Statement stmt) {

		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
