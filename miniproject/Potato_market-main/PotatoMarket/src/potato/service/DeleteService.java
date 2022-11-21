package potato.service;

import java.sql.Connection;
import java.sql.SQLException;

import potato.domain.Board;
import potato.dao.BoardDao;
import potato.util.ConnectionProvider;

public class DeleteService {

	BoardDao dao;

	public DeleteService(BoardDao dao) {
		this.dao = dao;
	}

	public int delete(Board board) {
		int result = 0;
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();

			result = dao.delete(conn, board);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}

}