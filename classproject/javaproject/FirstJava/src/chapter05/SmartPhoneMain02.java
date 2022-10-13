
package chapter05;

public class SmartPhoneMain02 {
	
//	인스턴스는 생성할때 마다 개별(독립)적인 메모리공간이 생성
//	클래스 내부에서 정의한 변수들도 인스터스 생성과 동시에 생성이 가능
//	참조변수는 주소값만 가지는것이다.
	
	public static void main(String[] args) {
		
		SmartPhone sp1 = new SmartPhone();
		SmartPhone sp2 = new SmartPhone();
		
//		참조변수의 주소값 비교
		System.out.println("sp1 주소 == sp2 주소 : " + (sp1==sp2));
		
		sp1.showInfo();
		sp2.showInfo();
		
		////////////////////////////////////////////
		
//		각 인스턴스의 속성값을 적용해보자
		sp1.company = "APPLE";
		sp1.color = "GREEN";
		sp1.size = 6.9f;
		sp1.volumeUp();
		sp1.volumeUp();
		
		System.out.println(); 
		
		sp2.company = "SAMSUNG";
		sp2.color = "BLACK";
		sp2.size = 5.9f;
		sp2.volumeUp();
		sp2.volumeUp();
		sp2.volumeUp();
		sp2.volumeUp();
		System.out.println();
		
		System.out.println("각 인스턴스 설정 후 데이터 출력");
		sp1.showInfo();
		System.out.println();
		sp2.showInfo();
		
		
		////////////////////////////////////////////
		
		sp2 = sp1;
		// 매개변수 : 메소드에서 정의
		// int num1, int num2
		
		System.out.println();
		sp1.showInfo();
		sp2.showInfo();
		System.out.println();
		System.out.println();
		
		// sp1은 인스턴스의 주소값을 가지고 있다.
		showPhoneInfo(sp1); //SmartPhone 인스턴스를 가르치는 주소값을 전달해주어야 한다.
		
		
	
		
	}
	
	public static void showPhoneInfo(SmartPhone sp) {
		// SmartPhone sp = 0X100;
		
		System.out.println("매개변수를 참조변수로 정의해서 메소드 내부에서 객체참조");
		sp.showInfo();
		
	}
	
	
	
		
}
