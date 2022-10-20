package dept.service;

import java.sql.Connection;
import java.sql.SQLException;

import dept.dao.Dao;
import dept.dao.OracleDao;
import dept.domain.Dept;
import dept.util.ConnectionProvider;

public class SelectByService {
	
	Dao dao = new OracleDao();
	
	public Dept selectByDeptno(int deptno) throws SQLException {
		
		Dept dept = null;
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			dept = dao.selectByDeptno(conn, deptno);
			
		} finally {
			if(conn != null) {
				conn.close();
			}
		}
		
		return dept;
		
	}

}
