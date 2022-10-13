package chapter04;

public class DowhileLoop {
	
	public static void main(String[] args) {
		
		// do while : 먼저 한번 반드시 처리한 후 반복해야할 경우
		
		int cnt = 0;
		do {
			// 반복 할 문장
			System.out.println("JAVA" + cnt);
			cnt++;
		} while(cnt < 0);
		
	}

}
