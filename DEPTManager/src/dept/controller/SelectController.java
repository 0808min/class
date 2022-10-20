package dept.controller;

import java.util.List;

import dept.domain.Dept;
import dept.service.SelectService;

public class SelectController {
	
	SelectService service = new SelectService();
	
	public void process() {
		
//		사용자의 요청을 처리 할 서비스로 요청
//		부서 전체 리스트를 출력
//		List<Dept>
		
		List<Dept> list = service.select();
		
		if(list != null && !list.isEmpty()) {
			
			for(Dept d : list) {
				System.out.println(d);
			}
		} else {
			System.out.println("검색결과 없음");
		}
		
	}

}
