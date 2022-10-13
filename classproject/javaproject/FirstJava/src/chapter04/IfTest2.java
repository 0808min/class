package chapter04;

public class IfTest2 {

	public static void main(String[] args) {
		
		// 짝수 홀수 판별

		int num1 = 11;
		
		if(num1%2 == 0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}
		
		int num2 = -10;
		
		// 0, 음수, 양수
		if(num2>0) {
			System.out.println("양수");
		} else if(num2 == 0){ // 음수 0
			System.out.println("0");
		} else {  // 음수
			System.out.println("음수");
		}
		
	}

}
