package dept.controller;

import dept.Main;
import dept.domain.Dept;
import dept.service.UpdateService;

public class UpdateController implements Controller {

	UpdateService service = new UpdateService();

	public void process() {

//		사용자 데이터 요청
		System.out.println("부서정보의 수정을 시작합니다.");

		System.out.println("수정할 부서번호를 입력하세요. >> ");
		int deptno = Integer.parseInt(Main.sc.nextLine());

		System.out.println("새로운 부서이름 >> ");
		String dname = Main.sc.nextLine();

		System.out.println("새로운 지역이름 >> ");
		String loc = Main.sc.nextLine();

//		수정처리

		int result = service.update(new Dept(deptno, dname, loc));

//		결과출력
		if (result > 0) {
			System.out.println("수정되었습니다.");
		} else {
			System.out.println("수정실패");
		}

	}

}