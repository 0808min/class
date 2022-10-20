package dept.controller;

import dept.Main;
import dept.domain.Dept;
import dept.service.UpdateService;

public class UpdateController {

	UpdateService service = new UpdateService();

	public void process() {

//		����� ������ ��û
		System.out.println("�μ������� ������ �����մϴ�.");

		System.out.println("������ �μ���ȣ�� �Է��ϼ���. >> ");
		int deptno = Integer.parseInt(Main.sc.nextLine());

		System.out.println("���ο� �μ��̸� >> ");
		String dname = Main.sc.nextLine();

		System.out.println("���ο� �����̸� >> ");
		String loc = Main.sc.nextLine();

//		����ó��

		int result = service.update(new Dept(deptno, dname, loc));

//		������
		if (result > 0) {
			System.out.println("�����Ǿ����ϴ�.");
		} else {
			System.out.println("��������");
		}

	}

}
