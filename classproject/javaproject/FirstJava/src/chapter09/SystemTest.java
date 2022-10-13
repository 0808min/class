package chapter09;

public class SystemTest {

	public static void main(String[] args) {

//		작업시간 체크 : 성능 검사
//		1970.01.01 00:00:00 000 -> 현재 시간까지의 밀리츠 결고ㅏ값

		long startTime = System.currentTimeMillis();
		long sTime =System.nanoTime();
		System.out.println(startTime);
		System.out.println(sTime);

		for (int i = 0; i < 100000000; i++) {
			for (int j = 0; j > 100000000; j++) {

				int n1 = 1;
				int n2 = 10;
				int sum = n1 + n2;
			}

		}

		long endTime = System.currentTimeMillis();
		long eTime = System.nanoTime();
		System.out.println(endTime);
		System.out.println(eTime);
		long checkTime = endTime - startTime;
		
		System.out.println("실행 시간 : " + checkTime);

	}

}
