package Test.A;

import java.util.regex.Pattern;

public class Exam10Test {
	
	public static void main(String[] args) {
		
		String str = "123";
		
		boolean chk1 = Pattern.matches("^[123]*$", str); // ^ <= 패턴의 시작, $ <= 패턴의 종류 
		System.out.println(chk1);
		
//		핸드폰번호 : ^\d{3}-\d{4}-d{4}
	}

}
