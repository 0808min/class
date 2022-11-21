package potato.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import potato.dao.BoardDao;
import potato.domain.Board;
import potato.util.ConnectionProvider;

// 내 판매 내역 확인 처리
public class SellHistoryService {
	
	BoardDao dao;
	
	public SellHistoryService(BoardDao dao) {
		this.dao = dao;
	}
	
	public List<Board> myPurchaseHistory() {
		
		Connection conn =null;
		List<Board> list =null;

		try {
			conn = ConnectionProvider.getConnection();
			list = dao.select(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return list;
		
	}

}
