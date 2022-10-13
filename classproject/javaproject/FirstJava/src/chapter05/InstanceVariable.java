package chapter05;

public class InstanceVariable {

//	 인스턴스 변수는 인스턴스 생성시에 생성해서 인스턴스 소멸할 때 까지의 생명주기
//	 인스턴스 변수는 클래스 맴버들이 참조 가능.
//	 변수, 메소드

	int iv; // 인스턴스 변수 : 자동 초기화.
	int iv2 = iv;

	void InstanceMethod(int num) {
		System.out.println(iv);
		// 참조변수.변수

	}

	void InstanceMethod2(int num) {
		System.out.println(iv);
		// 참조변수.변수
	}

	public static void main(String[] args) {
		InstanceVariable iv = new InstanceVariable();
		System.out.println(iv.iv);
		
		iv = null;
		
		
//		System.out.println(iv.iv);

	}

}
