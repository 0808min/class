package chapter08;

public class OuterClass2 {

	private String name;

	public OuterClass2(String name) {
		this.name = name;
	}

	public BasicClass createLocalClassInstance() {
		
//		로컬클래스 : 메소드 내부에 선언되어 사용하는 클래스
//		외부클래스에서는 내부클래스를 참조할수없다
//		상속의 구조로 다형성을 이용해서 외부에서 사용할수 있도록 정의
		class LocalClass extends BasicClass {
			void tell() {
				System.out.println("안녕하세요 " + name + "입니다.");
			}

		}
		
		return new LocalClass();
		
//		메소드 내부에서 내부 클래스를 이용한 인스턴스 생성 가능
//		new LocalClass().tell();
	}
	public static void main(String[] args) {
		
		OuterClass2 o = new OuterClass2("King");
		
		BasicClass localClassInst =  o.createLocalClassInstance();
		
		localClassInst.tell();
		
	}

}

abstract class BasicClass {
	
	abstract void tell();
	
}
