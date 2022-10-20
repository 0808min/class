package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {

	public static void main(String[] args) {

		// 1. ����̹� �ε� ( ���� ���� )
		try {

			// 2. Connectin ��ü ����
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			// String dbUrl = "jdbc:mysql://localhost:3306/project";
			Connection conn = DriverManager.getConnection(dbUrl, "scott", "tiger");

			// 3. Statement / PreparedStatement
			// insert
			String sql = "insert into dept values (?, ?, ?)";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 50);
			pstmt.setString(2, "����");
			pstmt.setString(3, "����");

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("�ԷµǾ����ϴ�.");
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
