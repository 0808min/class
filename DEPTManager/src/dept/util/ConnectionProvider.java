package dept.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

//	Connection ��ü�� �����ؼ� �������ִ� �޼ҵ�
	public static Connection getConnection() {
		
		String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		// String dbUrl = "jdbc:mysql://localhost:3306/project";
		
		Connection conn = null;
		

			try {
				conn = DriverManager.getConnection(dbUrl, "scott", "tiger");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	
			
		
		
		return conn;
		
		
	}
	
	
}
