package dept.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dept.domain.Dept;

public interface Dao {

	List<Dept> select(Connection conn)throws SQLException; 
	Dept selectByDeptno(Connection conn, int deptno)throws SQLException;
	
//	DML = int °á°ú
	int insert(Connection conn, Dept dept)throws SQLException;
	int update(Connection conn, Dept dept)throws SQLException;
	int delete(Connection conn, int deptno)throws SQLException;

	
}
