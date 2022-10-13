package chapter04;

public class ContinueTest {

	public static void main(String[] args) {
		
		//1~9 사이의 홀수 만 출력
		
		int num = 0;
		
		while(++num<10) {
			
			if(num%2 == 0) {
				continue;
				
			}
			
			System.out.println(num);
			
			// num++;
		}

	}

}
