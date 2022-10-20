package dept.dao;

import java.sql.Connection;
import java.util.List;

import dept.domain.Dept;

public class MysqlDao implements Dao{

	@Override
	public List<Dept> select(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dept selectByDeptno(Connection conn, int deptno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Connection conn, Dept dept) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Connection conn, Dept dept) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Connection conn, int deptno) {
		// TODO Auto-generated method stub
		return 0;
	}

}
