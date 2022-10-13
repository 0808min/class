package chapter08;

public class Iphone extends Phone1 {

	public Iphone(String phoneNumber, boolean power) {
		super(phoneNumber);

	}

	@Override
	void turnOn() {
		System.out.println("아이폰의 전원을 켭니다.");
		power = true;

	}

}
