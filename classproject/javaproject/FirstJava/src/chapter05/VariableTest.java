package chapter05;

public class VariableTest {

	int iv = StaticVariable.cv;
	int iv2;

	static int cv;

	public static void main(String[] args) {

//		클래스 변수를 참조할 떄는 클래스이름.변수이름
		System.out.println(StaticVariable.cv);
		System.out.println(StaticVariable.PI);

	}

}

