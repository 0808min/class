package chapter02;

public class Test {
	
	public static void main(String[] args) {
		// ① 회원이름을 저장하는 변수
		String memberName = null;
		// ② 회원 전화번호 ( 000-0000-0000 )를 저장하는 변수
		String phoneNumber = null;
		// ③ 회원 주민등록번호 ( 000000-0000000 또는 0000000000000 )를 저장하는 변수
		String personNumber = null;
		
		memberName = "박민";
		phoneNumber = "010-7547-1556";
		personNumber = "910808";
		
		
		
		System.out.println("회원번호 : " + memberName);
		System.out.println("회원 전화번호 : " + phoneNumber);
		System.out.println("회원 주민번호 : " + personNumber);
	}

}
