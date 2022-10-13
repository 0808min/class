package chapter05;

public class StaticMethod {

	static int num1 = 10; // 클래스 변수
	int num2; // 인스턴스 변수

	static void staticMethod() {
		System.out.println("staticMethod");
//		System.out.println(num2);  인스턴스 생성없이 사용이 블가

//		클래스 맴버에 인스턴스 맴버는 사용 불가.
		StaticMethod sm = new StaticMethod();
		sm.instansMethod();
	}

	void instansMethod() {
		System.out.println("instansMethod");
		System.out.println(num1);
		staticMethod();
	}

}
