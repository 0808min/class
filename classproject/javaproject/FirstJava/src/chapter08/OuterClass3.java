package chapter08;

public class OuterClass3 {

	private String name;

	OuterClass3(String name) {
		this.name = name;

	}

	public BasicClass createLocalClassInstance() {

//		익명클래스 : 이름없이 정의되는 클래스
//		한번 인스턴스 생성 후 재사용이 없는 경우
//		new 추상클래스() {추상메소드 구현};
//		new 인터페이스() {추상메소드 구현};
		return new BasicClass() {
			void tell() {
				System.out.println("안녕하세요" + name + "입니다.");
			}

		};

	}

}
