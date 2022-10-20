package dept.controller;

import java.util.List;

import dept.Main;
import dept.domain.Dept;
import dept.service.SelectService;

public class SelectByController {
	
	SelectService service = new SelectService();
	
	public void process() {
		
		System.out.println("�˻� �μ���ȣ >> ");
		int deptno = Integer.parseInt(Main.sc.nextLine());
		
		Dept dept = service.seleByDeptno(deptno);
		
		System.out.println("�˻���� =============================");
		if(dept != null) {
			System.out.println(dept);
		} else {
			System.out.println("�˻��� �μ��� ������ �����ϴ�.");
		}

	}

}
