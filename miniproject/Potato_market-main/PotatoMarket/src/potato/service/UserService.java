package potato.service;

import java.sql.Connection;
import java.sql.SQLException;

import potato.dao.UserDao;
import potato.domain.LoginData;
import potato.util.ConnectionProvider;

public class UserService {
	UserDao dao = new UserDao();

	public boolean signIn(LoginData loginData) {
		Connection conn = null;
		boolean result = false;
		try {
			
			conn = ConnectionProvider.getConnection();
			if(dao.selectByUserIdAndPw(conn, loginData) == 1) {
				result = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
}
