package potato.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import potato.domain.PerchaseData;

public class PerchaseDao {

//	구매내역 조회
	public int perchase(Connection conn, PerchaseData perchasedata) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "";
		

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, perchasedata.getUserid());
			pstmt.setInt(2, perchasedata.getBoardid());
			pstmt.setInt(3, perchasedata.getOrderid());

			result = pstmt.executeUpdate();

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return result;

	}

}
