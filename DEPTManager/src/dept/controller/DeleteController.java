package dept.controller;

import dept.Main;
import dept.service.DeleteService;

public class DeleteController {
	
	DeleteService service = new DeleteService();
	
	public void process() {
		
//		������� ��û ������ �ް�
		System.out.println("�μ� ������ ����˴ϴ�.");
		System.out.println("������ �μ���ȣ >> ");
		int deptno = Integer.parseInt(Main.sc.nextLine());
//		����ó��
		int result = service.delete(deptno);
//		������
		if(result > 0) {
			System.out.println("�����Ǿ����ϴ�");
		} else {
			System.out.println("��������");
		}
		
	}

}
