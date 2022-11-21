package potato.service;

import java.sql.Connection;
import java.sql.SQLException;

import potato.dao.PerchaseDao;
import potato.domain.PerchaseData;
import potato.util.ConnectionProvider;

public class PerchaseService {

	PerchaseDao dao;

	public PerchaseService(PerchaseDao dao) {
		this.dao = dao;
	}

	public int perchase(PerchaseData perchase) {

		int result = 0;
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();
			result = dao.perchase(conn, perchase);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}

}
