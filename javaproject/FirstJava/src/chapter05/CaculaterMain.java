package chapter05;

import java.util.Scanner;

public class CaculaterMain {
	
	public static void main(String[] args) {
		
//		더하기 곱하기하는 프로그램
		Calculator cal = new Calculator();
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("숫자 1 >> ");
		int num1 = in.nextInt();
		
		System.out.println();
		
		System.out.print("숫자 2 >> ");
		int num2 = in.nextInt();
		 
//		더하기 곱하기 연산의 결과
		
		System.out.println();
		System.out.println("더하기 곱하기 연산의 결과");
		System.out.println("num1 + num2 = " + cal.add(num1, num2));
		System.out.println("num1 * num2 = " + cal.multifly(num1, num2));
		
		System.out.println("------------------------");
		System.out.println("오버로딩 테스트");
		System.out.println("num1 + num2 = " + cal.add(1, 2));
		System.out.println("num1 + num2 = " + cal.add(1L, 2L));
		System.out.println("num1 + num2 = " + cal.add(1F, 2F));
		
		
	}

}
