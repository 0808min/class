package chapter09.exam;

import java.util.Scanner;

public class Exam3Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("이름을 입력하세요 >>");
		String name = sc.nextLine();

//		if(name.trim().length()==0) 
		if (name.trim().isEmpty()) {
			System.out.println("공백은 허용되지 않습니다");
		} else {
			if (checkName(name)) {
			} else {
				System.out.println("이름은 영문자 대소문자만 입력이 가능합니다");
			}
		}

		System.out.println(name);

		if (checkName(name)) {
			System.out.println(name);

		} else {
			System.out.println("이름은 영문자 대소문자만 입력이 가능합니다.");
		}

	}

	static boolean checkName(String name) {

		boolean result = true;

//		t e 1 s t
//		문자열의 각 문자를 비교해서 원하는 문자 타입이 아닐때 탈출 결과값은 false 
//		charAt(i)
		for (int i = 0; i < name.length(); i++) {

			char c = name.charAt(i);
//			영문자 : 대문자 소문자
			if (!(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z')) {
				result = false;
				break;
			}

		}

		return result;
	}

}
