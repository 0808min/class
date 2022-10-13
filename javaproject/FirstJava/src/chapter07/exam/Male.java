package chapter07.exam;

//Person 클래스를 상속해서 확장하는 새로운 클래스 Male

public class Male extends Person {

//	Person 클래스를 상속해서 확장하는 새로운 클래스 Male 클래스와 Female 클래스를 정의 해봅시다. 
//	① 각 클래스는 상속 받은 멤버 외에 추가적인 변수와 메소드를 추가해서 새로운 클래스를 정의해봅시다.
//	② 각 클래스는 상속 받은 멤버 외에 추가적인 변수와 메소드를 추가해서 새로운 클래스를 정의해봅시다.
//	③ Person 클래스에서 정의된 인사하는 메소드를 오버라이딩 해봅시다.
//	④ Person 클래스에 생성자를 정의해서 인스턴스 변수들을 초기화 해봅시다

	String nickName;

	Male(String name, String pNum, String nickName) {
		super(name, pNum);
		this.nickName = nickName;

	}

	void hi() {
		System.out.println("안녕하세요.");
	}

	@Override
	void printInfo() {
		super.printInfo();
		System.out.println("별명은 " + nickName + "입니다.");
	}

}
