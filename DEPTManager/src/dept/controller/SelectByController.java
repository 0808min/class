package dept.controller;

import java.sql.SQLException;

import dept.Main;
import dept.domain.Dept;
import dept.service.SelectByService;

public class SelectByController implements Controller {

	SelectByService service = new SelectByService();

	public void process() {

		System.out.println("검색 부서번호 >> ");
		int deptno = Integer.parseInt(Main.sc.nextLine());

		Dept dept = null;
		try {
			dept = service.selectByDeptno(deptno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("검색 결과 =====================");
		if (dept != null) {
			System.out.println(dept);
		} else {
			System.out.println("검색한 부서의 정보가 없습니다.");
		}

	}

}