package Test.A;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exam10 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("숫자를 입력하세요. >> ");

		int num = 0;

		try {
			num = sc.nextInt();
			System.out.println("num = " + num);

		} catch (InputMismatchException e) {

			System.out.println("예외발생");
			System.out.println("정상적인 숫자를 입력해주세요.");
		}

	}

}
