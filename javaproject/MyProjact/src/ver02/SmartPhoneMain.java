
package ver02;

public class SmartPhoneMain {

	public static void main(String[] args) {
		
		SmartPhone smartPhone = SmartPhone.getInstance();
		
		
//		입력
		smartPhone.insertContact();
//		전체출력
		smartPhone.printAllData();
//		이름 검색 후 결과 출력
		smartPhone.searchInfoPrint();
	}

}
