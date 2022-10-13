package chapter07;

public class SmartPhoneMain2 {

	public static void main(String[] args) {
		AndroidPhone androidPhone = new AndroidPhone("010-1111-2222");
		IPhone iphone = new IPhone("010-2252-3333");
		GooglePhone googlePhone = new GooglePhone("010-4444-5555");
		
		callByPhone(androidPhone);
		callByPhone(iphone);
		callByPhone(googlePhone);

	}
	
	static void callByphone(Phone phone) {
		
//		매소드의 매개변수
//		Phone phone = AndroidPhone;
		phone.call();
		
	}
//	안드
	static void callByPhone(AndroidPhone phone) {
		phone.call();
	}
//	애플
	static void callByPhone(IPhone phone) {
		phone.call();
	}
//	구글
	static void callByPhone(GooglePhone phone) {
		phone.call();
	}


}
