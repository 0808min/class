package first;

import java.util.Scanner;

public class ScannerTest {
	
	public static void main(String[] args) {
		
		
		//java.util.Scanner in = new java.util.Scanner(System.in);
		Scanner in = new Scanner(System.in);
		
		System.out.print("이름을 입력해주세요.>>> ");
		
		String name = in.nextLine();  // 문자열 반환
		
		System.out.println("이름 : " + name);
		
		System.out.print("나이를 입력해주세요.>>> ");
		
		int age = in.nextInt();
		
		System.out.println("나이 : " + age);
	}

}
