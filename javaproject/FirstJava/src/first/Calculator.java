package first;

public class Calculator {

	public static void main(String[] args) {
		
		System.out.println("10+20=" + add(10,20) );  // 10+20=30
		
		System.out.println("20-10=" + substract(20,10) );  // 20-10=10
		
		System.out.println("32*42=" + multifly(32,42)); 
		
		System.out.println("10/4=" + divide(10,4));
		/*
		      1.숫자 두개를 매개변수의 인자로 전달받아 더하기 메소드를 추가합니다.
		      2.숫자 두개를 매개변수의 인자로 전달받아 빼기 메소드를 추가합니다.
		      3.숫자 두개를 매개변수의 인자로 전달받아 곱하기 메소드를 추가합니다.
		      4.숫자 두개를 매개변수의 인자로 전달받아 나누기 메소드를 추가합니다.   
		 */

	}
	// 1.숫자 두개를 매개변수의 인자로 전달받아 더하기 메소드를 추가합니다.
	
	public static long add(long num1, long num2) {
		//long result = num1 + num2;
		//return result;
		return num1+num2;
		
	}
	// 2.숫자 두개를 매개변수의 인자로 전달받아 빼기 메소드를 추가합니다.
	
	public static long substract(long num1, long num2) {
		
		return num1-num2;
	}
	// 3.숫자 두개를 매개변수의 인자로 전달받아 곱하기 메소드를 추가합니다.
	
	public static long multifly(long num1, long num2) {
		
		return num1*num2;
	}
	// 4.숫자 두개를 매개변수의 인자로 전달받아 나누기 메소드를 추가합니다.
	
	public static double divide(double num1, double num2) {
		
		return num1 / num2;
	}
	

}
