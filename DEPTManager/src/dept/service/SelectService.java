package dept.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dept.dao.Dao;
import dept.dao.OracleDao;
import dept.domain.Dept;
import dept.util.ConnectionProvider;

public class SelectService {

//	Service : 핵심 로직을 처리하는 영역
//	Controller 에서 요청한 결과를 생성하고 반환
//	필요한 DB 작업은 Dao 를 통해서 작업 

	Dao dao = new OracleDao();

	public List<Dept> select() {

		List<Dept> list = null;
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();
			list = dao.select(conn);

		} catch (SQLException e) {
//			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		return list;

	}

	public Dept seleByDeptno(int deptno) {
		// TODO Auto-generated method stub
		return null;
	}

}
