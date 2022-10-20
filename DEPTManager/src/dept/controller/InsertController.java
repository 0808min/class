package dept.controller;

import dept.Main;
import dept.domain.Dept;
import dept.service.InsertService;

public class InsertController implements Controller {
	
	InsertService service = new InsertService();
	
	public void process() {
		
		System.out.println("�μ� �����Է��� �����մϴ�.");
		System.out.println("�μ���ȣ >> ");
		int deptno = Integer.parseInt(Main.sc.nextLine());
		System.out.println("�μ��̸� >> ");
		String dname = Main.sc.nextLine();
		System.out.println("�μ���ġ >> ");
		String loc = Main.sc.nextLine();
		
		int result = service.insert(new Dept(deptno, dname, loc));
		
		if(result > 0) {
			System.out.println("�ԷµǾ����ϴ�.");
		} else {
			System.out.println("�Է� ����");
		}
	}

}

