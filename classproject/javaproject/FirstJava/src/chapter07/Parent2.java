package chapter07;

public class Parent2 {

	int num = 100;
	
	void print() {
		System.out.println("상위 클래스에서 출력하는 값" + num);
	}

}

// Parent 클래스를 상속하는 Child 클래스
// 상속할 때는 extends 키워드를 사용
// 상속을 하는 목적은 새로운 클래스를 정의

class Child2 extends Parent2 {

//	새로운 변수, 메소드 등을 정의
//	상위 클래스에서 정의한 메소드를 재정의 : 메소드의 오버라이딩

	int num = 200;

	void print(int num) {
		
		System.out.println("상위 클래스에서 정의한 num" + super.num);
		System.out.println("현재 인스턴스에서 정의한 num" + this.num);
		System.out.println("메소드의 매개변수에서 정의한 num" + num);
	
 
	}
	
	
		

}