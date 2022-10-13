package chapter04;

public class IfTest {
	
	public static void main(String[] args) {
		
		int score = 69;
		
		// 60점 이상이면 PASS를 출력하자.
		if(score>=60) {
			// 조건식의 결과가 true 일때 처리되는 구문
			System.out.println("PASS");
		}
		
		// 60점 이상이면 PASS출력, 60점 미만이면 FAIL 출력
		
		if(score>=60) {
			
			System.out.println("PASS");
		} else {
			// 조건식의 결과가 false일 떄 처리되는 구문
			System.out.println("FAIL");
		}
		
		// 90점 이상이면 A 출력 
		// 80점 이상이면 1을 B 
		// 70점 이상 C  
		// 나머지 FAIL
		if(score>=90) {
			System.out.println("A");
		} else if( score >= 80){  // 80 <= score < 90
			System.out.println("B");
		} else if(score >= 70){ // 0 ~ 79 
			System.out.println("C");
		} else { //0 ~ 69
			System.out.println("FAIL");

		}
	
		
	}

}
