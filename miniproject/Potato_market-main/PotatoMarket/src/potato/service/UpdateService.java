package potato.service;

import java.sql.Connection;
import java.sql.SQLException;

import potato.dao.BoardDao;
import potato.domain.Board;
import potato.util.ConnectionProvider;

// 게시글 수정 실행 서비스
public class UpdateService {
	
	BoardDao dao;
	
	public UpdateService(BoardDao dao) {
		this.dao = dao;
	}
	
	public int updateByID(Board board) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			result = dao.update(conn, board);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
