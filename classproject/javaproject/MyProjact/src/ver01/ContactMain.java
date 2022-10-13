package ver01;

import java.util.Scanner;

public class ContactMain {

	public static void main(String[] args) {

		Contact data = new Contact();

		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.print("이름을 입력 >> ");
			data.setName(sc.nextLine());

			System.out.print("전화번호를 입력 >> ");
			data.setPhoneNumber(sc.nextLine());

			System.out.print("이메일을 입력 >> ");
			data.setEmail(sc.nextLine());

			System.out.print("주소를 입력 >> ");
			data.setAddress(sc.nextLine());

			System.out.print("생일을 입력 >> ");
			data.setBirthday(sc.nextLine());

			System.out.print("그룹을 입력 >> ");
			data.setGroup(sc.nextLine());

			data.tell();

			System.out.print("계속 진행 1, 종료 0 입력 >>>");

			if (Integer.parseInt(sc.nextLine()) == 0) {
				sc.close();
				break;
			}

		}

	}

}
