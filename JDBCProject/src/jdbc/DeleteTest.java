package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTest {

	public static void main(String[] args) {

		// 1. ����̹� �ε�(���� ����)
		try {
//            ��������
//			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection ��ü ����
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			// String dbUrl = "jdbc:mysql://localhost:3306/project";
			Connection conn = DriverManager.getConnection(dbUrl, "scott", "tiger");

			if (conn != null) {
				System.out.println("������ ���̽� ����");
				conn.close();
			}

			// 3. Statement / PreparedStatemnet
			// insert
			String sql = "delete from dept where deptno=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 50);

			int result = pstmt.executeUpdate();
//			Select�� ����� ����ִ� ��ü

			if (result > 0) {
				System.out.println("�����Ǿ����ϴ�.");
			}

			pstmt.close();
			conn.close();

			// 4. ResultSet

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
