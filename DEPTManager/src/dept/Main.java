package dept;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Controller controller = new Controller();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			menu();
			System.out.println("�޴��� �Է��ϼ��� >> ");
			int select = Integer.parseInt(sc.nextLine());
			
			switch (select) {
			case 1:
				controller.select();
				break;
			case 2:	
				controller.selectByDeptno();
				break;
			case 3:	
				controller.insert();
				break;
			case 4:	
				controller.update();
				break;
			case 5:	
				controller.delete();
				break;
			case 6:	
				
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
