package chapter08;

public abstract class Phone1 {

	String phoneNumber;
	boolean power;// false, 전원

	public Phone1(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		this.power = false;
	}

	void call() {
		System.out.println("전화 걸기!");
	}

	// 추상메소드로 정의
	abstract void turnOn();
}