package kr.co.bit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*
 * Factory - 원하는 객체를 하나씩 만들어주는 개념.
 */
public class ConnectionFactory {

	public Connection getConnection() {

		Connection conn = null;
		try {
			// 1단계 : 드라이버 로딩 - 동적으로 클래스 인식하게 함.
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 체크드 익셉션
			System.out.println("드라이버 로딩 성공...");

			// 2단계 : 드라이버 선택, DB접속 후 연결객체 얻기 - 접속하기 위한 ip,port등등.. 알아야됨.
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			// JDBC_URL 구성 = jdbc:oracle:thin:@IP주소:포트:SID
							// 동일한 값.--------// SID = XE값 같은거.
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
