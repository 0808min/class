package chapter06;

public class ArrayTest7 {

	public static void main(String[] args) {

//		Math.random() : 반환타입 double 0.0
//		0.0보다 <= Math.random() < 1
//		0~9까지 뽑고싶다면
//		0.0 * 10 <= Math.random() * 10 < 1 * 10
//		0.0 <= Math.random() * 10 < 10
//		0.0 <= r <= 9.99999999999?
//		0.0 * 10 <= (int)(Math.random()) * 10 ) < 1 * 10
//      0.0 <= r <= 9

		System.out.println(Math.random());
		System.out.println((int) (Math.random() * 10));
		System.out.println();

		String[] players = { "손흥민", "박지성", "차범근", "안정환", "차두리" };
		
//		0번지의 값과 1번지 값을 치환
		
		for(int i=0; i<10000; i++) {
			
		}
		
//		1~4
//		0 <= <= 3
//		1 <= <= 4
		int randomIndex = (int)(Math.random()*4) + 1;
		
		String temp = null;
		temp = players[0];
		players[0] = players[randomIndex];
		players[randomIndex] = temp;
		
		System.out.println(players[0]);
		System.out.println(players[1]);
		System.out.println();

		// index : 0~4
		int index = (int) (Math.random() * 5);
		String pickName = players[index];
		System.out.println(pickName);
		

	}

}
