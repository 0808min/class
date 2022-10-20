package dept.controller;

import java.util.List;

import dept.dao.MysqlDao;
import dept.dao.OracleDao;
import dept.domain.Dept;
import dept.service.SelectService;

public class SelectController implements Controller {
	
	//SelectService service = new SelectService(new OracleDao());
	SelectService service = new SelectService(new MysqlDao());
	
	public void process() {
		
		// 사용자의 요청을 처리할 서비스로 처리 요청
		// 부서 전체 리스트를 출력
		// List<Dept> 
		
		List<Dept> list = service.select();
		
		if(list != null && !list.isEmpty()) { 
			
			for(Dept d : list) {
				System.out.println(d);
			}
		} else {
			System.out.println("검색 결과 없음!");
		}
		
	}

}