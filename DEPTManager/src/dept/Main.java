package dept;

import java.util.Scanner;

import dept.controller.ExitController;
import dept.controller.InsertController;
import dept.controller.SelectByController;
import dept.controller.SelectController;
import dept.controller.UpdateController;

public class Main {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
//		Controller controller = new Controller();
		
		while(true) {
			
			menu();
			System.out.println("�޴��� �Է��ϼ��� >> ");
			int select = Integer.parseInt(sc.nextLine());
			
			switch (select) {
			case 1:
//				controller.select();
				new SelectController().process();
				break;
			case 2:	
//				controller.selectByDeptno();
				new SelectByController().process();
				break;
			case 3:	
//				controller.insert();
				new InsertController().process();
				break;
			case 4:	
//				controller.update();
				new UpdateController().process();
				break;
			case 5:	
//				controller.delete();
				break;
			case 6:	
//				controller.exit();
				new ExitController().process();
			}

		}
	
	}
	
	public static void menu() {
		System.out.println("�μ����� ���α׷�");
		System.out.println("1. ��ü �μ� ����Ʈ");
		System.out.println("2. �μ��˻�");
		System.out.println("3. �μ� ���� ����");
		System.out.println("4. �μ� ���� ����");
		System.out.println("5. �μ� ���� ����");
		System.out.println("6. ����");
	}

}
