package chapter10;

import java.util.Scanner;

public class ExcptionCatchTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("숫자 1을 입력하세요.>> ");
		int num1 = sc.nextInt();

		System.out.print("숫자 2를 입력하세요.>> ");
		int num2 = sc.nextInt();

		try {
			System.out.println("num1 / num2 = " + num1 / num2); // <- 예외가 발생할 수 있는 위치
			String str = null;
			System.out.println(str.length());

		} catch (ArithmeticException e) {
			System.out.println("0으로 나누는것은 불가합니다.");
			e.printStackTrace();
			System.out.println(e.getMessage());
			return;
		} catch (NullPointerException e) {
			System.out.println("null");
		} catch (Exception e) {
			System.out.println("예외발생");
			e.printStackTrace();
		} finally {
			System.out.println("무조건 실행하는 블럭입니다.");

			
		}
		
//		try{} finally{}, try{} catch{}, try{} catch{} finally{}
		
		System.out.println("프로그램을 처리 완료.");

	}

}
