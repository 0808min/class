package chapter05.modifier;

public class PrivateTest {

	private String name;
	private int age;

	public PrivateTest() {
		this.name = "박민";
		this.age = 32;
	}

	public void showInfo() {
		System.out.println("이름 : " + this.name);
		System.out.println("나이 : " + this.age);
	}

}
