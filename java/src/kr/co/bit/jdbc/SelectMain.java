package kr.co.bit.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.co.bit.util.ConnectionFactory;
import kr.co.bit.util.JDBCClose;
/*
 * (�ڹ�)
 * 1. �ڹٿ��� DB���� ���� ��θ� ����
 * 2. �� ��θ� ���� ����� ������
 * 
 * (���)
 * 3. DB���� ����� ó���ϰ�
 * 4. �� ó���� ���� ��������.
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

			// executeQuery�� ����ϸ� ResultSet�̶�� ��ü�� ������.
			ResultSet rs = pstmt.executeQuery();

			// rs�� 1���� ������ ��ġ�� ����.(true) rs.next()�� �ؾ� 1�� ��ġ�� �̵�(true)
			// rs.next()�� ����ġ���� �� �������� ����(false)
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.println("id : " + id + ", name : " + name);
			}
//			rs.getInt("no"); // rs.getInt(1) 1��° �÷�
//			rs.getString("title"); // rs.getString(2) 2��° �÷�
			// �÷� 1��°,~~~~ n��°
			// rs���� no�� �ִ°��� ��������..
		} catch (Exception e) { e.printStackTrace(); } 
		finally { JDBCClose.close(conn, pstmt); }
	}
}