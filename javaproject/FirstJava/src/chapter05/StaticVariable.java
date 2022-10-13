package chapter05;

public class StaticVariable {

	static int cv;
	int iv;

//	상수 : 변하지 않는 수 = final 키워드를 써준다
//	상수의 식별자는 모두 대문자로 사용한다.
	static final float PI = 3.14f;

	public static void main(String[] args) {

		System.out.println(cv);
//		System.out.println(iv);

	}

}
