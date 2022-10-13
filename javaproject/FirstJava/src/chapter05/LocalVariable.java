package chapter05;

public class LocalVariable {

	void method(int num) {
		// 매개변수도 지역변수

		int lv = 10; // 메소드 내부에서 선언되는 변수도 지역변수다.

		if (num > 10) {
			boolean check = true;
		} else {
			boolean check = false;
		}

//		int lv = 100;

		for (int i = 0; i < 10; i++) {
//			i는 for 블록안에서만 사용가능한 지역변수
			System.out.println(num++);
		}
		
//		System.out.println(i);

		while (lv < 0) {
			int lv2 = 0;
			System.out.println(num++);
		}

//		System.out.println(lv2);

	}

	public static void main(String[] args) {

		LocalVariable lv = new LocalVariable();
		lv.method(0);

	}

}
