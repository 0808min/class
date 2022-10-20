package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest2 {

	public static void main(String[] args) {

		// 1. 드라이버 로드 ( 생략 가능 )
		try {
			// 생략 가능!
			// Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connectin 객체 생성
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			// String dbUrl = "jdbc:mysql://localhost:3306/project";
			Connection conn = DriverManager.getConnection(dbUrl, "scott", "tiger");

//			if(conn != null) {
//				System.out.println("데이터베이스 연결!!!!");
//				//conn.close();
//			}

			// 3. Statement / PreparedStatement
			String sql = "select * from dept where deptno=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 10);

			// Select의 결과를 담고 있는 객체
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");

				System.out.printf("%d \t %s \t %s \n", deptno, dname, loc);
			}

			rs.close();
			// stmt.close();
			pstmt.close();
			conn.close();

			// 4. ResultSet

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
