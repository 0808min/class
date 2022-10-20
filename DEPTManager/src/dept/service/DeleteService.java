package dept.service;

import java.sql.Connection;
import java.sql.SQLException;

import dept.dao.Dao;
import dept.dao.OracleDao;
import dept.util.ConnectionProvider;

public class DeleteService {
	
	Dao dao = new OracleDao();
	
    public int delete(int detpno) {
    	
    	int result = 0;
    	
    	Connection conn = null;
    	
    	try {
    		conn = ConnectionProvider.getConnection();
    		
			result = dao.delete(conn, result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	return result;
    	
    }

}
