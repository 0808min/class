package chapter05.Exam;

public class Member{

	// ① 아래의 데이터를 저장 이름, 전화번호, 전공, 학년, email, 생일, 주소
	// ② 위에서 정의한 정보를 출력하는 메소드 정의
	// ③ 모든 정보를 저장하도록 하는 생성자와    /    생일과 주소는 저장하지 않을 수 있는 생성자를 정의
	// ④ main() 메소드에서 두 가지 생성자를 이용해서 인스턴스 생성하고 출력 메소드를 통해 저장된 데이터 출력

	// 변수 선언
	private String name;
	private String phoneNumber;
	private String major;
	private int grade;
	private String email;
	// 생일 표현 : 문자열? 정수? : 19990101 20020101
	private int birthday;
	private String address;
	
	// 생성자
	public Member(String name, String phoneNumber, String major, int grade, String email, int birthday,
			String address) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.major = major;
		this.grade = grade;
		this.email = email;
		this.birthday = birthday;
		this.address = address;
	}
	
	public Member(String name, String phoneNumber, String major, int grade, String email) {
		this(name, phoneNumber, major, grade, email, 0, null);
//		this.name = name;
//		this.phoneNumber = phoneNumber;
//		this.major = major;
//		this.grade = grade;
//		this.email = email;
		//this.birthday = birthday;
		//this.address = address;
	}
	
	// 메소드
	public void showMemberInfo() {
		System.out.println("회원 정보 -------------");
		System.out.println("이름 : " + this.name);
		System.out.println("전화 : " + this.phoneNumber);
		System.out.println("전공 : " + this.major);
		System.out.println("학년 : " + this.grade);
		System.out.println("이메일: " + this.email);
		System.out.println("생일 : " + ( this.birthday==0 ? "미입력" : this.birthday) );
		System.out.println("주소 : " + ( this.address==null ? "미입력" : this.address) );
	
//		if(this.birthday != 0 && this.address != null) {
//			System.out.println("생일 : " + this.birthday);
//			System.out.println("주소 : " + this.address);
//				
//		}
		
	}
	
	

}


