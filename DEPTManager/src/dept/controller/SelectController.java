package dept.controller;

import java.util.List;

import dept.domain.Dept;
import dept.service.SelectService;

public class SelectController {
	
	SelectService service = new SelectService();
	
	public void process() {
		
//		������� ��û�� ó�� �� ���񽺷� ��û
//		�μ� ��ü ����Ʈ�� ���
//		List<Dept>
		
		List<Dept> list = service.select();
		
		if(list != null && !list.isEmpty()) {
			
			for(Dept d : list) {
				System.out.println(d);
			}
		} else {
			System.out.println("�˻���� ����");
		}
		
	}

}
