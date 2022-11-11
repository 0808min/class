package potato.service;

import java.sql.Connection;
import java.sql.SQLException;

import potato.domain.Board;
import potato.util.ConnectionProvider;
import potato.dao.BoardDao;

public class InsertService {

BoardDao dao;
	
	public InsertService(BoardDao dao) {
		this.dao = dao;
	}
	
	public int insert(Board board) {
		
		int result = 0;
		Connection conn = null;
		
		try {
			conn= ConnectionProvider.getConnection();
			
			result = dao.insert(conn, board);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
}
