package chapter03.Exam;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("숫자 1을 입력해주세요.>>> ");
		int num1 = in.nextInt();
		
		System.out.println();
		
		System.out.println("숫자 2를 입력해주세요.>>> ");
		int num2 = in.nextInt();
		
		System.out.println("사칙연산의 결과 ========");
		addResultPrint(num1, num2);
		substractResultPrint(num1, num2);
		multiflyResultPrint(num1, num2);
		divideResultPrint(num1, num2);
		
		////////////////////////////////////////////
		
		System.out.println("원의 반지름을 입력해주세요.>>> ");
		double rad = in.nextDouble();
		
		System.out.println();
		
		System.out.println("원의 둘레 : " + circum(rad));
		System.out.println("원의 넓이 : " + area(rad));
 // 더하기 add 뺴기 substract 곱하기 multifly 나누기 divide 둘레 circum 넓이 area
		
	}
	
	
	
	//* 실수 반지름 하나를 매개변수의 인자로 전달받아 원의 둘레를 구해 반환하는 메소드를 반환하는 메소드를 정의 
	
	public static double circum(double r) {
		 // 원의 둘레 : 2 * 3.14 * r
		return 2 * 3.14 * r ;
		
	}
	//  * 실수 반지름 하나를 매개변수의 인자로 전달받아 원의 넓이를 구해 반환하는 메소드를 반환하는 메소드를 정의
	
	public static double area(double r) {
		// 원의 넓이 : 3.14*r*r
		return 3.14 * r * r ;
		
	}
	
	
	// 정수 두 개를 매개변수의 인자로 전달받아 더하기연산 후 출력하는 메소드의 정의 
	public static void addResultPrint(long num1, long num2) {
		
		System.out.println("두 수의 덧셈 결과 : " + (num1 + num2)); // 두 수의 덧셈 결과 : 1
		
		
	}
	// * 정수 두 개를 매개변수의 인자로 전달받아 / 빼기연산 후 출력하는 / 메소드의 정의 

	public static void substractResultPrint(long num1, long num2) {
		System.out.println("두 수의 뺄셈 결과 : " + (num1 - num2));
		
		// 정수 두 개를 매개변수의 인자로 전달받아 / 곱하기 연산 후 출력하는 / 메소드의 정의
	}
	
	public static void multiflyResultPrint(long num1, long num2) {
		System.out.println("두 수의 곱셈 결과 : " + (num1 * num2));

		// 정수 두 개를 매개변수의 인자로 전달받아 / 나누기 연산 후 출력하는 / 메소드의 정의
	}
	public static void divideResultPrint(double num1, double num2) {
		System.out.println("두 수의 나눗셈 결과 : " + (num1 / num2));
	}
	
}

