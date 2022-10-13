package chapter05;


// 프로그램의 시작 포인트
public class SmartPhoneMain {

	public static void main(String[] args) {
		
//		참조변수 선언 : 인스턴스의 메모리 주소값을 저장
		SmartPhone sp = null;
		
//		인스턴스 생성 : class에서 정의한 변수와 메소드를 사용할 수 있는 상태로 만드는것
//		인스턴스화 -> 변수와 메소드를 메모리에 로드한다
		
		sp = new SmartPhone(); // 인스턴스 메모리를 생성하고 주소값을 반환 
		
//		인스턴스 변수 참조 방법 : 참조변수.인스턴스변수이름
		System.out.println("스마트폰의 제조사 : " + sp.company);
		System.out.println("스마트폰의 색상 : " + sp.color);
		System.out.println("스마트폰의 크기 : " + sp.size);
		System.out.println("스마트폰의 볼륨크기 : " + sp.volumeSize);
		
//		인스턴스 변수할당
		sp.company = "Apple";
		sp.color = "Green";
		sp.size = 6.9f;
		sp.volumeSize = 10;
		
//		인스턴스 변수 참조 방법 : 참조변수.인스턴스변수이름
		System.out.println();
		System.out.println("인스턴스 변수의 값 할당 후 ==============" );
//		System.out.println("스마트폰의 제조사 : " + sp.company);
//		System.out.println("스마트폰의 색상 : " + sp.color);
//		System.out.println("스마트폰의 크기 : " + sp.size);
//		System.out.println("스마트폰의 볼륨크기 : " + sp.volumeSize);	
		
//		인스턴스의 메소드 호출 : 참조변수.메소드이름();
		sp.showInfo();
		System.out.println();
//		볼륨 조정 : 키우기
		
		sp.volumeUp();
		System.out.println("현재 볼륨 : " + sp.volumeSize);
		System.out.println();
		
		sp.volumeDown();
		sp.volumeDown();
		System.out.println("현재 볼륨 : " + sp.volumeSize);
//		sp = null;
	
	}
	
}
