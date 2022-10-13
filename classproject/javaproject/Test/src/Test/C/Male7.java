package Test.C;

public class Male7 extends PersonExam7 {

	String nickName;

	Male7(String name, String pNum, String nickName) {
		super(name, pNum);
		this.nickName = nickName;

	}

	void hi() {
		System.out.println("안녕하세요");
	}

	@Override
	void printInfo() {
		super.printInfo();
		System.out.println("별명은 " + nickName + " 입니다.");
	}

}
