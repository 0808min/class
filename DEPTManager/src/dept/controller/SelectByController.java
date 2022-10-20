package dept.controller;

import java.util.List;

import dept.Main;
import dept.domain.Dept;
import dept.service.SelectService;

public class SelectByController {
	
	SelectService service = new SelectService();
	
	public void process() {
		
		System.out.println("검색 부서번호 >> ");
		int deptno = Integer.parseInt(Main.sc.nextLine());
		
		Dept dept = service.seleByDeptno(deptno);
		
		System.out.println("검색결과 =============================");
		if(dept != null) {
			System.out.println(dept);
		} else {
			System.out.println("검색한 부서의 정보가 없습니다.");
		}

	}

}
