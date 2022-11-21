package potato.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import potato.domain.LoginData;

public class UserDao {
	public int selectByUserIdAndPw(Connection conn, LoginData loginData) throws SQLException {
		int result = 0;
		String sql = "Select * from potato_user where userid = ? and password = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginData.getId());
			pstmt.setString(2, loginData.getPassword());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // next가 있다는 건, id와 pw가 같은 row가 있다는 거임
				result++;
			}
		} finally {
			if(rs !=null) rs.close();
			if(pstmt != null) pstmt.close();	
		}
		
		return result;
	}
}
