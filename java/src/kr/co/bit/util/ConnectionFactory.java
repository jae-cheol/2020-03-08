package kr.co.bit.util;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * Factory - ���ϴ� ��ü�� �ϳ��� ������ִ� ����.
 */
public class ConnectionFactory {

	public Connection getConnection() {

		Connection conn = null;
		try {
			// 1�ܰ� : ����̹� �ε� - �������� Ŭ���� �ν��ϰ� ��.
			// üũ�� �ͼ���
			Class.forName("oracle.jdbc.driver.OracleDriver");
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
}
