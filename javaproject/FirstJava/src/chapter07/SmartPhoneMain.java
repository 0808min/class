package chapter07;

public class SmartPhoneMain {

	public static void main(String[] args) {
		
		AndroidPhone ap = new AndroidPhone("010-1111-1111");
		
		Phone phone = ap; // 하위타입에서 => 상위타입 형변환일 때 형변환 연산은 생략가능
		
		ap.call();
		
		Phone phone2 = new Phone("010-2222-3333");
		
//		형변환 연산자 : 확인하고자 하는 참조변수 instanceof 확인할 타입
		System.out.println(phone2 instanceof IPhone);
		
		if(phone2 instanceof IPhone) {
			IPhone ip = (IPhone)phone2;
			System.out.println("아이폰으로 변경");
		} else {
			System.out.println("아이폰으로 변경불가");
		}
		
		Phone phone3 = new IPhone("010-7777-8888");
		
		if(phone3 instanceof IPhone) {
			IPhone ip = (IPhone)phone3;
			ip.call();
		}

		

	}

}
