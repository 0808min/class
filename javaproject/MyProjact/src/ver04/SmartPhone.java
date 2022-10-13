package ver04;

import java.util.Scanner;

public class SmartPhone {

	// 기능 클래스 : 속성을 가지지 않고 메소드들로만 정의된 클래스
	// 여러개의 인스턴스가 생성될 필요 없다! => 싱글톤 패턴
	// 1. private 생성자
	// 2. 클래스 내부에서 인스턴스를 생성 static private
	// 3. 내부에서 생성한 참조값을 반환 해주는 메소드 static public

	// 요구사항
	// 이 클래스는 연락처 정보를 관리하는 클래스입니다.
	// ① Contact 클래스의 인스턴스 10개를 저장 할 수 있는 배열을 정의합시다.
	// => 10개 정보를 저장할수 있다. -> 배열 인스턴스를 생성 Contact[]
	// Contact 클래스 기반의 인스턴스를 최대 10개까지 만들어서 배열에 참조값을 저장

	private Contact[] contacts;
	private int numOfContact; // 입력된 정보의 개수, 배열의 index 값으로 사용
	Scanner sc;

	private SmartPhone(int size) {
		contacts = new Contact[size];
		numOfContact = 0;
		sc = new Scanner(System.in);
	}

	private static SmartPhone sp = new SmartPhone(10);

	public static SmartPhone getInstance() {
		if (sp == null) {
			sp = new SmartPhone(10);
		}
		return sp;
	}

	// ② 기능
	// 배열에 인스턴스를 저장하고,
	// 수정하고 ( 이름 으로 검색 ),
	// 삭제 ( 이름 으로 검색 ),
	// 검색 후 결과 출력 ( 이름 으로 검색 ),
	// 저장된 데이터의 리스트를 출력하는 메소드를 정의합니다.

	// 이름 검색후 데이터 수정
	void editContact() {

		// 검색어 받기
		System.out.println("데이터 수정이 진행됩니다.");
		System.out.print("수정하고자 하는 이름을 입력해주세요 >");
		String name = sc.nextLine();

		// 삭제하고자 하는 index 찾아야한다! -> 시프트
		int searchIndex = -1; // 현재 검색의 결과는 없다!

		// 데이터 찾기
		for (int i = 0; i < numOfContact; i++) {
			if (contacts[i].getName().equals(name)) {
				searchIndex = i;
				break;
			}
		}

		if (searchIndex < 0) {
			System.out.println("찾으시는 데이터가 존재하지않습니다.");
			return;
		}

		Contact contact = contacts[searchIndex];

		System.out.println("데이터 수정을 진행합니다.");

		System.out.println("변경하고자하는 이름을 입력해주세요.(현재값: " + contact.getName() + ")\n" + "변경하지않으려면 엔터를치세요 >");
		String newName = sc.nextLine();

		// " abc " -> "abc"
		// " "
		if (newName != null && newName.trim().length() > 0) {
			contact.setName(newName);
		}

		System.out.println("변경하고자하는 전화번호를 입력해주세요.(현재값: " + contact.getPhoneNumber() + ")\n" + "변경하지않으려면 엔터를치세요 >");
		String newPhoneNumber = sc.nextLine();
		if (newPhoneNumber != null && newPhoneNumber.trim().length() > 0) {
			contact.setPhoneNumber(newPhoneNumber);
		}

		System.out.println("변경하고자하는 이메일을 입력해주세요.(현재값: " + contact.getEmail() + ")\n" + "변경하지않으려면 엔터를치세요 >");
		String newEmail = sc.nextLine();
		if (newEmail != null && newEmail.trim().length() > 0) {
			contact.setEmail(newEmail);
		}

		System.out.println("변경하고자하는 주소를 입력해주세요.(현재값: " + contact.getAddress() + ")\n" + "변경하지않으려면 엔터를치세요 >");
		String newAddress = sc.nextLine();
		if (newAddress != null && newAddress.trim().length() > 0) {
			contact.setAddress(newAddress);
		}

		System.out.println("변경하고자하는 생일을 입력해주세요.(현재값: " + contact.getBirthday() + ")\n" + "변경하지않으려면 엔터를치세요 >");
		String newBirthday = sc.nextLine();
		if (newBirthday != null && newBirthday.trim().length() > 0) {
			contact.setBirthday(newBirthday);
		}

		System.out.println("변경하고자하는 그룹을 입력해주세요.(현재값: " + contact.getGroup() + ")\n" + "변경하지않으려면 엔터를치세요 >");
		String newGroup = sc.nextLine();
		if (newGroup != null && newGroup.trim().length() > 0) {
			contact.setGroup(newGroup);
		}

		if (contact instanceof CompanyContact) {

			CompanyContact companyContact = (CompanyContact) contact;

			System.out
					.println("변경하고자하는 회사이름을 입력해주세요.(현재값: " + companyContact.getCompany() + ")\n" + "변경하지않으려면 엔터를치세요 >");
			String company = sc.nextLine();
			if (company != null && company.trim().length() > 0) {
				companyContact.setCompany(company);
			}

			System.out.println(
					"변경하고자하는 부서이름을 입력해주세요.(현재값: " + companyContact.getDivision() + ")\n" + "변경하지않으려면 엔터를치세요 >");
			String division = sc.nextLine();
			if (division != null && division.trim().length() > 0) {
				companyContact.setDivision(division);
			}

			System.out.println("변경하고자하는 직급을 입력해주세요.(현재값: " + companyContact.getManager() + ")\n" + "변경하지않으려면 엔터를치세요 >");
			String manager = sc.nextLine();
			if (manager != null && manager.trim().length() > 0) {
				companyContact.setManager(manager);
			}

		} else if (contact instanceof CustomerContact) {

			CustomerContact customerContact = (CustomerContact) contact;

			System.out.println(
					"변경하고자하는 거래처 이름을 입력해주세요.(현재값: " + customerContact.getCompany() + ")\n" + "변경하지않으려면 엔터를치세요 >");
			String company = sc.nextLine();
			if (company != null && company.trim().length() > 0) {
				customerContact.setCompany(company);
			}

			System.out.println(
					"변경하고자하는 거래품목을 입력해주세요.(현재값: " + customerContact.getProduct() + ")\n" + "변경하지않으려면 엔터를치세요 >");
			String product = sc.nextLine();
			if (product != null && product.trim().length() > 0) {
				customerContact.setProduct(product);
			}

			System.out.println(
					"변경하고자하는 담당자 이름을 입력해주세요.(현재값: " + customerContact.getManager() + ")\n" + "변경하지않으려면 엔터를치세요 >");
			String manager = sc.nextLine();
			if (manager != null && manager.trim().length() > 0) {
				customerContact.setManager(manager);
			}

		}

		System.out.println("정보가 수정되었습니다.");
		System.out.println();

	}

	// 삭제 ( 이름 으로 검색 ),
	void deleteContact() {

		// 검색어 받기
		System.out.println("데이터 삭제가 진행됩니다.");
		System.out.print("삭제하고자 하는 이름을 입력해주세요 >");
		String name = sc.nextLine();

		// 삭제하고자 하는 index 찾아야한다! -> 시프트
		int searchIndex = -1; // 현재 검색의 결과는 없다!

		// 데이터 찾기
		for (int i = 0; i < numOfContact; i++) {
			if (contacts[i].getName().equals(name)) {
				searchIndex = i;
				break;
			}
		}

		// 검색한 index 값으로 분기 : 시프트를 하거나 검색 결과 이름이 존재하지 않는다!
		if (searchIndex < 0) {
			System.out.println("삭제하고자하는 이름의 데이터가 존재하지않습니다.");
		} else {
			for (int i = searchIndex; i < numOfContact - 1; i++) {
				contacts[i] = contacts[i + 1];
			}

			numOfContact--;
			System.out.println("데이터가 삭제되었습니다.");
		}

	}

	// 검색 후 결과 출력 ( 이름 으로 검색 )
	void searchInfoPrint() {

		// 1. 사용자에게 검색할 키워드 입력받는다!
		// 2. 배열에서 이름 검색
		// 3. 결과 출력 : "검색한 이름의 정보가 없습니다."

		String name = null; // 검색할 이름

		System.out.println("검색을 시작합니다.");
		System.out.print("검색할 이름을 입력하세요. >");
		name = sc.nextLine();

		Contact contact = null;

		// 배열에서 검색할 이름을 가지는 인스턴스의 데이터 출력 메소드를 실행
		for (int i = 0; i < numOfContact; i++) {
			// 각 요소의 참조변수로 객체를 참조해서 이름을 비교
			if (contacts[i].getName().equals(name)) {
				contact = contacts[i];
				break;
			}
		}

		// 3. 결과 출력 : "검색한 이름의 정보가 없습니다."
		System.out.println("검색의 결과 ===============");
		if (contact == null) {
			System.out.println("검색한 이름 " + name + " 의 정보가 없습니다.");
		} else {
			contact.printInfo();
		}
	}

	// 전체 입력 데이터의 출력
	void printAllData() {
		// 배열에 저장된 데이터를 모두 출력

		System.out.println("전체 데이터를 출력합니다. ==============");

		if (numOfContact == 0) {
			System.out.println("입력된 정보가 없습니다.");
			return;
		}

		for (int i = 0; i < numOfContact; i++) {
			contacts[i].printInfo();
		}
	}

	// 친구정보 입력
	void insertContact() {
		// 배열에 인스턴스를 저장하고,
		// 1. 데이터 받고
		// 2. 인스턴스 생성
		// 3. 배열에 인스턴스의 참조값을 저장

		if (numOfContact == contacts.length) {
			System.out.println("최대 저장 개수는 " + contacts + "개 입니다.");
			return;
		}

		// 회사 친구 입력 ?
		// 거래처 정보 입력

		System.out.println("입력하고자하는 친구 타입을 선택해주세요.");
		System.out.println("1. 회사 동료 \t 2. 거래처");
		int select = Integer.parseInt(sc.nextLine());

		String name = null;
		String phoneNumber = null;
		String email = null;
		String address = null;
		String birthday = null;
		String group = null;

		// 1. 데이터 받고
		System.out.println("입력을 시작합니다.");

		System.out.print("이름 > ");
		name = sc.nextLine();

		System.out.print("전화번호 >");
		phoneNumber = sc.nextLine();

		System.out.print("이메일 >");
		email = sc.nextLine();

		System.out.print("주소 >");
		address = sc.nextLine();

		System.out.print("생일 >");
		birthday = sc.nextLine();

		System.out.print("그룹 >");
		group = sc.nextLine();

		Contact contact = null;

		// 분기 1. 회사 2. 거래처
		if (select == 1) {
			// CompanyContact 인스턴스 생성

			System.out.println("회사이름 >> ");
			String company = sc.nextLine();
			System.out.println("부서이름 >>");
			String division = sc.nextLine();
			System.out.println("직급 >>");
			String manager = sc.nextLine();

			// 2. 인스턴스 생성
			contact = new CompanyContact(name, phoneNumber, email, address, birthday, group, company, division,
					manager);

		} else {
			// CustomerContact 인스턴스 생성

			System.out.println("거래처 이름 >>");
			String company = sc.nextLine();
			System.out.println("거래 품목 >>");
			String product = sc.nextLine();
			System.out.println("담당자 >>");
			String manager = sc.nextLine();

			// 2. 인스턴스 생성
			contact = new CustomerContact(name, phoneNumber, email, address, birthday, group, company, product,
					manager);
		}

		// 배열에 저장
		// 처음 입력 : numOfContact => 0
		contacts[numOfContact++] = contact;
		// numOfContact++;

	}

}